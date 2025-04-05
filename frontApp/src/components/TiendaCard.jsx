import React from "react";

function TiendaCard({ tienda, distancia }) {
  return (
    <div className="border p-4 rounded-lg shadow-md bg-white mb-4">
      <h3 className="text-xl font-bold text-green-700">{tienda.nombre}</h3>
      <p className="text-gray-600">📍 {tienda.direccion}, {tienda.barrio}, {tienda.ciudad}</p>
      <p className="text-gray-600">📞 {tienda.telefono}</p>
      <p className="text-gray-600">📧 {tienda.correo_electronico}</p>
      <p className="text-gray-600">🌐 <a href={tienda.sitio_web} target="_blank" rel="noopener noreferrer" className="text-blue-600 hover:underline">{tienda.sitio_web}</a></p>
      <p className="mt-2 text-sm text-gray-800 font-semibold">
        🚗 Tiempo estimado de llegada: {distancia}
      </p>
    </div>
  );
}

export default TiendaCard;