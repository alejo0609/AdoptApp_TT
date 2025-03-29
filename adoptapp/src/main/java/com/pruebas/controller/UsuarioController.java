package com.pruebas.controller;

import com.pruebas.model.UsuarioModel;
import com.pruebas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioModel> obtenerTodos() {
        return usuarioService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<UsuarioModel> obtenerPorId(@PathVariable int id) {
        return usuarioService.obtenerPorId(id);
    }

    @PostMapping
    public UsuarioModel guardar(@RequestBody UsuarioModel usuario) {
        return usuarioService.guardar(usuario);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return usuarioService.eliminar(id) ? "Eliminado correctamente" : "No se encontró el ID";
    }
}
