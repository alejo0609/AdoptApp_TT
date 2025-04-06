import { useParams, useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import axios from "axios";

const FormularioAdopcion = () => {
  const { idAnimal } = useParams();
  const navigate = useNavigate();
  const [animal, setAnimal] = useState(null);
  const [form, setForm] = useState({
    nombre: "",
    correo: "",
    telefono: "",
    direccion: ""
  });
  const [enviado, setEnviado] = useState(false);

  useEffect(() => {
    // Cargar info del animal (puede venir de mock o axios si decides activarlo)
    axios.get(`http://localhost:8080/animal/${idAnimal}`)
      .then(res => setAnimal(res.data))
      .catch(() => {
        // Si no hay backend, simulamos un animal
        setAnimal({
          nombre_animal: "Animal de prueba",
          raza: "Mestizo",
          edad: "2",
          imagen_animal: "perro1.jpg"
        });
      });
  }, [idAnimal]);

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setEnviado(true);

    // Solo frontend, podrías guardar en localStorage si quieres
    console.log("Datos enviados:", {
      ...form,
      idAnimal: idAnimal
    });

    setTimeout(() => navigate("/"), 2500);
  };

  if (!animal) return <p className="p-4">Cargando información del animal...</p>;

  return (
    <div className="max-w-xl mx-auto p-6">
      <h1 className="text-2xl font-bold mb-4 text-green-700">Formulario de Adopción</h1>

      <div className="border p-4 rounded-lg shadow mb-6 bg-white">
        <h2 className="text-lg font-semibold">{animal.nombre_animal}</h2>
        <p><strong>Raza:</strong> {animal.raza}</p>
        <p><strong>Edad:</strong> {animal.edad} años</p>
        <img
          src={`/aset/${animal.imagen_animal}`}
          alt={animal.nombre_animal}
          className="w-full h-48 object-cover mt-2 rounded"
        />
      </div>

      {enviado ? (
        <div className="bg-green-100 text-green-800 p-4 rounded text-center">
          ¡Gracias por tu interés en adoptar! 💚<br />Redirigiendo...
        </div>
      ) : (
        <form onSubmit={handleSubmit} className="space-y-4">
          <input
            type="text"
            name="nombre"
            placeholder="Tu nombre completo"
            className="w-full border p-2 rounded"
            value={form.nombre}
            onChange={handleChange}
            required
          />
          <input
            type="email"
            name="correo"
            placeholder="Correo electrónico"
            className="w-full border p-2 rounded"
            value={form.correo}
            onChange={handleChange}
            required
          />
          <input
            type="tel"
            name="telefono"
            placeholder="Teléfono"
            className="w-full border p-2 rounded"
            value={form.telefono}
            onChange={handleChange}
            required
          />
          <input
            type="text"
            name="direccion"
            placeholder="Dirección"
            className="w-full border p-2 rounded"
            value={form.direccion}
            onChange={handleChange}
            required
          />
          <button
            type="submit"
            className="bg-blue-600 hover:bg-blue-700 text-white px-4 py-2 rounded w-full transition"
          >
            Enviar solicitud de adopción
          </button>
        </form>
      )}
    </div>
  );
};

export default FormularioAdopcion;
