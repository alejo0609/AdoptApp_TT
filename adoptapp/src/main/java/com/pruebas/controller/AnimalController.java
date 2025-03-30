package com.pruebas.controller;

import com.pruebas.model.AnimalModel;
import com.pruebas.service.animales.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador para gestionar los animales disponibles para adopción.
 * Proporciona endpoints para realizar operaciones CRUD sobre los animales.
 * 
 * @author Alejandro Perez CC 8.029.742
 * @author Julian David Giraldo Murillo CC 1.007.240.094
 * @author Andres Escobar Vasquez CC 1.038.096.962
 * @author Jorge Andres Restrepo Cataño CC 98.648.720
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/adopta")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    /**
     * Obtiene los últimos 10 animales disponibles.
     * 
     * @return Lista con los últimos 10 animales registrados en el sistema.
     */
    @GetMapping("/ultimos")
    public List<AnimalModel> obtenerUltimos10Animales() {
        return animalService.obtenerUltimos10Animales();
    }

    /**
     * Obtiene todos los animales registrados en la base de datos.
     * 
     * @return Lista de todos los animales disponibles.
     */
    @GetMapping
    public List<AnimalModel> getAllAnimals() {
        return animalService.findAll();
    }

    /**
     * Obtiene un animal específico por su ID.
     * 
     * @param id Identificador del animal.
     * @return El animal encontrado o un Optional vacío si no existe.
     */
    @GetMapping("/{id}")
    public Optional<AnimalModel> getAnimalById(@PathVariable Integer id) {
        return animalService.findById(id);
    }

    /**
     * Registra un nuevo animal en la base de datos.
     * 
     * @param animal Datos del animal a registrar.
     * @return El animal creado.
     */
    @PostMapping
    public AnimalModel createAnimal(@RequestBody AnimalModel animal) {
        return animalService.save(animal);
    }

    /**
     * Registra múltiples animales en una sola operación.
     * 
     * @param animals Lista de animales a registrar.
     * @return Lista de animales creados.
     */
    @PostMapping("/bulk")
    public List<AnimalModel> createMultipleAnimals(@RequestBody List<AnimalModel> animals) {
        return animalService.saveAll(animals);
    }

    /**
     * Actualiza la información de un animal existente.
     * 
     * @param id Identificador del animal a actualizar.
     * @param animal Datos actualizados del animal.
