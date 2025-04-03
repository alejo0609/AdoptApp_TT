package com.pruebas.controller;

import com.pruebas.model.Cuidador;
import com.pruebas.repository.CuidadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuidadores")
public class CuidadorController {

    @Autowired
    private CuidadorRepository cuidadorRepository;

    @GetMapping
    public List<Cuidador> obtenerTodosLosCuidadores() {
        return cuidadorRepository.findAll();
    }

    @PostMapping
    public Cuidador crearCuidador(@RequestBody Cuidador cuidador) {
        return cuidadorRepository.save(cuidador);
    }

    // Otros métodos según sea necesario
}
