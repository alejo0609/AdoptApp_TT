import React from "react";

function FiltroBarrios({ tiendas = [], onFiltrar }) {
  // Extraer los barrios únicos
  const barriosUnicos = [...new Set(tiendas.map(t => t.barrio))];

  return (
    <div className="mb-4">
      <label className="block text-gray-700 font-semibold mb-2">Filtrar por barrio:</label>
      <select
        onChange={(e) => onFiltrar(e.target.value)}
        className="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-green-400"
      >
        <option value="">Todos</option>
        {barriosUnicos.map((barrio, i) => (
          <option key={i} value={barrio}>
            {barrio}
          </option>
        ))}
      </select>
    </div>
  );
}

export default FiltroBarrios;

  