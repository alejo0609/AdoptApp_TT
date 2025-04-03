import React from "react";
import { FaPaw, FaUtensils, FaStethoscope, FaHome, FaDog, FaCat, FaNewspaper } from "react-icons/fa";

// Importar imágenes desde assets
import dog1 from "../assets/dog1.jpg";
import dog2 from "../assets/dog2.jpg";
import dog3 from "../assets/dog3.jpg";
import cat1 from "../assets/cat1.jpg";
import cat2 from "../assets/cat2.jpg";
import cat3 from "../assets/cat3.jpg";
import dog4 from "../assets/dog4.jpg";
import dog5 from "../assets/dog5.jpg";
import cat4 from "../assets/cat4.jpg";
import cat5 from "../assets/cat5.jpg";
import news1 from "../assets/news1.jpg";
import news2 from "../assets/news2.jpg";
import news3 from "../assets/news3.jpg";

// Datos de los animales para adopción
const animals = [
  { name: "Max", age: "2 años", location: "Ciudad A", image: dog1, type: "Perro" },
  { name: "Luna", age: "3 años", location: "Ciudad B", image: cat1, type: "Gato" },
  { name: "Rocky", age: "1 año", location: "Ciudad C", image: dog2, type: "Perro" },
  { name: "Milo", age: "2 años", location: "Ciudad D", image: cat2, type: "Gato" },
  { name: "Bruno", age: "4 años", location: "Ciudad E", image: dog3, type: "Perro" },
  { name: "Mia", age: "3 años", location: "Ciudad F", image: cat3, type: "Gato" },
  { name: "Toby", age: "5 años", location: "Ciudad G", image: dog4, type: "Perro" },
  { name: "Simba", age: "1 año", location: "Ciudad H", image: cat4, type: "Gato" },
  { name: "Coco", age: "6 años", location: "Ciudad I", image: dog5, type: "Perro" },
  { name: "Nala", age: "2 años", location: "Ciudad J", image: cat5, type: "Gato" },
];

// Datos de Noticias
const news = [
  {
    title: "Historias de adopción: Cómo Max encontró un hogar",
    description: "Descubre la emotiva historia de Max, un perro rescatado que encontró una nueva familia.",
    image: news1,
    link: "#"
  },
  {
    title: "Consejos para cuidar un gato en casa",
    description: "Todo lo que necesitas saber para que tu gato tenga una vida feliz y saludable.",
    image: news2,
    link: "#"
  },
  {
    title: "Importancia de la esterilización en mascotas",
    description: "Por qué esterilizar a tu mascota es una de las mejores decisiones para su salud.",
    image: news3,
    link: "#"
  }
];

// Consejos de cuidado de mascotas
const tips = [
  { title: "Buena alimentación", description: "Dale comida balanceada y adecuada a su edad.", icon: <FaUtensils /> },
  { title: "Visitas al veterinario", description: "Lleva a tu mascota al veterinario regularmente.", icon: <FaStethoscope /> },
  { title: "Espacio seguro", description: "Asegúrate de que tenga un ambiente seguro y cómodo.", icon: <FaHome /> },
  { title: "Ejercicio diario", description: "Los perros necesitan paseos y los gatos juegos activos.", icon: <FaPaw /> },
  { title: "Higiene", description: "Mantén limpio su espacio y báñalo cuando sea necesario.", icon: <FaDog /> },
  { title: "Amor y compañía", description: "Dedica tiempo a jugar y convivir con ellos.", icon: <FaCat /> },
];

function Main() {
  return (
    <main className="py-12 bg-gray-100 flex flex-col items-center">
      <div className="max-w-6xl mx-auto px-6 text-center">
        
        {/* 🐾 Sección de Animales en Adopción */}
        <h2 className="text-3xl font-bold text-gray-800 mb-8">
          🐾 Top 10 Animales para Adoptar 🐾
        </h2>
        <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-6">
          {animals.slice(0, 8).map((animal, index) => (
            <div key={index} className="bg-white shadow-md rounded-lg overflow-hidden">
              <img src={animal.image} alt={animal.name} className="w-full h-40 object-cover" />
              <div className="p-4">
                <h3 className="text-xl font-semibold text-gray-800">{animal.name}</h3>
                <p className="text-gray-600">{animal.age} • {animal.location}</p>
                <p className={`text-sm font-bold mt-2 ${animal.type === "Perro" ? "text-blue-500" : "text-green-500"}`}>
                  {animal.type}
                </p>
                <button className="mt-3 w-full bg-blue-600 text-white py-2 rounded-md hover:bg-blue-700 transition">
                  Adoptar
                </button>
              </div>
            </div>
          ))}
        </div>

        {/* Última fila con dos imágenes centradas */}
        <div className="flex justify-center gap-6 mt-6">
          {animals.slice(8).map((animal, index) => (
            <div key={index} className="bg-white shadow-md rounded-lg overflow-hidden w-80">
              <img src={animal.image} alt={animal.name} className="w-full h-40 object-cover" />
              <div className="p-4">
                <h3 className="text-xl font-semibold text-gray-800">{animal.name}</h3>
                <p className="text-gray-600">{animal.age} • {animal.location}</p>
                <p className={`text-sm font-bold mt-2 ${animal.type === "Perro" ? "text-blue-500" : "text-green-500"}`}>
                  {animal.type}
                </p>
                <button className="mt-3 w-full bg-blue-600 text-white py-2 rounded-md hover:bg-blue-700 transition">
                  Adoptar
                </button>
              </div>
            </div>
          ))}
        </div>

        {/* 📝 Sección de Noticias */}
        <div className="mt-12">
          <h2 className="text-3xl font-bold text-gray-800 mb-8 flex justify-center items-center gap-2">
            <FaNewspaper className="text-blue-600" /> Noticias y Artículos 📰
          </h2>
          <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-6">
            {news.map((article, index) => (
              <div key={index} className="bg-white p-4 rounded-lg shadow-md hover:shadow-lg transition">
                <img src={article.image} alt={article.title} className="w-full h-40 object-cover rounded-md mb-4" />
                <h3 className="text-xl font-bold text-gray-800">{article.title}</h3>
                <p className="text-gray-600">{article.description}</p>
                <a href={article.link} className="mt-3 inline-block text-blue-600 font-bold hover:underline">
                  Leer más →
                </a>
              </div>
            ))}
          </div>
        </div>

      </div>
    </main>
  );
}

export default Main;
