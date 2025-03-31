import React, { useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";

function RegistroGenerico() {
  const { tipo } = useParams();

  const [formData, setFormData] = useState({});
  const [mensaje, setMensaje] = useState("");
  const [error, setError] = useState("");

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      let endpoint = "";
      switch (tipo) {
        case "usuario":
        case "cuidador":
          endpoint = "http://localhost:8080/usuarios";
          break;
        case "tienda":
          endpoint = "http://localhost:8080/tiendas";
          break;
        case "animal":
        case "mascota":
          endpoint = "http://localhost:8080/adopta";
          break;
        default:
          throw new Error("Tipo de registro no reconocido");
      }

      await axios.post(endpoint, formData);
      setMensaje("Registro exitoso");
      setError("");
      setFormData({});
    } catch (err) {
      setError("Ocurrió un error al registrar. Intenta nuevamente.");
      setMensaje("");
      console.error(err);
    }
  };

  const Input = ({ label, name, type = "text" }) => (
    <div className="mb-4">
      <label className="block text-gray-700 font-semibold">{label}</label>
      <input
        type={type}
        name={name}
        value={formData[name] || ""}
        onChange={handleChange}
        required
        className="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-green-400"
      />
    </div>
  );

  const Select = ({ label, name, options }) => (
    <div className="mb-4">
      <label className="block text-gray-700 font-semibold">{label}</label>
      <select
        name={name}
        value={formData[name] || ""}
        onChange={handleChange}
        required
        className="w-full px-4 py-2 border rounded-md"
      >
        {options.map((opt, index) => (
          <option key={index} value={opt.value}>{opt.text}</option>
        ))}
      </select>
    </div>
  );

  const renderCampos = () => {
    switch (tipo) {
      case "usuario":
      case "cuidador":
        return (
          <>
            <Input label="Nombre" name="nombre" />
            <Input label="DNI" name="dni" />
            <Input label="Dirección" name="direccion" />
            <Input label="Ciudad" name="ciudad" />
            <Input label="Teléfono" name="telefono" />
            <Input label="Correo Electrónico" name="email" type="email" />
            <Input label="Contraseña" name="password" type="password" />
          </>
        );
      case "tienda":
        return (
          <>
            <Input label="Nombre de la tienda" name="nombre" />
            <Input label="Dirección" name="direccion" />
            <Input label="Ciudad" name="ciudad" />
            <Input label="Teléfono" name="telefono" />
            <Input label="Correo Electrónico" name="email" type="email" />
            <Input label="Contraseña" name="password" type="password" />
          </>
        );
      case "animal":
      case "mascota":
        return (
          <>
            <Input label="Nombre del Animal" name="nombre_animal" />
            <Input label="Raza" name="raza" />
            <Input label="Edad" name="edad" type="number" />
            <Input label="Imagen (nombre del archivo)" name="imagen_animal" />
            <Select
              label="Estado del Animal"
              name="estado_animal"
              options={[
                { value: "", text: "Selecciona estado" },
                { value: "1", text: "Disponible" },
                { value: "0", text: "Adoptado" },
              ]}
            />
            <Select
              label="Esterilizado"
              name="esterilizado"
              options={[
                { value: "", text: "Esterilizado" },
                { value: "1", text: "Sí" },
                { value: "0", text: "No" },
              ]}
            />
          </>
        );
      default:
        return <p className="text-red-500">Tipo de registro no válido</p>;
    }
  };

  return (
    <div className="min-h-screen flex items-center justify-center bg-green-50">
      <div className="bg-white p-8 rounded-lg shadow-lg w-full max-w-md text-center">
        <h2 className="text-2xl font-bold mb-6 text-green-700">
          Registrar {tipo.charAt(0).toUpperCase() + tipo.slice(1)}
        </h2>

        {mensaje && <p className="text-green-500 mb-4">{mensaje}</p>}
        {error && <p className="text-red-500 mb-4">{error}</p>}

        <form onSubmit={handleSubmit}>
          {renderCampos()}
          <button
            type="submit"
            className="w-full bg-green-600 text-white py-2 rounded-md font-bold hover:bg-green-700 transition"
          >
            Registrar
          </button>
        </form>
      </div>
    </div>
  );
}

export default RegistroGenerico;
