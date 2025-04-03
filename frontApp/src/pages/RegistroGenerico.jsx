import React, { useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";

function RegistroGenerico() {
  const { tipo } = useParams();

  const [formData, setFormData] = useState({});
  const [mensaje, setMensaje] = useState("");
  const [error, setError] = useState("");

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    let endpoint = "";
    switch (tipo) {
      case "usuario":
      case "cuidador":
        endpoint = "http://localhost:8080/usuarios";
        break;
      case "tienda":
        endpoint = "http://localhost:8080/tiendas";
        break;
      case "mascota":
        endpoint = "http://localhost:8080/adopta";
        break;
      default:
        setError("Tipo de registro no reconocido");
        return;
    }

    try {
      await axios.post(endpoint, formData);
      setMensaje("Registro exitoso");
      setError("");
      setFormData({});
    } catch (err) {
      console.error("Error:", err);
      setError("Ocurrió un error al registrar");
      setMensaje("");
    }
  };

  const Input = ({ label, name, type = "text" }) => (
    <div className="mb-4 text-left">
      <label className="block text-gray-700 font-semibold mb-1">{label}</label>
      <input
        type={type}
        name={name}
        value={formData[name] || ""}
        onChange={handleChange}
        className="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-green-400"
        required
      />
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
              <Input label="Barrio" name="barrio" />
              <Input label="Ciudad" name="ciudad" />
              <Input label="Teléfono" name="telefono" />
              <Input label="Correo Electrónico" name="correo_electronico" type="email" />
              <Input label="Sitio Web" name="sitio_web" />
              <Input label="Contraseña" name="password" type="password" />
            </>
          );
      case "mascota":
        return (
          <>
            <Input label="Nombre del Animal" name="nombre_animal" />
            <Input label="Raza" name="raza" />
            <Input label="Edad" name="edad" type="number" />
            <Input label="Imagen del Animal" name="imagen_animal" />
            <div className="mb-4 text-left">
              <label className="block text-gray-700 font-semibold mb-1">Estado del Animal</label>
              <select
                name="estado_animal"
                value={formData.estado_animal || ""}
                onChange={handleChange}
                className="w-full px-4 py-2 border rounded-md"
                required
              >
                <option value="">Selecciona estado</option>
                <option value="1">Disponible</option>
                <option value="0">Adoptado</option>
              </select>
            </div>
            <div className="mb-4 text-left">
              <label className="block text-gray-700 font-semibold mb-1">Esterilizado</label>
              <select
                name="esterilizado"
                value={formData.esterilizado || ""}
                onChange={handleChange}
                className="w-full px-4 py-2 border rounded-md"
                required
              >
                <option value="">Selecciona</option>
                <option value="1">Sí</option>
                <option value="0">No</option>
              </select>
            </div>
          </>
        );
      default:
        return <p className="text-red-500">Tipo de formulario no reconocido</p>;
    }
  };

  return (
    <div className="min-h-screen flex items-center justify-center bg-green-50">
      <div className="bg-white p-8 rounded-lg shadow-lg w-full max-w-md">
        <h2 className="text-2xl font-bold mb-4 text-center text-green-700">
          Registrar {tipo}
        </h2>

        {mensaje && <p className="text-green-500 text-center mb-4">{mensaje}</p>}
        {error && <p className="text-red-500 text-center mb-4">{error}</p>}

        <form onSubmit={handleSubmit}>
          {renderCampos()}
          <button
            type="submit"
            className="w-full bg-green-600 text-white py-2 rounded-md font-bold hover:bg-green-700 transition mt-4"
          >
            Registrar
          </button>
        </form>
      </div>
    </div>
  );
}

export default RegistroGenerico;

