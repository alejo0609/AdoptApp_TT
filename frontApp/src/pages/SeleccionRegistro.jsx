import React from "react";
import { useNavigate } from "react-router-dom";
import { FaUser, FaStore, FaDog, FaUserTie, FaPaw } from "react-icons/fa";

const SeleccionRegistro = () => {
  const navigate = useNavigate();

  const opciones = [
    {
      label: "Usuario",
      icon: <FaUser className="text-3xl text-green-600" />,
      tipo: "usuario",
    },
    {
      label: "Tienda",
      icon: <FaStore className="text-3xl text-green-600" />,
      tipo: "tienda",
    },
    {
      label: "Mascota",
      icon: <FaDog className="text-3xl text-green-600" />,
      tipo: "mascota",
    },
    {
      label: "Cuidador",
      icon: <FaUserTie className="text-3xl text-green-600" />,
      tipo: "cuidador",
    },
  ];

  return (
    <div className="min-h-screen bg-green-50 flex flex-col items-center justify-center px-4 py-10">
      {/* Encabezado */}
      <div className="flex items-center space-x-3 mb-8">
        <FaPaw className="text-4xl text-green-700" />
        <h1 className="text-2xl sm:text-3xl font-bold text-green-700">
          Elige qué deseas registrar
        </h1>
      </div>

      {/* Tarjetas */}
      <div className="grid grid-cols-1 sm:grid-cols-2 gap-6 w-full max-w-2xl">
        {opciones.map((op, idx) => (
          <div
            key={idx}
            onClick={() => navigate(`/registro/${op.tipo}`)}
            className="bg-white p-6 rounded-2xl border border-green-100 shadow hover:shadow-md transform hover:-translate-y-1 hover:scale-105 transition duration-300 cursor-pointer text-center"
          >
            <div className="flex flex-col items-center space-y-2">
              {op.icon}
              <p className="text-green-700 font-semibold text-lg">{op.label}</p>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default SeleccionRegistro;