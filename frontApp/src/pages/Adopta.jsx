import { useEffect, useState } from "react";
import axios from "axios";

const Animales = () => {
  const [data, setData] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/adopta") 
      .then(response => {
        console.log("Datos recibidos:", response.data); // Verifica en consola
        setData(response.data);
      })
      .catch(error => {
        console.error("Error al obtener datos:", error);
      });
  }, []);

  return (
    <div className="p-6">
      <h1 className="text-2xl font-bold mb-4">Lista de Animales</h1>
      {data.length > 0 ? (
        <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-6"> 
          {data.map(animal => (
            <div key={animal.idAnimal} className="border rounded-lg shadow-md p-4 text-center">
              <img 
                src={`/aset/${animal.imagen_animal}`} 
                alt={animal.nombre_animal} 
                className="w-full h-40 object-cover rounded-md"
              />
              <h2 className="text-lg font-semibold mt-2">{animal.nombre_animal}</h2>
              <p><strong>Raza:</strong> {animal.raza}</p>
              <p><strong>Edad:</strong> {animal.edad} años</p>
              <p><strong>Estado:</strong> {animal.estado_animal ? "Disponible" : "No disponible"}</p>
            </div>
          ))}
        </div>
      ) : (
        <p>No hay animales disponibles.</p>
      )}
    </div>
  );
};

export default Animales;
