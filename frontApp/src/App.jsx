import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";
import Home from "./pages/Home";        
import Register from "./pages/Register"; 
import Login from './pages/Login'
import Tiendas from "./pages/Tiendas";
import RegistrarTienda from "./pages/RegistrarTienda";

function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/register" element={<Register />} />
        <Route path="/login" element={<Login />} /> {/* ✅ Nueva ruta para inicio de sesión */}
        <Route path="/tiendas" element={<Tiendas />} />
  <Route path="/registrar-tienda" element={<RegistrarTienda />} />
      </Routes>
      <Footer />
    </Router>
  );
}

export default App;
