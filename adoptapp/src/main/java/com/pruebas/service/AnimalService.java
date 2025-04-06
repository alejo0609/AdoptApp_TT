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

    // ✅ Obtiene los últimos 4 animales disponibles para adopción
    public List<AnimalModel> obtenerUltimos4Animales() {
        return animalRepository.findTop4ByEstadoAnimalTrueOrderByIdAnimalDesc();
    }
    
    // ✅ Obtiene los animales disponibles para adopción
    public List<AnimalModel> obtenerAnimalesDisponibles() {
        return animalRepository.findByEstadoAnimalTrueOrderByIdAnimalDesc();
    }

    // ✅ Obtiene los animales que NO están disponibles para adopción
    public List<AnimalModel> obtenerAnimalesNoDisponibles() {
        return animalRepository.findByEstadoAnimalFalseOrderByIdAnimalDesc();
    }
    
    // ✅ Obtiene todos los animales
    public List<AnimalModel> findAll() {
        return animalRepository.findAll();
    }

    // ✅ Busqueda por nombre del animal
    public List<AnimalModel> buscarPorNombre(String nombre) {
        return animalRepository.findByNombreAnimal(nombre);
    }
    // ✅ Busqueda por raza del animal
    public List<AnimalModel> buscarPorRaza(String raza) {
        return animalRepository.findByRaza(raza);
    }
    // ✅ Busqueda por Eterilización del animal
        public List<AnimalModel> buscarEsterilizados() {
            return animalRepository.findByEsterilizadoTrue();
        }
    // ✅ Busqueda por el estado del animal
    public List<AnimalModel> buscarPorEdad(String edad) {
        return animalRepository.findByEdad(edad);
    }


        public List<AnimalModel> saveAll(List<AnimalModel> animals) {
        return animalRepository.saveAll(animals);
    }

    // ✅ Obtener un animal por ID
    public Optional<AnimalModel> findById(Integer id) {
        return animalRepository.findById(id);
    }

    // ✅ Crear o actualizar un animal
    public AnimalModel save(AnimalModel animal) {
        return animalRepository.save(animal);
    }



    // ✅ Eliminar un animal por ID
    public void deleteById(Integer id) {
        animalRepository.deleteById(id);
    }
}
