
// useSession.js
import { useState } from "react";

export default function useSession() {
  const [usuario, setUsuario] = useState(() => {
    const saved = localStorage.getItem("usuarioLogueado");
    return saved ? JSON.parse(saved) : null;
  });

  const iniciarSesion = (usuario) => {
    setUsuario(usuario);
    localStorage.setItem("usuarioLogueado", JSON.stringify(usuario));
  };

  const cerrarSesion = () => {
    setUsuario(null);
    localStorage.removeItem("usuarioLogueado");
  };

  return { usuario, iniciarSesion, cerrarSesion };
}
