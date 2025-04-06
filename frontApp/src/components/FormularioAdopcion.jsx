import React, { useState } from "react";
import axios from "axios";
import { useParams, useNavigate } from "react-router-dom";

const FormularioAdopcion = () => {
  const { idAnimalSeleccionado } = useParams();
  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    nombre: "",
    dni: "",
    direccion: "",
    ciudad: "",
    telefono: "",
    correo: "",
    ocupacion: "",
    tipoVivienda: "",
    motivoAdopcion: "",
    idAnimal: idAnimalSeleccionado,
  });

  const [formularioEnviado, setFormularioEnviado] = useState(false);
  const [error, setError] = useState(null);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post("http://localhost:8080/adopcion", formData);
      if (response.status === 200) {
        setFormularioEnviado(true);
        setError(null);
        setTimeout(() => {
          navigate("/"); // Redirige a la página principal o alguna página de agradecimiento
        }, 3000); // Después de 3 segundos redirige
      }
    } catch (err) {
      setError("Error al enviar el formulario. Intenta nuevamente.");
    }
  };

  return (
    <div className="max-w-2xl mx-auto p-6 bg-white rounded-2xl shadow-md mt-6">
      <h2 className="text-2xl font-bold mb-4 text-center text-green-700">
        Formulario de Adopción
      </h2>

      <form onSubmit={handleSubmit}>
        <div className="mb-4">
          <label htmlFor="nombre" className="block text-gray-700">
            Nombre Completo:
          </label>
          <input
            type="text"
            id="nombre"
            name="nombre"
            value={formData.nombre}
            onChange={handleChange}
            required
            className="w-full p-2 border border-gray-300 rounded"
          />
        </div>

        <div className="mb-4">
          <label htmlFor="dni" className="block text-gray-700">
            DNI:
          </label>
          <input
            type="text"
            id="dni"
            name="dni"
            value={formData.dni}
            onChange={handleChange}
            required
            className="w-full p-2 border border-gray-300 rounded"
          />
        </div>

        <div className="mb-4">
          <label htmlFor="direccion" className="block text-gray-700">
            Dirección:
          </label>
          <input
            type="text"
            id="direccion"
            name="direccion"
            value={formData.direccion}
            onChange={handleChange}
            required
            className="w-full p-2 border border-gray-300 rounded"
          />
        </div>

        <div className="mb-4">
          <label htmlFor="ciudad" className="block text-gray-700">
            Ciudad:
          </label>
          <input
            type="text"
            id="ciudad"
            name="ciudad"
            value={formData.ciudad}
            onChange={handleChange}
            required
            className="w-full p-2 border border-gray-300 rounded"
          />
        </div>

        <div className="mb-4">
          <label htmlFor="telefono" className="block text-gray-700">
            Teléfono:
          </label>
          <input
            type="tel"
            id="telefono"
            name="telefono"
            value={formData.telefono}
            onChange={handleChange}
            required
            className="w-full p-2 border border-gray-300 rounded"
          />
        </div>

        <div className="mb-4">
          <label htmlFor="correo" className="block text-gray-700">
            Correo Electrónico:
          </label>
          <input
            type="email"
            id="correo"
            name="correo"
            value={formData.correo}
            onChange={handleChange}
            required
            className="w-full p-2 border border-gray-300 rounded"
          />
        </div>

        <div className="mb-4">
          <label htmlFor="ocupacion" className="block text-gray-700">
            Ocupación:
          </label>
          <input
            type="text"
            id="ocupacion"
            name="ocupacion"
            value={formData.ocupacion}
            onChange={handleChange}
            required
            className="w-full p-2 border border-gray-300 rounded"
          />
        </div>

        <div className="mb-4">
          <label htmlFor="tipoVivienda" className="block text-gray-700">
            Tipo de Vivienda:
          </label>
          <input
            type="text"
            id="tipoVivienda"
            name="tipoVivienda"
            value={formData.tipoVivienda}
            onChange={handleChange}
            required
            className="w-full p-2 border border-gray-300 rounded"
          />
        </div>

        <div className="mb-4">
          <label htmlFor="motivoAdopcion" className="block text-gray-700">
            Motivo de la Adopción:
          </label>
          <textarea
            id="motivoAdopcion"
            name="motivoAdopcion"
            value={formData.motivoAdopcion}
            onChange={handleChange}
            required
            className="w-full p-2 border border-gray-300 rounded"
            rows="4"
          ></textarea>
        </div>

        <div className="mb-4">
          <button
            type="submit"
            className="w-full bg-green-600 text-white py-2 rounded-md hover:bg-green-700 transition"
          >
            Enviar Solicitud
          </button>
        </div>
      </form>

      {formularioEnviado && (
        <div className="mt-6 p-4 bg-green-100 text-green-800 rounded-xl text-center font-semibold">
          ¡Gracias por enviar tu solicitud de adopción! Pronto serás
          contactado por la tienda encargada.
        </div>
      )}

      {error && (
        <div className="mt-6 p-4 bg-red-100 text-red-800 rounded-xl text-center font-semibold">
          {error}
        </div>
      )}
    </div>
  );
};

export default FormularioAdopcion;
