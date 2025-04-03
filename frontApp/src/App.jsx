import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";
import Home from "./pages/Home";
import Register from "./components/Register"; 
import Login from './pages/Login';
import Tiendas from "./pages/Tiendas";
import RegistrarTienda from "./pages/RegistrarTienda";
import Adopta from "./pages/Adopta"; // 👈 Importamos el nuevo componente
import QuienesSomos from "./pages/QuienesSomos";
import SeleccionRegistro from "./pages/SeleccionRegistro";
import RegistroGenerico from "./pages/RegistroGenerico";

function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/tiendas" element={<Tiendas />} />

        { /*<Route path="/register" element={<Register />} /> */}
        <Route path="/registrar-tienda" element={<RegistrarTienda />} />
        <Route path="/register" element={<SeleccionRegistro />} />
        <Route path="/registrar" element={<SeleccionRegistro />} />
        <Route path="/registro/usuario" element={<Register />} />
        <Route path="/registro/:tipo" element={<RegistroGenerico />} />

        <Route path="/adopta" element={<Adopta />} /> 
        <Route path="/quienes-somos" element={<QuienesSomos />} />
      </Routes>
      <Footer />
    </Router>
  );
}

export default App;

