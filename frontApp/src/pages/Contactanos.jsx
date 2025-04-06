import React from "react";

const Contactanos = () => {
  return (
    <div className="min-h-screen bg-green-50 flex flex-col items-center py-12 px-4 sm:px-6 lg:px-8">
      <div className="max-w-md w-full bg-white p-8 rounded-2xl shadow-lg">
        <h2 className="text-3xl font-bold text-center text-green-700 mb-6">
          ¡Contáctanos!
        </h2>

        <p className="text-gray-600 text-center mb-6">
          En AdoptApp queremos escucharte. Si tienes preguntas, sugerencias o deseas ayudarnos en nuestra misión animalista, escríbenos.
        </p>

        <form className="space-y-4">
          <input
            type="text"
            name="nombre"
            placeholder="Tu nombre"
            required
            className="w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-green-400"
          />
          <input
            type="email"
            name="correo"
            placeholder="Correo electrónico"
            required
            className="w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-green-400"
          />
          <textarea
            name="mensaje"
            placeholder="Escribe tu mensaje"
            rows="4"
            required
            className="w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-green-400"
          ></textarea>
          <button
            type="submit"
            className="w-full bg-green-600 text-white py-3 rounded-lg font-semibold hover:bg-green-700 transition"
          >
            Enviar mensaje
          </button>
        </form>

        <div className="mt-8 text-center text-sm text-gray-500">
          ¡Gracias por apoyar a nuestros peluditos! 🐾
        </div>
      </div>
    </div>
  );
};

export default Contactanos;