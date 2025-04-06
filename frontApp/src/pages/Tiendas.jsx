import React, { useEffect, useState } from "react";
import { MapContainer, TileLayer, Marker, Popup, Polyline } from "react-leaflet";
import "leaflet/dist/leaflet.css";
import L from "leaflet";
import useUserLocation from "../hooks/useUserLocation";
import { obtenerCoordenadasDesdeDireccion } from "../utils/geolocalizacion";
import { calcularTiempoLlegada } from "../utils/ruta";
import TiendaCard from "../components/TiendaCard";
import FiltroBarrios from "../components/FiltroBarrios";

function Tiendas() {
  const [tiendas, setTiendas] = useState([]);
  const [filtroBarrio, setFiltroBarrio] = useState(""); // Filtro para el barrio
  const userCoords = useUserLocation(); // Coordenadas del usuario
  const [distancias, setDistancias] = useState({});

  const apiKey = '5b3ce3597851110001cf6248da0e4d7f8605486d814ad13a1a1ba21f'; // clave de API

  useEffect(() => {
    const fetchTiendas = async () => {
      try {
        const response = await fetch("http://localhost:8080/tiendas");
        const data = await response.json();

        const tiendasConUbicacion = await Promise.all(
          data.map(async (tienda) => {
            const coords = await obtenerCoordenadasDesdeDireccion(`${tienda.direccion}, ${tienda.ciudad}`);
            return { ...tienda, coords };
          })
        );

        setTiendas(tiendasConUbicacion);
      } catch (error) {
        console.error("Error al cargar tiendas:", error);
      }
    };

    if (userCoords) fetchTiendas();
  }, [userCoords]);

  // Filtrar las tiendas por el barrio, ignorando mayúsculas/minúsculas
  const tiendasFiltradas = filtroBarrio
    ? tiendas.filter((tienda) =>
        tienda.barrio.toLowerCase().includes(filtroBarrio.toLowerCase())
      )
    : tiendas;

  // Función para calcular la distancia entre el usuario y cada tienda (en minutos)
  const calcularDistancia = async (tiendaCoords) => {
    if (!userCoords || !tiendaCoords) return "Cargando..."; // Verifica que las coordenadas estén presentes
    console.log("Cálculo de distancia entre", userCoords, "y", tiendaCoords); // Depuración
    const duracion = await calcularTiempoLlegada(userCoords, tiendaCoords);
    return `${Math.round(duracion)} minutos`; // Redondear a un número entero
  };

  // Calcular todas las distancias una vez que las tiendas y la ubicación del usuario estén listas
  useEffect(() => {
    const obtenerDistancias = async () => {
      const nuevasDistancias = {};
      for (let tienda of tiendas) {
        if (tienda.coords) {
          const distancia = await calcularDistancia(tienda.coords);
          nuevasDistancias[tienda.nombre] = distancia;
        }
      }
      setDistancias(nuevasDistancias);
    };

    if (tiendas.length > 0 && userCoords) {
      obtenerDistancias();
    }
  }, [tiendas, userCoords]);

  // Agregar un log para verificar las coordenadas del usuario
  useEffect(() => {
    if (userCoords) {
      console.log("Coordenadas del usuario:", userCoords); // Depuración
    }
  }, [userCoords]);

  // Función para calcular el tiempo de llegada con la API de OpenRouteService
  const calcularTiempoLlegada = async (startCoords, endCoords) => {
    if (!startCoords || !endCoords || !startCoords.lat || !startCoords.lon || !endCoords.lat || !endCoords.lon) {
      console.error('Coordenadas inválidas:', startCoords, endCoords);
      return 'Coordenadas inválidas';  // Retorna un mensaje si las coordenadas son inválidas
    }

    const url = `https://api.openrouteservice.org/v2/directions/driving-car?api_key=${apiKey}&start=${startCoords.lon},${startCoords.lat}&end=${endCoords.lon},${endCoords.lat}`;

    try {
      console.log('URL de la solicitud:', url);  // Verifica que la URL sea correcta
      const response = await fetch(url);
      const data = await response.json();

      if (!response.ok) {
        throw new Error(`Error al calcular la ruta: ${data.error.message}`);
      }

      return Math.round(data.features[0].properties.segments[0].duration / 60);  // Convertir de segundos a minutos y redondear
    } catch (error) {
      console.error('Error al calcular tiempo de llegada:', error);
      return 'Error al calcular tiempo';  // Retorna un mensaje en caso de error
    }
  };

  return (
    <div className="p-4">
      <h2 className="text-2xl font-bold mb-4 text-green-700">Tiendas Registradas</h2>

      {/* Filtro por barrios */}
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
          
          {/* Marcador de la ubicación del usuario */}
          <Marker
            position={[userCoords.lat, userCoords.lon]}
            icon={new L.Icon({
              iconUrl: 'https://upload.wikimedia.org/wikipedia/commons/5/52/Red_dot_icon.svg', // URL del icono
              iconSize: [40, 40], // Tamaño del icono
              iconAnchor: [20, 40], // Anclaje del icono
              popupAnchor: [0, -40], // Donde se coloca el popup en relación al icono
            })}
          >
            <Popup>Tu ubicación</Popup>
          </Marker>

          {/* Marcadores de las tiendas */}
          {tiendasFiltradas.map(
            (tienda, i) =>
              tienda.coords && (
                <Marker key={i} position={[tienda.coords.lat, tienda.coords.lon]}>
                  <Popup>
                    {tienda.nombre}
                    <br />
                    {tienda.direccion}
                    <br />
                    {distancias[tienda.nombre] || "Cargando..."}
                  </Popup>
                </Marker>
              )
          )}

          {/* Líneas entre el usuario y las tiendas */}
          {tiendasFiltradas.map(
            (tienda, i) =>
              tienda.coords && (
                <Polyline
                  key={i}
                  positions={[ 
                    [userCoords.lat, userCoords.lon], 
                    [tienda.coords.lat, tienda.coords.lon] 
                  ]}
                  color="blue"
                >
                  <Popup>{`Distancia: ${distancias[tienda.nombre] || "Cargando..."}`}</Popup>
                </Polyline>
              )
          )}
        </MapContainer>
      )}
    </div>
  );
}

export default Tiendas;