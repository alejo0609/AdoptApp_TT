import React from "react";
import { Link } from "react-router-dom";
import cogs_result from "../assets/cogs_result.svg";

function Navbar() {
  return (
    <nav className="bg-blue-600 text-white p-4 flex items-center justify-between">
      {/* Logo a la izquierda */}
      <div>
        <img className="w-16 h-16 rounded-full" src={cogs_result} alt="logo-adopta" />
      </div>

      {/* Menú centrado */}
      <ul className="flex space-x-6">
        <li><Link to="/" className="hover:text-gray-200 font-bold">Inicio</Link></li>
        <li><Link to="/quienes-somos" className="hover:text-gray-200 font-bold">Quienes Somos</Link></li>
        <li><Link to="/adopta" className="hover:text-gray-200 font-bold">Adopta</Link></li>
        {/* <li><Link to="/register" className="hover:text-gray-200 font-bold">Cuidador</Link></li> */}
        <li><Link to="/clientes" className="hover:text-gray-200 font-bold">Clientes</Link></li>
        <li><Link to="/tiendas" className="hover:text-gray-200 font-bold">Tiendas</Link></li>
        <li><Link to="/register" className="hover:text-gray-200 font-bold">Dar en adopcion</Link></li>
        <li><Link to="/register" className="hover:text-gray-200 font-bold">Contáctanos</Link></li>
        <li><Link to="/fomulario-adopcion" className="hover:text-gray-200 font-bold">FORMULARIO</Link></li>
        {/*<li><Link to="/animales" className="hover:text-gray-200 font-bold">Animales</Link></li>*/}
      </ul>

      {/* Botones a la derecha */}
      <div className="flex space-x-4">
        <Link to="/login"> {/* ✅ Redirige a la página de inicio de sesión */}
          <button className="bg-white text-blue-600 px-4 py-2 rounded-md font-bold hover:bg-gray-200">
            Iniciar Sesión
          </button>
        </Link>
      </div>
    </nav>
  );
}

export default Navbar;
