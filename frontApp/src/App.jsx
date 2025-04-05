import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";
import Home from "./pages/Home";
import Register from "./components/Register";
import Login from './pages/Login';
import Tiendas from "./pages/Tiendas";
import RegistrarTienda from "./pages/RegistrarTienda";
import Adopta from "./pages/Adopta";
import QuienesSomos from "./pages/QuienesSomos";
import Clientes from "./pages/Clientes";
import Contactanos from "./pages/Contactanos";

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
        <Route path="/adopta" element={<Adopta />} /> 
        <Route path="/quienes-somos" element={<QuienesSomos />} />
        <Route path="/clientes" element={<Clientes />} />
        <Route path="/registro/usuario" element={<Register />} />
        <Route path="/contactanos" element={<Contactanos />} />

      </Routes>
      <Footer />
    </Router>
  );
}

export default App;