import React, { useEffect, useState } from 'react';
import { MapContainer, TileLayer, Marker, Popup } from 'react-leaflet';
import L from 'leaflet';
import useUserLocation from '../hooks/useUserLocation'; // Hook para obtener la ubicación del usuario

const MapaCuidadores = () => {
  const [cuidadores, setCuidadores] = useState([]);
  const userCoords = useUserLocation(); // Obtiene las coordenadas del usuario

  // Datos de los 20 cuidadores
  const datosCuidadores = [
    { nombre: 'Cuidador 1', coords: { lat: 6.2041, lon: -75.5863 }, telefono: '123456789' },
    { nombre: 'Cuidador 2', coords: { lat: 6.2011, lon: -75.5890 }, telefono: '123456789' },
    // Agrega los datos de los demás cuidadores aquí
  ];

  useEffect(() => {
    // Lógica para obtener los datos de los cuidadores desde tu API o base de datos
    setCuidadores(datosCuidadores);
  }, []);

  return (
    <div style={{ height: '500px', width: '100%' }}>
      {userCoords && (
        <MapContainer center={[userCoords.lat, userCoords.lon]} zoom={13} style={{ height: '100%', width: '100%' }}>
          <TileLayer
            url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
            attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
          />
          {/* Marcador de la ubicación del usuario */}
          <Marker position={[userCoords.lat, userCoords.lon]} icon={new L.Icon({ iconUrl: 'ruta/a/tu/icono_de_usuario.svg', iconSize: [25, 25] })}>
            <Popup>Tu ubicación</Popup>
          </Marker>
          {/* Marcadores de los cuidadores */}
          {cuidadores.map((cuidador, index) => (
            <Marker key={index} position={[cuidador.coords.lat, cuidador.coords.lon]} icon={new L.Icon({ iconUrl: 'ruta/a/tu/icono_de_cuidador.svg', iconSize: [25, 25] })}>
              <Popup>
                <div>
                  <strong>{cuidador.nombre}</strong>
                  <br />
                  Teléfono: {cuidador.telefono}
                  <br />
                  <a href={`https://wa.me/5730${cuidador.telefono}?text=Hola,%20me%20interesa%20contactar%20al%20cuidador.`} target="_blank" rel="noopener noreferrer">
                    Contactar por WhatsApp
                  </a>
                </div>
              </Popup>
            </Marker>
          ))}
        </MapContainer>
      )}
    </div>
  );
};

export default MapaCuidadores;