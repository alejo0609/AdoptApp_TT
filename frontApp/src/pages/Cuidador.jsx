import React, { useEffect, useState } from "react";
import { MapContainer, TileLayer, Marker, Popup, Polyline } from "react-leaflet";
import "leaflet/dist/leaflet.css";
import L from "leaflet";
import useUserLocation from "../hooks/useUserLocation";
import FiltroBarrios from "../components/FiltroBarrios";

const cuidadorSimulados = [
  {
    nombre: "Cuidador 1",
    direccion: "Calle 67 # 53-108",
    barrio: "Sevilla",
    ciudad: "Medellín",
    telefono: "3011111111",
    email: "cuidador1@mail.com",
    imagen: "https://randomuser.me/api/portraits/women/10.jpg",
    descripcion: "Amante de los animales con 5 años de experiencia.",
    coords: { lat: 6.2678, lon: -75.5665 },
    calificacion: "4.6",
  },
  {
    nombre: "Cuidador 2",
    direccion: "Carrera 52 # 67-90",
    barrio: "Manrique",
    ciudad: "Medellín",
    telefono: "3022222222",
    email: "cuidador2@mail.com",
    imagen: "https://randomuser.me/api/portraits/men/12.jpg",
    descripcion: "Ofrezco cuidado canino en casa. Seguro y amoroso.",
    coords: { lat: 6.2669, lon: -75.5689 },
    calificacion: "4.5",
  },
  {
    nombre: "Cuidador 3",
    direccion: "Calle 67A # 51-60",
    barrio: "Aranjuez",
    ciudad: "Medellín",
    telefono: "3033333333",
    email: "cuidador3@mail.com",
    imagen: "https://randomuser.me/api/portraits/women/14.jpg",
    descripcion: "Paseadora profesional de perros y cuidadora felina.",
    coords: { lat: 6.2684, lon: -75.5702 },
    calificacion: "4.7",
  },
  // ... puedes completar los otros 7 con datos similares
];

function Cuidador() {
  const [cercanos, setCercanos] = useState([]);
  const [rutas, setRutas] = useState([]);
  const [filtroBarrio, setFiltroBarrio] = useState("");
  const userCoords = useUserLocation();

  useEffect(() => {
    if (userCoords) {
      const filtrados = cuidadorSimulados.filter((c) =>
        filtroBarrio
          ? c.barrio.toLowerCase().includes(filtroBarrio.toLowerCase())
          : true
      );

      const conDistancia = filtrados.map((cuidador) => {
        const distancia = Math.sqrt(
          Math.pow(userCoords.lat - cuidador.coords.lat, 2) +
          Math.pow(userCoords.lon - cuidador.coords.lon, 2)
        );
        return { ...cuidador, distancia };
      });

      const cercanosOrdenados = conDistancia
        .sort((a, b) => a.distancia - b.distancia)
        .slice(0, 10);

      setCercanos(cercanosOrdenados);
    }
  }, [userCoords, filtroBarrio]);

  useEffect(() => {
    if (userCoords && cercanos.length > 0) {
      const nuevasRutas = cercanos.map((cuidador) => {
        const start = [userCoords.lat, userCoords.lon];
        const end = [cuidador.coords.lat, cuidador.coords.lon];
        const path = [start, end];

        const R = 6371;
        const dLat = ((end[0] - start[0]) * Math.PI) / 180;
        const dLon = ((end[1] - start[1]) * Math.PI) / 180;
        const a =
          Math.sin(dLat / 2) * Math.sin(dLat / 2) +
          Math.cos((start[0] * Math.PI) / 180) *
          Math.cos((end[0] * Math.PI) / 180) *
          Math.sin(dLon / 2) * Math.sin(dLon / 2);
        const c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        const distanciaKm = R * c;
        const tiempoMinutos = Math.round((distanciaKm / 5) * 60);

        return {
          cuidador,
          path,
          tiempoMinutos,
          distanciaKm: distanciaKm.toFixed(2),
        };
      });

      setRutas(nuevasRutas);
    }
  }, [cercanos, userCoords]);

  const generarWhatsAppLink = (telefono, nombre) => {
    const mensaje = encodeURIComponent(`¡Hola ${nombre}! Estoy interesado/a en tus servicios de cuidado de mascotas 🐶🐱`);
    return `https://wa.me/57${telefono}?text=${mensaje}`;
  };

  return (
    <div className="p-4">
      <h2 className="text-2xl font-bold mb-4 text-green-700">Cuidadores Cercanos</h2>

      <FiltroBarrios tiendas={cuidadorSimulados} setFiltroBarrio={setFiltroBarrio} />

      {userCoords && (
        <MapContainer
          center={[userCoords.lat, userCoords.lon]}
          zoom={14}
          scrollWheelZoom={true}
          style={{ height: "500px", width: "100%" }}
        >
          <TileLayer
            attribution='&copy; <a href="https://osm.org/copyright">OpenStreetMap</a>'
            url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
          />

          <Marker
            position={[userCoords.lat, userCoords.lon]}
            icon={new L.Icon({
              iconUrl: 'https://upload.wikimedia.org/wikipedia/commons/5/52/Red_dot_icon.svg',
              iconSize: [40, 40],
              iconAnchor: [20, 40],
              popupAnchor: [0, -40],
            })}
          >
            <Popup>Tu ubicación</Popup>
          </Marker>

          {rutas.map((ruta, index) => (
            <React.Fragment key={index}>
              <Polyline positions={ruta.path} />
              <Marker position={[ruta.cuidador.coords.lat, ruta.cuidador.coords.lon]}>
                <Popup>
                  <strong>{ruta.cuidador.nombre}</strong><br />
                  {ruta.cuidador.direccion}<br />
                  Barrio: {ruta.cuidador.barrio}<br />
                  Calificación: {ruta.cuidador.calificacion}<br />
                  Distancia: {ruta.distanciaKm} km<br />
                  Tiempo estimado: {ruta.tiempoMinutos} min
                </Popup>
              </Marker>
            </React.Fragment>
          ))}
        </MapContainer>
      )}

      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6 mt-6">
        {cercanos.map((c) => (
          <div key={c.email} className="border rounded-lg shadow-md p-4 flex flex-col items-center bg-white">
            <img
              src={c.imagen}
              alt={c.nombre}
              className="w-24 h-24 rounded-full object-cover mb-2"
            />
            <h3 className="text-xl font-semibold">{c.nombre}</h3>
            <p className="text-sm text-gray-600">{c.barrio} - {c.direccion}</p>
            <p className="text-center mt-2 text-sm italic">{c.descripcion}</p>
            <p className="text-yellow-600 mt-2 font-semibold">⭐ {c.calificacion}</p>
            <a
              href={generarWhatsAppLink(c.telefono, c.nombre)}
              target="_blank"
              rel="noopener noreferrer"
              className="mt-3 bg-green-500 text-white px-4 py-2 rounded hover:bg-green-600 transition"
            >
              Contactar por WhatsApp
            </a>
          </div>
        ))}
      </div>
    </div>
  );
}

export default Cuidador;