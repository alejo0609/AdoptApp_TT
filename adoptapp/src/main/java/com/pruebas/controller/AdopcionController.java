package com.pruebas.controller;

import com.pruebas.model.AdopcionModel;
import com.pruebas.service.AdopcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador para gestionar las adopciones.
 * Proporciona endpoints para realizar operaciones CRUD sobre las adopciones.
 * 
 * @author Alejandro Perez CC 8.029.742
 * @author Julian David Giraldo Murillo CC 1.007.240.094
 * @author Andres Escobar Vasquez CC 1.038.096.962
 * @author Jorge Andres Restrepo Cataño CC 98.648.720
 */
@RestController
@RequestMapping("/adopciones")
public class AdopcionController {

    @Autowired
    private AdopcionService adopcionService;

    /**
     * Obtiene todas las adopciones registradas.
     * 
     * @return Lista de todas las adopciones.
     */
    @GetMapping
    public List<AdopcionModel> getAllAdopcions() {
        return adopcionService.findAll();
    }

    /**
     * Obtiene una adopción específica por su ID.
     * 
     * @param id Identificador de la adopción.
     * @return La adopción encontrada o un Optional vacío si no existe.
     */
    @GetMapping("/{id}")
    public Optional<AdopcionModel> getAdopcionById(@PathVariable Integer id) {
        return adopcionService.findById(id);
    }

    /**
     * Crea una nueva adopción.
     * 
     * @param adopcion Datos de la adopción a registrar.
     * @return La adopción creada.
     */
    @PostMapping
    public AdopcionModel createAdopcion(@RequestBody AdopcionModel adopcion) {
        return adopcionService.save(adopcion);
    }

    /**
     * Actualiza una adopción existente.
     * 
     * @param id Identificador de la adopción a actualizar.
     * @param adopcion Datos actualizados de la adopción.
     * @return La adopción actualizada.
     */
    @PutMapping("/{id}")
    public AdopcionModel updateAdopcion(@PathVariable Integer id, @RequestBody AdopcionModel adopcion) {
        adopcion.setIdAdopcion(id);
        return adopcionService.save(adopcion);
    }

    /**
     * Elimina una adopción por su ID.
     * 
     * @param id Identificador de la adopción a eliminar.
     */
    @DeleteMapping("/{id}")
    public void deleteAdopcion(@PathVariable Integer id) {
        adopcionService.deleteById(id);
    }
}