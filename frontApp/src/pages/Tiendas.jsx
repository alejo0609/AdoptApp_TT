import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import { MapContainer, TileLayer, Marker, Popup } from "react-leaflet";
import "leaflet/dist/leaflet.css";

function Tiendas() {
  const [stores, setStores] = useState([]);
  const [userLocation, setUserLocation] = useState(null);
  const [selectedNeighborhood, setSelectedNeighborhood] = useState("");

  useEffect(() => {
    navigator.geolocation.getCurrentPosition(
      (position) => {
        setUserLocation({
          lat: position.coords.latitude,
          lng: position.coords.longitude,
        });
      },
      () => alert("No pudimos obtener tu ubicación, usa el filtro manual.")
    );
  }, []);

  useEffect(() => {
    setStores([
      {
        name: "Tienda Animalista",
        address: "Calle 10 #45-23",
        city: "Medellin",
        state: "Antioquia",
        country: "Colombia",
        phone: "+573001234567",
        whatsapp: "+573001234567",
        website: "https://tiendaanimalista.com",
        products: "Alimentos, juguetes, ropa para mascotas",
        lat: 4.60971,
        lng: -74.08175,
        neighborhood: "Aranjuez",
      },
      {
        name: "Pet Store",
        address: "Carrera 50 #23-89",
        city: "Medellín",
        state: "Antioquia",
        country: "Colombia",
        phone: "+573112345678",
        whatsapp: "+573112345678",
        website: "https://petstore.com",
        products: "Accesorios, comida premium, servicio veterinario",
        lat: 6.2476,
        lng: -75.5658,
        neighborhood: "El Poblado",
      },
    ]);
  }, []);

  const filteredStores = selectedNeighborhood
    ? stores.filter((store) => store.neighborhood === selectedNeighborhood)
    : stores;

  return (
    <div className="min-h-screen bg-gray-100 p-6">
      <h2 className="text-3xl font-bold text-center text-blue-700 mb-6">📍 Tiendas Cercanas</h2>

      {/* Botón para Registrar Tienda */}
      <div className="text-center mb-6">
        <Link to="/Carrusel">
          <button className="bg-yellow-500 text-white px-6 py-2 rounded-md font-bold hover:bg-yellow-600 transition">
            🏪 Registrar Nueva Tienda
          </button>
        </Link>
      </div>

      {/* Filtro por barrio */}
      <div className="text-center mb-4">
        <select className="border px-4 py-2 rounded-md" onChange={(e) => setSelectedNeighborhood(e.target.value)}>
          <option value="">Selecciona un barrio</option>
          <option value="Chapinero">Chapinero</option>
          <option value="El Poblado">El Poblado</option>
        </select>
      </div>

      {/* Lista de tiendas */}
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6 mb-6">
        {filteredStores.map((store, index) => (
          <div key={index} className="bg-white p-4 rounded-lg shadow-md">
            <h3 className="text-xl font-bold text-gray-800">{store.name}</h3>
            <p className="text-gray-600">{store.address}, {store.city}</p>
            <p className="text-gray-600">📞 {store.phone}</p>
            <p className="text-gray-600">🛍️ {store.products}</p>
            <div className="flex space-x-4 mt-4">
              <a href={`https://wa.me/${store.whatsapp}`} target="_blank" rel="noopener noreferrer"
                className="bg-green-500 text-white px-4 py-2 rounded-md font-bold hover:bg-green-600 transition">
                Comprar por WhatsApp
              </a>
              <a href={store.website} target="_blank" rel="noopener noreferrer"
                className="bg-blue-500 text-white px-4 py-2 rounded-md font-bold hover:bg-blue-600 transition">
                Visitar Web
              </a>
            </div>
          </div>
        ))}
      </div>

      {/* Mapa de tiendas */}
      <div className="max-w-4xl mx-auto">
        <h3 className="text-xl font-semibold text-gray-700 mb-4">Mapa de Tiendas</h3>
        <MapContainer center={userLocation || [4.60971, -74.08175]} zoom={12} className="h-96 w-full rounded-lg shadow-md">
          <TileLayer url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png" />
          {filteredStores.map((store, index) => (
            <Marker key={index} position={[store.lat, store.lng]}>
              <Popup>
                <strong>{store.name}</strong><br />
                {store.address}, {store.city}<br />
                📞 {store.phone}<br />
                🛍️ {store.products}
              </Popup>
            </Marker>
          ))}
          {userLocation && (
            <Marker position={[userLocation.lat, userLocation.lng]}>
              <Popup>📍 ¡Aquí estás tú!</Popup>
            </Marker>
          )}
        </MapContainer>
      </div>
    </div>
  );
}

export default Tiendas;
