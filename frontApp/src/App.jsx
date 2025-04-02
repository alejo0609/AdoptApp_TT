import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";
import Home from "./pages/Home";
import Register from "./components/Register";
import Login from './pages/Login';
import Tiendas from "./pages/Tiendas";
import SeleccionRegistro from "./pages/SeleccionRegistro";
import RegistroGenerico from "./pages/RegistroGenerico";
import QuienesSomos from "./pages/QuienesSomos";
import Contactanos from "./pages/Contactanos";

function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/register" element={<SeleccionRegistro />} />
        <Route path="/login" element={<Login />} />
        <Route path="/tiendas" element={<Tiendas />} />
        <Route path="/registrar" element={<SeleccionRegistro />} />
        <Route path="/registro/usuario" element={<Register />} />
        <Route path="/registro/:tipo" element={<RegistroGenerico />} /> 
        <Route path="/quienes-somos" element={<QuienesSomos />} />
        <Route path="/contactanos" element={<Contactanos />} />
      </Routes>
      <Footer />
    </Router>
  );
}

export default App;
