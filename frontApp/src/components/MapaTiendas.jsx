
import React, { useEffect, useState } from "react";
import { MapContainer, TileLayer, Marker, Popup, useMap } from "react-leaflet";
import L from "leaflet";
import "leaflet/dist/leaflet.css";
import axios from "axios";

// Ajustar el ícono por defecto
delete L.Icon.Default.prototype._getIconUrl;
L.Icon.Default.mergeOptions({
  iconRetinaUrl: require("leaflet/dist/images/marker-icon-2x.png"),
  iconUrl: require("leaflet/dist/images/marker-icon.png"),
  shadowUrl: require("leaflet/dist/images/marker-shadow.png"),
});

function MapaTiendas() {
  const [ubicacionUsuario, setUbicacionUsuario] = useState(null);
  const [tiendas, setTiendas] = useState([]);

  useEffect(() => {
    navigator.geolocation.getCurrentPosition(
      (position) => {
        setUbicacionUsuario([position.coords.latitude, position.coords.longitude]);
      },
      (error) => {
        console.error("Error obteniendo ubicación:", error);
        setUbicacionUsuario([6.2442, -75.5812]); // Medellín por defecto
      }
    );
  }, []);

  useEffect(() => {
    axios.get("http://localhost:8080/tiendas").then((res) => {
      setTiendas(res.data);
    });
  }, []);

  const MoverMapa = ({ ubicacion }) => {
    const map = useMap();
    useEffect(() => {
      if (ubicacion) {
        map.setView(ubicacion, 13);
      }
    }, [ubicacion, map]);
    return null;
  };

  return (
    <div className="h-[500px] w-full">
      <MapContainer center={[6.2442, -75.5812]} zoom={12} className="h-full w-full">
        <TileLayer
          attribution='&copy; <a href="http://osm.org/copyright">OpenStreetMap</a>'
          url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
        />
        {ubicacionUsuario && (
          <Marker position={ubicacionUsuario}>
            <Popup>Tu ubicación</Popup>
          </Marker>
        )}
        {tiendas.map((tienda, idx) => (
          <Marker
            key={idx}
            position={[tienda.latitud, tienda.longitud]} // solo si has guardado coordenadas
          >
            <Popup>
              <strong>{tienda.nombre}</strong>
              <br />
              {tienda.direccion}
            </Popup>
          </Marker>
        ))}
        <MoverMapa ubicacion={ubicacionUsuario} />
      </MapContainer>
    </div>
  );
}

export default MapaTiendas;
