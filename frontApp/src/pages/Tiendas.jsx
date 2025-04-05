import React, { useEffect, useState } from "react";
import { MapContainer, TileLayer, Marker, Popup } from "react-leaflet";
import "leaflet/dist/leaflet.css";
import L from "leaflet";
import useUserLocation from "../hooks/useUserLocation";
import { obtenerCoordenadasDesdeDireccion } from "../utils/geolocalizacion";
import { calcularTiempoLlegada } from "../utils/ruta";
import TiendaCard from "../components/TiendaCard";
import FiltroBarrios from "../components/FiltroBarrios";

function Tiendas() {
  const [tiendas, setTiendas] = useState([]);
  const [filtroBarrio, setFiltroBarrio] = useState("");
  const userCoords = useUserLocation();

  useEffect(() => {
    const fetchTiendas = async () => {
      try {
        const response = await fetch("http://localhost:8080/tiendas");
        const data = await response.json();

        const tiendasConUbicacion = await Promise.all(
          data.map(async (tienda) => {
            const coords = await obtenerCoordenadasDesdeDireccion(`${tienda.direccion}, ${tienda.ciudad}`);
            let distancia = "";
            if (coords && userCoords) {
              const duracion = await calcularTiempoLlegada(userCoords, coords);
              distancia = duracion;
            }
            return { ...tienda, coords, distancia };
          })
        );

        setTiendas(tiendasConUbicacion);
      } catch (error) {
        console.error("Error al cargar tiendas:", error);
      }
    };

    if (userCoords) fetchTiendas();
  }, [userCoords]);

  const tiendasFiltradas = filtroBarrio
    ? tiendas.filter((tienda) => tienda.barrio === filtroBarrio)
    : tiendas;

  return (
    <div className="p-4">
      <h2 className="text-2xl font-bold mb-4 text-green-700">Tiendas Registradas</h2>

      <FiltroBarrios tiendas={tiendas} setFiltroBarrio={setFiltroBarrio} />

      <div className="grid md:grid-cols-2 lg:grid-cols-3 gap-4 mb-8">
        {tiendasFiltradas.map((tienda, i) => (
          <TiendaCard key={i} tienda={tienda} />
        ))}
      </div>

      {/* Mapa con Leaflet */}
      {userCoords && (
        <MapContainer
          center={[userCoords.lat, userCoords.lon]}
          zoom={13}
          scrollWheelZoom={true}
          style={{ height: "500px", width: "100%" }}
        >
          <TileLayer
            attribution='&copy; <a href="https://osm.org/copyright">OpenStreetMap</a>'
            url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
          />
          <Marker position={[userCoords.lat, userCoords.lon]}>
            <Popup>Tu ubicación</Popup>
          </Marker>
          {tiendasFiltradas.map(
            (tienda, i) =>
              tienda.coords && (
                <Marker key={i} position={[tienda.coords.lat, tienda.coords.lon]}>
                  <Popup>
                    {tienda.nombre}
                    <br />
                    {tienda.direccion}
                    <br />
                    {tienda.distancia}
                  </Popup>
                </Marker>
              )
          )}
        </MapContainer>
      )}
    </div>
  );
}

export default Tiendas;