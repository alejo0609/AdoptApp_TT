import React from 'react';

function FiltroBarrios({ tiendas, setFiltroBarrio }) {
  // Extraemos los barrios únicos
  const barriosUnicos = [...new Set(tiendas.map(t => t.barrio?.toLowerCase()))].filter(Boolean);

  const handleInputChange = (event) => {
    const value = event.target.value.toLowerCase();
    setFiltroBarrio(value);
  };

  return (
    <div className="mb-4">
      <label htmlFor="barrio">Filtrar por barrio:</label>
      <input
        list="sugerencias-barrios"
        type="text"
        id="barrio"
        placeholder="Escribe un barrio"
        onChange={handleInputChange}
        className="border rounded p-2 w-full"
      />
      <datalist id="sugerencias-barrios">
        {barriosUnicos.map((barrio, i) => (
          <option key={i} value={barrio} />
        ))}
      </datalist>
    </div>
  );
}

export default FiltroBarrios;