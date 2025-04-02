import React from 'react';
import { Swiper, SwiperSlide } from 'swiper/react';
import { Navigation, Pagination, Autoplay, EffectFade } from 'swiper/modules';

// Importar estilos de Swiper
import 'swiper/css';
import 'swiper/css/navigation';
import 'swiper/css/pagination';
import 'swiper/css/effect-fade'; // Efecto de transición suave
import 'animate.css'; // Animaciones

// Importar imágenes desde assets
import image1 from '../assets/image1.jpg';
import image2 from '../assets/image2.jpg';
import image3 from '../assets/image3.jpg';

function Carousel() {
  const slides = [
    {
      image: image1,
      text: "Adopta un perro y dale una segunda oportunidad 🐶💙",
      bgColor: "bg-gray-500",
    },
    {
      image: image2,
      text: "Los gatos también necesitan amor y un hogar 🐱❤️",
      bgColor: "bg-green-800",
    },
    {
      image: image3,
      text: "Un cuidador salva vidas todos los días. ¡Únete! 🐾🌎",
      bgColor: "bg-yellow-800",
    }
  ];

  return (
    <div className="w-full h-[500px] relative">
      <Swiper
        modules={[Navigation, Pagination, Autoplay, EffectFade]}
        spaceBetween={0}
        slidesPerView={1}
        navigation
        pagination={{ clickable: true }}
        autoplay={{ delay: 5000, disableOnInteraction: false }}
        loop={true}
        effect="fade"
        className="w-full h-full"
      >
        {slides.map((slide, index) => (
          <SwiperSlide key={index} className="relative w-full h-full">
            {/* Imagen de fondo */}
            <img src={slide.image} alt={`Slide ${index + 1}`} className="w-full h-full object-cover" />

            {/* Mensaje sobre la imagen con margen y mejor alineación */}
            <div className={`absolute inset-0 flex flex-col items-center justify-center text-white ${slide.bgColor} bg-opacity-60 p-6`}>
              <h2 className="text-3xl md:text-5xl font-bold animate__animated animate__fadeInDown mx-auto text-center p-4">
                {slide.text}
              </h2>
            </div>
          </SwiperSlide>
        ))}
      </Swiper>
    </div>
  );
}

export default Carousel;