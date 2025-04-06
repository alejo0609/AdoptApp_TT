// src/utils/ruta.js

export const calcularTiempoLlegada = async (origen, destino, apiKey) => {
    const url = `https://api.openrouteservice.org/v2/directions/driving-car?api_key=${apiKey}`;
  
    const body = {
      coordinates: [
        [origen.lon, origen.lat],
        [destino.lon, destino.lat],
      ],
    };
  
    try {
      const response = await fetch(url, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          Accept: "application/json, application/geo+json, application/gpx+xml, img/png; charset=utf-8",
        },
        body: JSON.stringify(body),
      });
  
      const data = await response.json();
      const segundos = data.features[0].properties.summary.duration;
      const minutos = Math.round(segundos / 60);
      return `${minutos} min`;
    } catch (error) {
      console.error("Error al calcular tiempo de llegada:", error);
      return "N/A";
    }
  };