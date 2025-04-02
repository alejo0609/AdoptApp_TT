import React from "react";
import { FaFacebook, FaInstagram, FaTwitter, FaEnvelope } from "react-icons/fa";

function Footer() {
  return (
    <footer className="bg-blue-600 text-white py-8 mt-12">
      <div className="max-w-6xl mx-auto px-6 flex flex-col md:flex-row justify-between items-center text-center md:text-left">
        
        {/* Información */}
        <div className="mb-6 md:mb-0">
          <h2 className="text-2xl font-bold">🐾 Adopta con Amor</h2>
          <p className="text-gray-200">Encuentra a tu mejor amigo y dale un hogar ❤️</p>
        </div>

        {/* Redes Sociales */}
        <div className="flex space-x-6 text-2xl">
          <a href="#" className="hover:text-gray-300 transition"><FaFacebook /></a>
          <a href="#" className="hover:text-gray-300 transition"><FaInstagram /></a>
          <a href="#" className="hover:text-gray-300 transition"><FaTwitter /></a>
          <a href="mailto:contacto@adopta.com" className="hover:text-gray-300 transition"><FaEnvelope /></a>
        </div>
      </div>

      {/* Derechos Reservados */}
      <div className="text-center text-gray-300 mt-6 text-sm">
        © {new Date().getFullYear()} Adopta con Amor. Todos los derechos reservados.
      </div>
    </footer>
  );
}

export default Footer;