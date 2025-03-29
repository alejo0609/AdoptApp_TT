package com.pruebas.controller;

import com.pruebas.model.AnimalModel;
import com.pruebas.service.animales.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:5173")


@RestController
@RequestMapping("/animales")
public class AnimalController {

    @Autowired
    private AnimalService animalService;
    
    @GetMapping("/ultimos")
        public List<AnimalModel> obtenerUltimos10Animales() {
        return animalService.obtenerUltimos10Animales();
    }
 
    // ✅ Obtener todos los animales
    @GetMapping
    public List<AnimalModel> getAllAnimals() {
        return animalService.findAll();
    }
  

    // ✅ Obtener un animal por ID
    @GetMapping("/{id}")
    public Optional<AnimalModel> getAnimalById(@PathVariable Integer id) {
        return animalService.findById(id);
    }

    public List<AnimalModel> getLastTenAnimals() {
        return animalService.findLastTen();
    }

    // ✅ Crear un nuevo animal
    @PostMapping
    public AnimalModel createAnimal(@RequestBody AnimalModel animal) {
        return animalService.save(animal);
    }
    @PostMapping("/bulk")
        public List<AnimalModel> createMultipleAnimals(@RequestBody List<AnimalModel> animals) {
        return animalService.saveAll(animals);
    }

    // ✅ Actualizar un animal existente
    @PutMapping("/{id}")
    public AnimalModel updateAnimal(@PathVariable Integer id, @RequestBody AnimalModel animal) {
        animal.setIdAnimal(id);
        return animalService.save(animal);
    }

    // ✅ Eliminar un animal
    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable Integer id) {
        animalService.deleteById(id);
    }
}