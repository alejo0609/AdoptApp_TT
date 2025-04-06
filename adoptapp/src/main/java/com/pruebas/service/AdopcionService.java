 /** 
 * @author Alejandro Perez CC 8.029.742
 * @author Julian David Giraldo Murillo CC 1.007.240.094
 * @author Andres Escobar Vasquez CC 1.038.096.962
 * @author Jorge Andres Restrepo Cataño CC 98.648.720
 **/
 
package com.pruebas.service;

import com.pruebas.model.AdopcionModel;
import com.pruebas.model.AnimalModel;
import com.pruebas.repository.AdopcionRepository;
import com.pruebas.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdopcionService {

    @Autowired
    private AdopcionRepository adopcionRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private EmailService emailService;

public AdopcionModel save(AdopcionModel adopcion) {
    return adopcionRepository.save(adopcion);
}

    public AdopcionModel guardarAdopcion(AdopcionModel adopcion) {
        Optional<AnimalModel> animal = animalRepository.findById(adopcion.getIdAnimal());
        if (animal.isEmpty()) {
            throw new RuntimeException("Animal no encontrado");
        }

        String nombreAnimal = animal.get().getNombreAnimal();
        AdopcionModel nuevaAdopcion = adopcionRepository.save(adopcion);

        emailService.enviarCorreoAgradecimiento(
            adopcion.getCorreo(),
            nombreAnimal
        );

        String correoTienda = animal.get().getCorreoTienda();
        String nombreAdoptante = adopcion.getNombre();

        if (correoTienda != null && !correoTienda.isEmpty()) {
            emailService.enviarCorreoATienda(
                correoTienda,
                nombreAnimal,
                nombreAdoptante
            );
        }

        return nuevaAdopcion;
    }


    public List<AdopcionModel> findAll() {
        return adopcionRepository.findAll();
    }

    public Optional<AdopcionModel> findById(Integer id) {
        return adopcionRepository.findById(id);
    }

    public void deleteById(Integer id) {
        adopcionRepository.deleteById(id);
    }
}
