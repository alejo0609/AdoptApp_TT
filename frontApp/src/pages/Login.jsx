import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import { FaLock, FaEnvelope, FaSignInAlt } from "react-icons/fa";

function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError("");

    try {
      const response = await axios.post("http://localhost:8080/usuarios/login", {
        email,
        password,
      });
      
      if (response.data.token) {
        localStorage.setItem("token", response.data.token);
        navigate("/register"); // Redirige al dashboard o página principal
      } else {
        setError("Error en la autenticación. Inténtalo de nuevo.");
      }
    } catch (err) {
      console.error("Error en el login:", err);
      setError(err.response?.data?.message || "Correo o contraseña incorrectos.");
    }
  };

  return (
    <div className="min-h-screen flex items-center justify-center bg-blue-100">
      <div className="bg-white p-8 rounded-lg shadow-md w-full max-w-sm text-center">
        <h2 className="text-2xl font-bold mb-6 flex justify-center items-center text-blue-700">
          <FaSignInAlt className="mr-2" /> Iniciar Sesión
        </h2>

        {error && <p className="text-red-500 text-sm mb-4">{error}</p>}

        <form onSubmit={handleSubmit} className="space-y-4">
          <div>
            <label className="block text-gray-700 font-semibold text-left">Correo Electrónico</label>
            <div className="flex items-center border rounded-md px-3 py-2">
              <FaEnvelope className="text-gray-400 mr-2" />
              <input
                type="email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                required
                className="w-full focus:outline-none"
                placeholder="correo@example.com"
              />
            </div>
          </div>

          <div>
            <label className="block text-gray-700 font-semibold text-left">Contraseña</label>
            <div className="flex items-center border rounded-md px-3 py-2">
              <FaLock className="text-gray-400 mr-2" />
              <input
                type="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
                className="w-full focus:outline-none"
                placeholder="******"
              />
            </div>
          </div>

          <button
            type="submit"
            className="w-full bg-blue-600 text-white py-2 rounded-md font-semibold hover:bg-blue-700 transition"
          >
            Ingresar
          </button>
        </form>
      </div>
    </div>
  );
}

export default Login;
