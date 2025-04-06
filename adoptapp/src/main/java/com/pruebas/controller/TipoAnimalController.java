 /** 
 * @author Alejandro Perez CC 8.029.742
 * @author Julian David Giraldo Murillo CC 1.007.240.094
 * @author Andres Escobar Vasquez CC 1.038.096.962
 * @author Jorge Andres Restrepo Cataño CC 98.648.720
 **/
 
package com.pruebas.controller;

import com.pruebas.model.TipoAnimalModel;
import com.pruebas.service.TipoAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tipo_animal")
public class TipoAnimalController {

    @Autowired
    private TipoAnimalService tipoAnimalService;

    @GetMapping
    public List<TipoAnimalModel> obtenerTodos() {
        return tipoAnimalService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<TipoAnimalModel> obtenerPorId(@PathVariable int id) {
        return tipoAnimalService.obtenerPorId(id);
    }

    @PostMapping
    public TipoAnimalModel guardar(@RequestBody TipoAnimalModel tipoAnimal) {
        return tipoAnimalService.guardar(tipoAnimal);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return tipoAnimalService.eliminar(id) ? "Eliminado correctamente" : "No se encontró el ID";
    }
}