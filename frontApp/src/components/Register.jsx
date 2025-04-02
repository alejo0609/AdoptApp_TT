import React, { useState } from "react";
import axios from "axios";
import { FaGoogle, FaFacebook, FaPaw } from "react-icons/fa";

function Register() {
  // Estado del formulario: los nombres deben coincidir con los de la entidad del backend
  const [formData, setFormData] = useState({
    name: "",
    dni: "",
    direccion: "",
    ciudad: "",
    telefono: "",
    email: "",
    password: "",
    confirm_password: ""
  });

  

  const [errors, setErrors] = useState("");
  const [message, setMessage] = useState("");

  // Manejar cambios en los inputs
  const handleChange = (e) => {
    setFormData({ 
      ...formData, 
      [e.target.name]: e.target.value 
    });
  };

  // Validar correo electrónico
  const isValidEmail = (email) => /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);

  // Manejar el envío del formulario
  const handleSubmit = (e) => {
    e.preventDefault();

    if (!isValidEmail(formData.email)) {
      setErrors("Por favor, introduce un correo válido.");
      return;
    }

    if (formData.password !== formData.confirm_password) {
      setErrors("Las contraseñas no coinciden.");
      return;
    }

    // Limpia errores previos
    setErrors("");

    // Enviar datos al backend
    axios.post("http://localhost:8080/datos_personales", formData)
      .then(response => {
        console.log("Usuario registrado:", response.data);
        setMessage("¡Registro exitoso!");
        
      })
      .catch(error => {
        console.error("Error en el registro:", error);
        setMessage("Error en el registro. Por favor, inténtalo nuevamente.");
      });
  };

  // Métodos para autenticación social (ejemplo)
  const handleGoogleSignIn = () => {
    alert("Iniciar sesión con Google (Implementar con Firebase)");
  };

  const handleFacebookSignIn = () => {
    alert("Iniciar sesión con Facebook (Implementar con Firebase)");
  };

  return (
    <div className="min-h-screen flex items-center justify-center bg-green-100">
      <div className="bg-white m-10 p-8 rounded-lg shadow-lg w-full max-w-md text-center">
        {/* Encabezado Animalista */}
        <div className="flex justify-center items-center mb-6">
          <FaPaw className="text-green-500 text-4xl mr-2" />
          <h2 className="text-2xl font-bold text-green-700">Únete a la familia animalista</h2>
        </div>

        {/* Mensaje de error o éxito */}
        {errors && <p className="text-red-500 text-sm mb-4">{errors}</p>}
        {message && <p className="text-green-500 text-sm mb-4">{message}</p>}

        {/* Formulario de Registro */}
        <form onSubmit={handleSubmit} className="space-y-4">
          <div>
            <label className="block text-gray-700 font-semibold">Nombre completo</label>
            <input
              type="text"
              name="name"
              value={formData.name}
              onChange={handleChange}
              required
              placeholder="Tu nombre"
              className="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-green-400"
            />
          </div>
          <div>
            <label className="block text-gray-700 font-semibold">Cédula (DNI)</label>
            <input
              type="number"
              name="dni"
              value={formData.dni}
              onChange={handleChange}
              required
              placeholder="Tu cédula"
              className="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-green-400"
            />
          </div>
          <div>
            <label className="block text-gray-700 font-semibold">Dirección</label>
            <input
              type="text"
              name="direccion"
              value={formData.direccion}
              onChange={handleChange}
              required
              placeholder="Tu dirección"
              className="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-green-400"
            />
          </div>
          <div>
            <label className="block text-gray-700 font-semibold">Ciudad</label>
            <input
              type="text"
              name="ciudad"
              value={formData.ciudad}
              onChange={handleChange}
              required
              placeholder="Tu ciudad"
              className="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-green-400"
            />
          </div>
          <div>
            <label className="block text-gray-700 font-semibold">Teléfono</label>
            <input
              type="text"
              name="telefono"
              value={formData.telefono}
              onChange={handleChange}
              required
              placeholder="Tu teléfono"
              className="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-green-400"
            />
          </div>
          <div>
            <label className="block text-gray-700 font-semibold">Correo Electrónico</label>
            <input
              type="email"
              name="email"
              value={formData.email}
              onChange={handleChange}
              required
              placeholder="tucorreo@example.com"
              className="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-green-400"
            />
          </div>
          <div>
            <label className="block text-gray-700 font-semibold">Contraseña</label>
            <input
              type="password"
              name="password"
              value={formData.password}
              onChange={handleChange}
              required
              placeholder="******"
              className="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-green-400"
            />
          </div>
          <div>
            <label className="block text-gray-700 font-semibold">Confirmar Contraseña</label>
            <input
              type="password"
              name="confirm_password"
              value={formData.confirm_password}
              onChange={handleChange}
              required
              placeholder="******"
              className="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-green-400"
            />
          </div>

          {/* Botón de Registro */}
          <button
            type="submit"
            className="w-full bg-green-600 text-white py-2 rounded-md font-bold hover:bg-green-700 transition"
          >
            Registrarse
          </button>
        </form>

        {/* Línea divisoria */}
        <div className="my-4 text-gray-500">O</div>

        {/* Botones de Google y Facebook */}
        <div className="flex justify-center space-x-6">
          <button
            onClick={handleGoogleSignIn}
            className="text-red-600 text-3xl hover:text-red-700 transition"
          >
            <FaGoogle />
          </button>
          <button
            onClick={handleFacebookSignIn}
            className="text-blue-600 text-3xl hover:text-blue-700 transition"
          >
            <FaFacebook />
          </button>
        </div>
      </div>
    </div>
  );
}

export default Register;