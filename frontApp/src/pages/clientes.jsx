import React, { useState, useEffect } from "react";
import "leaflet/dist/leaflet.css";
import axios from "axios";

function Clientes() {
  const [data, setData] = useState([]);
   const [message, setMessage] = useState("");

  useEffect(() => {
    axios.get("http://localhost:8080/datos_personales")
    .then(response => {
      console.log("Usuario guardados:", response.data);
      setData(response.data)
      console.log("dataGuardada:", message);
      setMessage("exitoso!");
      
    })
    .catch(error => {
      console.error("Error en obtener los datos:", error);
      setMessage("Error en obtener los datos. Por favor, inténtalo nuevamente.");
    });
  
  }, []);

  return (

      <div className="p-4">
      <table className="min-w-full bg-white border border-gray-300 rounded-lg">
        <thead>
          <tr className="bg-gray-200">
            <th className="py-2 px-4 border-b">ID</th>
            <th className="py-2 px-4 border-b">Nombre</th>
            <th className="py-2 px-4 border-b">Telefono</th>
            <th className="py-2 px-4 border-b">Correo</th>
            <th className="py-2 px-4 border-b">Ciudad</th>
          </tr>
        </thead>
        <tbody>
          {data.map((person) => (
            <tr key={person.id} className="text-center border-b">
              <td className="py-2 px-4">{person.dni}</td>
              <td className="py-2 px-4">{person.name}</td>
              <td className="py-2 px-4">{person.telefono}</td>
              <td className="py-2 px-4">{person.email}</td>
              <td className="py-2 px-4">{person.ciudad}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>

     
  );
}

export default Clientes;


