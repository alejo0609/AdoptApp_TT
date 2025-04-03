import React from "react";
import { useNavigate } from "react-router-dom";
import { FaUserPlus, FaStore, FaDog, FaUserNurse } from "react-icons/fa";
import logo from "../assets/LogoAdoptapp.png";

function SeleccionRegistro() {
  const navigate = useNavigate();

  const opciones = [
    { label: "Registrar Usuario", icon: <FaUserPlus />, ruta: "/registro/usuario" },
    { label: "Registrar Tienda de Mascotas", icon: <FaStore />, ruta: "/registro/tienda" },
    { label: "Registrar Cuidador", icon: <FaUserNurse />, ruta: "/registro/cuidador" },
    { label: "Registrar Mascota", icon: <FaDog />, ruta: "/registro/mascota" },
  ];

  return (
    <div className="min-h-screen bg-gradient-to-br from-green-100 to-white flex flex-col items-center justify-center">
      <img src={logo} alt="Logo AdoptApp" className="w-24 h-24 mb-6" />
      <h2 className="text-2xl font-bold text-green-700 mb-8 text-center">
        Selecciona una opción para registrar
      </h2>

      <div className="grid grid-cols-1 sm:grid-cols-2 gap-6 w-full max-w-xl px-4">
        {opciones.map((op, index) => (
          <div
            key={index}
            onClick={() => navigate(op.ruta)}
            className="flex flex-col items-center justify-center p-6 border border-green-300 rounded-xl cursor-pointer hover:shadow-lg hover:bg-green-50 transition"
          >
            <div className="text-4xl text-green-600 mb-2">{op.icon}</div>
            <span className="text-green-800 font-semibold text-center">{op.label}</span>
          </div>
        ))}
      </div>
    </div>
  );
}

export default SeleccionRegistro;

