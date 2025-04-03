import { useState } from "react";
import { useNavigate } from "react-router-dom";

function Login() {
  const [formData, setFormData] = useState({ email: "", password: "" });
  const [errors, setErrors] = useState("");
  const navigate = useNavigate(); // Para redirigir después del login

  const handleChange = (e) => setFormData({ ...formData, [e.target.name]: e.target.value });

  const handleSubmit = async (e) => {
    e.preventDefault();
  
    const response = await fetch("http://localhost:8080/usuario/autenticar", { // Cambiar a /autenticar
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(formData),
    });
  
    const data = await response.json();
  
    if (response.ok && data.mensaje === "Inicio de sesión exitoso") {
      alert("¡Inicio de sesión exitoso!");
      navigate("/adopta");
    } else {
      setErrors("Credenciales incorrectas. Inténtalo de nuevo.");
    }
  };  

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <input type="email" name="email" onChange={handleChange} required placeholder="Correo" />
        <input type="password" name="password" onChange={handleChange} required placeholder="Contraseña" />
        <button type="submit">Iniciar Sesión</button>
      </form>
      {errors && <p>{errors}</p>}
    </div>
  );
}

export default Login;