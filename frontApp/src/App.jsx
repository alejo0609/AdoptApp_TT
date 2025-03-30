import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";
import Home from "./pages/Home";        
import Register from "./pages/Register"; 
import Login from './pages/Login';
import Tiendas from "./pages/Tiendas";
import RegistrarTienda from "./pages/RegistrarTienda";
import Adopta from "./pages/Adopta"; // 👈 Importamos el nuevo componente

function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/register" element={<Register />} />
        <Route path="/login" element={<Login />} />
        {/*<Route path="/" element={<Login />} />*/}
        <Route path="/tiendas" element={<Tiendas />} />
        <Route path="/registrar-tienda" element={<RegistrarTienda />} />
        <Route path="/adopta" element={<Adopta />} /> {/* 👈 Nueva ruta */}
      </Routes>
      <Footer />
    </Router>
  );
}

export default App;

