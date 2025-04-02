import React, { useState } from "react";

function Contactanos() {
  const [formData, setFormData] = useState({
    nombre: "",
    email: "",
    asunto: "",
    mensaje: "",
  });

  const [mensajeExito, setMensajeExito] = useState("");
  const [error, setError] = useState("");

  const handleChange = (e) => {
    setFormData({ 
      ...formData, 
      [e.target.name]: e.target.value 
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    if (!formData.nombre || !formData.email || !formData.mensaje) {
      setError("Por favor completa todos los campos obligatorios.");
      return;
    }

    setError("");
    setMensajeExito("¡Gracias por contactarnos! Te responderemos pronto.");
    setFormData({
      nombre: "",
      email: "",
      asunto: "",
      mensaje: "",
    });
  };

  return (
    <div className="min-h-screen bg-green-50 py-10 px-6 flex justify-center">
      <div className="bg-white p-8 rounded-lg shadow-lg w-full max-w-2xl">
        <h1 className="text-3xl font-bold text-green-700 mb-6 text-center">
          Contáctanos
        </h1>

        {mensajeExito && (
          <p className="text-green-600 text-center mb-4">{mensajeExito}</p>
        )}
        {error && (
          <p className="text-red-500 text-center mb-4">{error}</p>
        )}

        <form onSubmit={handleSubmit} className="space-y-4">
          <div>
            <label className="block text-gray-700 font-semibold">Nombre completo</label>
            <input
              type="text"
              name="nombre"
              value={formData.nombre}
              onChange={handleChange}
              required
              className="w-full px-4 py-2 border rounded-md focus:ring-2 focus:ring-green-400"
              placeholder="Tu nombre"
            />
          </div>
          <div>
            <label className="block text-gray-700 font-semibold">Correo electrónico</label>
            <input
              type="email"
              name="email"
              value={formData.email}
              onChange={handleChange}
              required
              className="w-full px-4 py-2 border rounded-md focus:ring-2 focus:ring-green-400"
              placeholder="tucorreo@example.com"
            />
          </div>
          <div>
            <label className="block text-gray-700 font-semibold">Asunto</label>
            <input
              type="text"
              name="asunto"
              value={formData.asunto}
              onChange={handleChange}
              className="w-full px-4 py-2 border rounded-md focus:ring-2 focus:ring-green-400"
              placeholder="¿Sobre qué quieres hablar?"
            />
          </div>
          <div>
            <label className="block text-gray-700 font-semibold">Mensaje</label>
            <textarea
              name="mensaje"
              value={formData.mensaje}
              onChange={handleChange}
              required
              rows="5"
              className="w-full px-4 py-2 border rounded-md focus:ring-2 focus:ring-green-400"
              placeholder="Escribe tu mensaje aquí..."
            ></textarea>
          </div>
          <button
            type="submit"
            className="w-full bg-green-600 text-white py-2 rounded-md font-bold hover:bg-green-700 transition"
          >
            Enviar mensaje
          </button>
        </form>
      </div>
    </div>
  );
}

export default Contactanos;
