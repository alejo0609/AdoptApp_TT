import React, { useState } from "react";
import { FaGoogle, FaFacebook, FaPaw } from "react-icons/fa";

function Register() {
  const [formData, setFormData] = useState({ name: "", email: "", password: "", confirmPassword: "" });
  const [errors, setErrors] = useState("");

  const handleChange = (e) => setFormData({ ...formData, [e.target.name]: e.target.value });

  const isValidEmail = (email) => /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);

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
    alert("¡Registro exitoso!");
    setErrors("");
  };

  return (
    <div className="min-h-screen flex items-center justify-center bg-green-100">
      <div className="bg-white p-8 rounded-lg shadow-lg w-full max-w-md text-center">
        <div className="flex justify-center items-center mb-6">
          <FaPaw className="text-green-500 text-4xl mr-2" />
          <h2 className="text-2xl font-bold text-green-700">Únete a la familia animalista</h2>
        </div>

        {errors && <p className="text-red-500 text-sm mb-4">{errors}</p>}

        <form onSubmit={handleSubmit} className="space-y-4">
          <input type="text" name="name" value={formData.name} onChange={handleChange} required placeholder="Nombre"
            className="w-full px-4 py-2 border rounded-md focus:ring-2 focus:ring-green-400" />
          <input type="email" name="email" value={formData.email} onChange={handleChange} required placeholder="Correo Electrónico"
            className="w-full px-4 py-2 border rounded-md focus:ring-2 focus:ring-green-400" />
          <input type="password" name="password" value={formData.password} onChange={handleChange} required placeholder="Contraseña"
            className="w-full px-4 py-2 border rounded-md focus:ring-2 focus:ring-green-400" />
          <input type="password" name="confirmPassword" value={formData.confirmPassword} onChange={handleChange} required placeholder="Confirmar Contraseña"
            className="w-full px-4 py-2 border rounded-md focus:ring-2 focus:ring-green-400" />
          <button type="submit" className="w-full bg-green-600 text-white py-2 rounded-md font-bold hover:bg-green-700 transition">
            Registrarse
          </button>
        </form>

        <div className="my-4 text-gray-500">O</div>

        <div className="flex justify-center space-x-6">
          <button className="text-red-600 text-3xl hover:text-red-700 transition"><FaGoogle /></button>
          <button className="text-blue-600 text-3xl hover:text-blue-700 transition"><FaFacebook /></button>
        </div>
      </div>
    </div>
  );
}

export default Register;
