package com.pruebas.service;

import com.pruebas.model.AnimalModel;
import com.pruebas.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    // ✅ Obtiene los últimos 10 animales disponibles para adopción
    public List<AnimalModel> obtenerUltimos10Animales() {
        return animalRepository.findTop10ByEstadoAnimalTrueOrderByIdAnimalDesc();
    }
    
    // ✅ Obtiene todos los animales
    public List<AnimalModel> findAll() {
        return animalRepository.findAll();
    }

    // ✅ Obtener un animal por ID
    public Optional<AnimalModel> findById(Integer id) {
        return animalRepository.findById(id);
    }

    // ✅ Crear o actualizar un animal
    public AnimalModel save(AnimalModel animal) {
        return animalRepository.save(animal);
    }

    public List<AnimalModel> saveAll(List<AnimalModel> animals) {
        return animalRepository.saveAll(animals);
    }

    // ✅ Eliminar un animal por ID
    public void deleteById(Integer id) {
        animalRepository.deleteById(id);
    }
}
