import React from "react";
import Logo from "/aset/LogoAdoptapp.png"; // Ajusta la ruta si tu logo está en otro lugar

function QuienesSomos() {
  return (
    <div className="min-h-screen bg-green-50 py-10 px-6 flex flex-col items-center">
      <div className="max-w-3xl text-center">
        <img
          src={Logo}
          alt="Logo AdoptApp"
          className="mx-auto mb-6 w-32"
        />
        <h1 className="text-4xl font-bold text-green-700 mb-4">¿Quiénes somos?</h1>
        <p className="text-gray-700 text-lg mb-6">
          Somos un equipo de desarrolladores apasionados por mejorar la calidad de vida de los animales.  
          Creemos en la adopción como un acto de amor y compromiso. Nuestra misión es brindar herramientas digitales que faciliten la conexión entre animales en situación de abandono y personas dispuestas a brindarles un hogar lleno de cariño.
        </p>
        <p className="text-gray-700 text-lg mb-6">
          AdoptApp nació como una plataforma centrada en el bienestar animal. Queremos inspirar a la comunidad a adoptar y brindar segundas oportunidades a nuestros amigos de cuatro patas. 
          Con nuestro sistema, podrás registrar mascotas, buscar cuidadores, encontrar tiendas aliadas y compartir esta noble causa.
        </p>
        <h2 className="text-2xl font-semibold text-green-600 mb-4">
          ¿Por qué adoptar y no comprar?
        </h2>
        <div className="w-full aspect-video mb-6">
          <iframe
            className="rounded-lg w-full h-full"
            src="https://www.youtube.com/embed/QmZtxYmer3s"
            title="ADOPTA no compres MASCOTAS ¿Por qué adoptar y no comprar?"
            frameBorder="0"
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
            allowFullScreen
          ></iframe>
        </div>
        <p className="text-gray-700">
          Al adoptar, salvas una vida, ayudas a controlar la sobrepoblación animal y ganas un amigo fiel para toda la vida.
        </p>
      </div>
    </div>
  );
}

export default QuienesSomos;