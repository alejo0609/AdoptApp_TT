// // src/hooks/useUserLocation.js
// import { useState, useEffect } from "react";

// const useUserLocation = () => {
//   const [coords, setCoords] = useState(null);

//   useEffect(() => {
//     const geoSuccess = (position) => {
//       setCoords({
//         lat: position.coords.latitude,
//         lon: position.coords.longitude,
//       });
//     };

//     const geoError = (error) => {
//       console.error("Error al obtener ubicación:", error);
//     };

//     if (navigator.geolocation) {
//       navigator.geolocation.getCurrentPosition(geoSuccess, geoError);
//     } else {
//       console.warn("Geolocalización no está soportada por este navegador.");
//     }
//   }, []);

//   return coords;
// };

// export default useUserLocation;
// src/hooks/useUserLocation.js
import { useState, useEffect } from 'react';

const useUserLocation = () => {
  const [coords, setCoords] = useState(null);

  useEffect(() => {
    const geoSuccess = (position) => {
      setCoords({
        lat: position.coords.latitude,
        lon: position.coords.longitude,
      });
    };

    const geoError = (error) => {
      console.error('Error al obtener ubicación:', error);
    };

    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(geoSuccess, geoError);
    } else {
      console.warn('Geolocalización no está soportada por este navegador.');
    }
  }, []);

  return coords;
};

export default useUserLocation;