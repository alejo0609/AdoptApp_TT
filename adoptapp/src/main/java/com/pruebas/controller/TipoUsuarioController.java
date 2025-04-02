package com.pruebas.controller;

import com.pruebas.model.TipoUsuarioModel;
import com.pruebas.service.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tipo_Usuarios")
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    @GetMapping
    public List<TipoUsuarioModel> obtenerTodos() {
        return tipoUsuarioService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<TipoUsuarioModel> obtenerPorId(@PathVariable int id) {
        return tipoUsuarioService.obtenerPorId(id);
    }

    @PostMapping
    public TipoUsuarioModel guardar(@RequestBody TipoUsuarioModel tipoUsuario) {
        return tipoUsuarioService.guardar(tipoUsuario);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return tipoUsuarioService.eliminar(id) ? "Eliminado correctamente" : "No se encontró el ID";
    }
}
