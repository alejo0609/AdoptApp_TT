 /** 
 * @author Alejandro Perez CC 8.029.742
 * @author Julian David Giraldo Murillo CC 1.007.240.094
 * @author Andres Escobar Vasquez CC 1.038.096.962
 * @author Jorge Andres Restrepo Cataño CC 98.648.720
 **/
 
package com.pruebas.controller;

import com.pruebas.model.HistoriaAnimalModel;
import com.pruebas.service.HistoriaAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/historia_animales")
public class HistoriaAnimalController {

    @Autowired
    private HistoriaAnimalService historiaAnimalService;

    @GetMapping
    public List<HistoriaAnimalModel> obtenerTodos() {
        return historiaAnimalService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<HistoriaAnimalModel> obtenerPorId(@PathVariable int id) {
        return historiaAnimalService.obtenerPorId(id);
    }

    @PostMapping
    public HistoriaAnimalModel guardar(@RequestBody HistoriaAnimalModel historiaAnimal) {
        return historiaAnimalService.guardar(historiaAnimal);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return historiaAnimalService.eliminar(id) ? "Eliminado correctamente" : "No se encontró el ID";
    }
}