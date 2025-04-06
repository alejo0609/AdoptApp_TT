
package com.pruebas.service;

import com.pruebas.model.AdopcionModel;
import com.pruebas.model.AnimalModel;
import com.pruebas.repository.AdopcionRepository;
import com.pruebas.repository.AnimalRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AdopcionServiceTest {

    @Mock
    private AdopcionRepository adopcionRepository;

    @Mock
    private AnimalRepository animalRepository;

    @Mock
    private EmailService emailService;

    @InjectMocks
    private AdopcionService adopcionService;

    @Test
    public void testGuardarAdopcionYEnvioCorreo() {
        // Datos de prueba
        AdopcionModel adopcion = new AdopcionModel();
        adopcion.setCorreo("prueba@example.com");
        adopcion.setIdAnimal(1);

        AnimalModel animal = new AnimalModel();
        animal.setIdAnimal(1);
        animal.setNombreAnimal("Firulais");

        when(animalRepository.findById(1)).thenReturn(Optional.of(animal));
        when(adopcionRepository.save(adopcion)).thenReturn(adopcion);

        AdopcionModel resultado = adopcionService.guardarAdopcion(adopcion);

        verify(adopcionRepository).save(adopcion);
        verify(emailService).enviarCorreoAgradecimiento("prueba@example.com", "Firulais");
        assertEquals(adopcion, resultado);
    }

    @Test
        public void testGuardarAdopcionCuandoAnimalNoExisteLanzaExcepcion() {
            AdopcionModel adopcion = new AdopcionModel();
            adopcion.setIdAnimal(999); // ID que no existe

            when(animalRepository.findById(999)).thenReturn(Optional.empty());

            RuntimeException exception = assertThrows(RuntimeException.class, () -> {
                adopcionService.guardarAdopcion(adopcion);
            });

            assertEquals("Animal no encontrado", exception.getMessage());
        }

}

