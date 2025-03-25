import React, { useState } from "react";
import { FaGoogle, FaFacebook, FaPaw } from "react-icons/fa";

function Register() {
  // Estado del formulario
  const [formData, setFormData] = useState({
    name: "",
    email: "",
    password: "",
    confirmPassword: "",
  });

  const [errors, setErrors] = useState("");

  // Manejar cambios en los inputs
  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  // Validar correo electrónico
  const isValidEmail = (email) => {
    return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
  };

  // Manejar el envío del formulario
  const handleSubmit = (e) => {
    e.preventDefault();

    if (!isValidEmail(formData.email)) {
      setErrors("Por favor, introduce un correo válido.");
      return;
    }

    if (formData.password !== formData.confirmPassword) {
      setErrors("Las contraseñas no coinciden.");
      return;
    }

    console.log("Datos del usuario:", formData);
    alert("¡Registro exitoso!");
    setErrors(""); // Limpiar errores
  };

  // Métodos de autenticación social (Se implementan con Firebase o SDKs)
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

        {/* Mensaje de error */}
        {errors && <p className="text-red-500 text-sm mb-4">{errors}</p>}

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
              className="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-green-400"
              placeholder="Tu nombre"
            />
          </div>
          <div>
            <label className="block text-gray-700 font-semibold">Cedula</label>
            <input
              type="number"
              name="name"
              value={formData.name}
              onChange={handleChange}
              required
              className="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-green-400"
              placeholder="Tu cedula"
            />
          </div>
          <div>
            <label className="block text-gray-700 font-semibold">Direccion</label>
            <input
              type="text"
              name="name"
              value={formData.name}
              onChange={handleChange}
              required
              className="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-green-400"
              placeholder="Tu direccion"
            />
          </div>
          <div>
            <label className="block text-gray-700 font-semibold">Ciudad</label>
            <input
              type="text"
              name="name"
              value={formData.name}
              onChange={handleChange}
              required
              className="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-green-400"
              placeholder="Tu ciudad"
            />
          </div>
          <div>
            <label className="block text-gray-700 font-semibold">Telefono</label>
            <input
              type="text"
              name="name"
              value={formData.name}
              onChange={handleChange}
              required
              className="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-green-400"
              placeholder="Tu telefono"
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
              className="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-green-400"
              placeholder="tucorreo@example.com"
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
              className="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-green-400"
              placeholder="******"
            />
          </div>

          <div>
            <label className="block text-gray-700 font-semibold">Confirmar Contraseña</label>
            <input
              type="password"
              name="confirmPassword"
              value={formData.confirmPassword}
              onChange={handleChange}
              required
              className="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-green-400"
              placeholder="******"
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
