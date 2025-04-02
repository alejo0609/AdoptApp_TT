package com.pruebas.controller;

import com.pruebas.model.DetalleAdopcionModel;
import com.pruebas.service.DetalleAdopcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detalle_adopciones")
public class DetalleAdopcionController {

    @Autowired
    private DetalleAdopcionService detalleAdopcionService;

    @GetMapping
    public List<DetalleAdopcionModel> obtenerTodos() {
        return detalleAdopcionService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<DetalleAdopcionModel> obtenerPorId(@PathVariable int id) {
        return detalleAdopcionService.obtenerPorId(id);
    }

    @PostMapping
    public DetalleAdopcionModel guardar(@RequestBody DetalleAdopcionModel detalleAdopcion) {
        return detalleAdopcionService.guardar(detalleAdopcion);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return detalleAdopcionService.eliminar(id) ? "Eliminado correctamente" : "No se encontró el ID";
    }
}
