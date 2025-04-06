import { useEffect, useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const Animales = () => {
  const [data, setData] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    axios.get("http://localhost:8080/animal/disponibles")
      .then(response => {
        console.log("Datos recibidos:", response.data);
        setData(response.data);
      })
      .catch(error => {
        console.error("Error al obtener datos:", error);
      });
  }, []);

  const manejarAdopcion = (animalId) => {
    navigate(`/adopcion/${animalId}`);
  };

  return (
    <div className="p-6">
      <h1 className="text-2xl font-bold mb-4">Lista de Animales</h1>
      {data.length > 0 ? (
        <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-6">
          {data.map(animal => (
            <div key={animal.idAnimal} className="border rounded-lg shadow-md p-4 text-center bg-white">
              <img
                src={`/aset/${animal.imagen_animal}`}
                alt={animal.nombre_animal}
                className="w-full h-40 object-cover rounded-md"
              />
              <h2 className="text-lg font-semibold mt-2">{animal.nombre_animal}</h2>
              <p><strong>Raza:</strong> {animal.raza}</p>
              <p><strong>Edad:</strong> {animal.edad} años</p>
              <p><strong>Estado:</strong> {animal.estadoAnimal ? "Disponible" : "No disponible"}</p>

              {animal.estadoAnimal && (
                <button
                  onClick={() => manejarAdopcion(animal.idAnimal)}
                  className="mt-4 bg-blue-600 hover:bg-blue-700 text-white px-4 py-2 rounded transition"
                >
                  Adoptar
                </button>
              )}
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
