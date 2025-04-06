import React from "react";
import { Link } from "react-router-dom"; // Necesitamos Link para hacer la navegación
import PropTypes from "prop-types";

const AnimalCard = ({ animal }) => {
  return (
    <div className="animal-card">
      <h3>{animal.nombreAnimal}</h3>
      <p>Raza: {animal.raza}</p>
      <p>Edad: {animal.edad}</p>

      {/* Botón para acceder al formulario de adopción */}
      <Link 
        to={`/formulario-adopcion/${animal.idAnimal}`}
        className="btn-adoptar"
      >
        Adoptar
      </Link>
    </div>
  );
};

AnimalCard.propTypes = {
  animal: PropTypes.shape({
    idAnimal: PropTypes.number.isRequired,
    nombreAnimal: PropTypes.string.isRequired,
    raza: PropTypes.string.isRequired,
    edad: PropTypes.number.isRequired,
  }).isRequired,
};

export default AnimalCard;
