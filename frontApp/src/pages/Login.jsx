import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { FaLock, FaEnvelope, FaSignInAlt } from "react-icons/fa";
import { Link } from "react-router-dom";

function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError("");

    try {
      const response = await fetch("http://localhost:8080/datos_personales/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ email, password }),
      });

      const data = await response.json(); // ✅ Convertir la respuesta a JSON correctamente

      if (response.ok && data.mensaje === "Inicio de sesión exitoso") {
        alert("¡Inicio de sesión exitoso!");
        navigate("/adopta"); // ✅ Redirigir a la página correcta
      } else {
        setError("Credenciales incorrectas. Inténtalo de nuevo.");
      }
    } catch (err) {
      console.error("Error en el login:", err);
      setError("Error en el servidor. Inténtalo más tarde.");
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

          <div>
            <Link to="/registro">
            <button className="bg-yellow-500 text-white px-4 py-2 rounded-md font-bold hover:bg-yellow-600">
              Registrarse
            </button>
            </Link>
          </div>
        </form>
      </div>
    </div>
  );
}

export default Login;
