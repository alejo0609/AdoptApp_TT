package com.pruebas.controller;

import com.pruebas.model.TipoAnimalModel;
import com.pruebas.service.TipoAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tipo_animales")
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
