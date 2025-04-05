package com.pruebas.controller;

import com.pruebas.model.AdopcionModel;
import com.pruebas.service.AdopcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/adopciones")
public class AdopcionController {

    @Autowired
    private AdopcionService adopcionService;

 
    // ✅ Obtener todos los adopciones
    @GetMapping
    public List<AdopcionModel> getAllAdopcions() {
        return adopcionService.findAll();
    }
  

    // ✅ Obtener un adopcion por ID
    @GetMapping("/{id}")
    public Optional<AdopcionModel> getAdopcionById(@PathVariable Integer id) {
        return adopcionService.findById(id);
    }

    // ✅ Crear un nuevo adopcion
    @PostMapping
    public AdopcionModel createAdopcion(@RequestBody AdopcionModel adopcion) {
        return adopcionService.save(adopcion);
    }

    // ✅ Actualizar un adopcion existente
    @PutMapping("/{id}")
    public AdopcionModel updateAdopcion(@PathVariable Integer id, @RequestBody AdopcionModel adopcion) {
        adopcion.setIdAdopcion(id);
        return adopcionService.save(adopcion);
    }

    // ✅ Eliminar un adopcion
    @DeleteMapping("/{id}")
    public void deleteAdopcion(@PathVariable Integer id) {
        adopcionService.deleteById(id);
    }

    
}