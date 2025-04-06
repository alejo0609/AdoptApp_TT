import React from "react";
import { BrowserRouter as Router, Routes, Route, useNavigate } from "react-router-dom";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";
import Home from "./pages/Home";
import Register from "./components/Register";
import Login from "./pages/Login";
import Tiendas from "./pages/Tiendas";
import Adopta from "./pages/Adopta";
import Contactanos from "./pages/Contactanos";
import Cuidador from "./pages/Cuidador";
import QuienesSomos from "./pages/QuienesSomos";
import FormularioAdopcion from "./components/FormularioAdopcion";
import RegistroGenerico from "./pages/RegistroGenerico";
import SeleccionRegistro from "./pages/SeleccionRegistro";

import useSession from "./hooks/useSession";
import useSessionTimeout from "./hooks/useSession";

function AppWithSession() {
  const { cerrarSesion, usuario } = useSession();
  const navigate = useNavigate();

  const handleTimeout = () => {
    if (usuario) {
      alert("Sesión cerrada por inactividad");
      cerrarSesion();
      navigate("/login");
    }
  };

  // ✅ Aplica el control de inactividad global
  useSessionTimeout(handleTimeout);

  return (
    <>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/register" element={<Register />} />
        <Route path="/login" element={<Login />} />
        <Route path="/tiendas" element={<Tiendas />} />
        <Route path="/adopta" element={<Adopta />} />
        <Route path="/cuidador" element={<Cuidador />} />
        <Route path="/contactanos" element={<Contactanos />} />
        <Route path="/quienes-somos" element={<QuienesSomos />} />
        <Route path="/adopcion/:idAnimal" element={<FormularioAdopcion />} />
        <Route path="/registro" element={<SeleccionRegistro />} />
        <Route path="/registro/:tipo" element={<RegistroGenerico />} />
      </Routes>
      <Footer />
    </>
  );
}

function App() {
  return (
    <Router>
      <AppWithSession />
    </Router>
  );
}

export default App;
