import React, { useState, useEffect } from "react";
import axios from "axios";

function Clientes() {
  const [data, setData] = useState([]);
  const [dni, setDni] = useState("");
  const [message, setMessage] = useState("");

  // Obtener todos los datos al cargar la página
  useEffect(() => {
    obtenerDatos();
  }, []);

  const obtenerDatos = () => {
    axios.get("http://localhost:8080/datos_personales")
      .then(response => {
        setData(response.data);
        setMessage("Datos cargados correctamente.");
      })
      .catch(error => {
        console.error("Error al obtener los datos:", error);
        setMessage("Error al obtener los datos.");
      });
  };

   // Buscar por DNI
  /* const buscarPorDni = async () => {  */
  const obtenerTodos = async () => { 
    const dniNumero = parseInt(dni, 10); // Convertimos a número
    if (isNaN(dniNumero)) {
      setMessage("El DNI debe ser un número válido.");
      return;
    }
  
    try {
      const response = await axios.get(`http://localhost:8080/datos_personales/dni/${dniNumero}`);
      
      if (response.data) {
        setData([response.data]);
        setMessage("Usuario encontrado.");
      } else {
        setMessage("Usuario no encontrado.");
        setData([]);
      }
    } catch (error) {
      if (error.response && error.response.status === 404) {
        setMessage("El usuario con ese DNI no existe.");
      } else {
        setMessage("Error al buscar el usuario.");
      }
      setData([]);
    }
  };
  
  

  // Eliminar registro
  const eliminarRegistro = async (dni) => {
    if (!window.confirm(`¿Seguro que deseas eliminar el registro con DNI ${dni}?`)) {
      return;
    }
  
    try {
      await axios.delete(`http://localhost:8080/datos_personales/dni/${dni}`);
      setMessage("Registro eliminado correctamente.");
      obtenerDatos(); // Recargar los datos
    } catch (error) {
      console.error("Error al eliminar el registro:", error);
      setMessage("Error al eliminar el registro.");
    }
  };
  

  return (
    <div className="p-4">
      <h2 className="text-2xl font-bold mb-4">Gestión de Clientes</h2>

      {/* Barra de búsqueda */}
      <div className="mb-4 flex gap-2">
        <input
          type="text"
          value={dni}
          onChange={(e) => setDni(e.target.value)}
          placeholder="Ingrese DNI para buscar"
          className="border p-2 rounded w-64"
        />
        <button
          /* onClick={buscarPorDni}  */
          onClick={obtenerTodos} 
          className="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-700"
        >
          Buscar
        </button>
        <button
          onClick={obtenerDatos}
          className="bg-gray-500 text-white px-4 py-2 rounded hover:bg-gray-700"
        >
          Mostrar Todos
        </button>
      </div>

      {/* Mensajes */}
      {message && <p className="text-sm text-gray-700 mb-4">{message}</p>}

      {/* Tabla de datos */}
      <table className="min-w-full bg-white border border-gray-300 rounded-lg">
        <thead>
          <tr className="bg-gray-200">
            <th className="py-2 px-4 border-b">ID</th>
            <th className="py-2 px-4 border-b">Nombre</th>
            <th className="py-2 px-4 border-b">Teléfono</th>
            <th className="py-2 px-4 border-b">Correo</th>
            <th className="py-2 px-4 border-b">Ciudad</th>
            <th className="py-2 px-4 border-b">DNI</th>
            <th className="py-2 px-4 border-b">Acciones</th>
          </tr>
        </thead>
        <tbody>
          {data.length > 0 ? (
            data.map((person) => (
              <tr key={person.idDatosPersonales} className="text-center border-b">
                <td className="py-2 px-4">{person.idDatosPersonales}</td>
                <td className="py-2 px-4">{person.name}</td>
                <td className="py-2 px-4">{person.telefono}</td>
                <td className="py-2 px-4">{person.email}</td>
                <td className="py-2 px-4">{person.ciudad}</td>
                <td className="py-2 px-4">{person.dni}</td>
                <td className="py-2 px-4">
                  <button
                    onClick={() => eliminarRegistro(person.dni)}
                    className="bg-red-500 text-white px-3 py-1 rounded hover:bg-red-700"
                  >
                    Eliminar
                  </button>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="7" className="py-4 text-center text-gray-600">
                No hay datos disponibles.
              </td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
}

export default Clientes;