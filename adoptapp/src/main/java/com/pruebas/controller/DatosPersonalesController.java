package com.pruebas.controller;

import com.pruebas.model.DatosPersonalesModel;
import com.pruebas.service.DatosPersonalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/datos_personales")
public class DatosPersonalesController {

    @Autowired
    private DatosPersonalesService datosPersonalesService;

    @GetMapping
    public List<DatosPersonalesModel> obtenerTodos() {
        return datosPersonalesService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<DatosPersonalesModel> obtenerPorId(@PathVariable int id) {
        return datosPersonalesService.obtenerPorId(id);
    }

    @PostMapping
    public DatosPersonalesModel guardar(@RequestBody DatosPersonalesModel datosPersonales) {
        return datosPersonalesService.guardar(datosPersonales);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return datosPersonalesService.eliminar(id) ? "Eliminado correctamente" : "No se encontró el ID";
    }
}
