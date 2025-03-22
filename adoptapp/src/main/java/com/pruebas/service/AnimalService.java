//package com.pruebas.model;
package com.pruebas.service.animales;

import com.pruebas.model.AnimalModel;
import com.pruebas.repository.AnimalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepo animalRepo;

    // ✅ Obtener todos los animales
    public List<AnimalModel> findAll() {
        return animalRepo.findAll();
    }

    // ✅ Obtener un animal por ID
    public Optional<AnimalModel> findById(Integer id) {
        return animalRepo.findById(id);
    }

    // ✅ Crear o actualizar un animal
    public AnimalModel save(AnimalModel animal) {
        return animalRepo.save(animal);
    }

    // ✅ Eliminar un animal por ID
    public void deleteById(Integer id) {
        animalRepo.deleteById(id);
    }
}
