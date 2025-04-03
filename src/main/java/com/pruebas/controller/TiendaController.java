package com.pruebas.controller;

import com.pruebas.model.TiendaModel;
import com.pruebas.service.TiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tiendas")
public class TiendaController {

    @Autowired
    private TiendaService tiendaService;

    @GetMapping
    public List<TiendaModel> obtenerTodas() {
        return tiendaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Optional<TiendaModel> obtenerPorId(@PathVariable Long id) {
        return tiendaService.obtenerPorId(id);
    }

    @PostMapping
    public TiendaModel guardar(@RequestBody TiendaModel tienda) {
        return tiendaService.guardar(tienda);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        return tiendaService.eliminar(id) ? "Eliminado correctamente" : "No se encontró la tienda con ese ID";
    }
}
