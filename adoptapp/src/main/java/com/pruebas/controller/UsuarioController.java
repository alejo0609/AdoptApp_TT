package com.pruebas.controller;

import com.pruebas.model.UsuarioModel;
import com.pruebas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuario")
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
    @PostMapping("/login")
    public Optional<UsuarioModel> autenticar(@RequestBody UsuarioModel usuario) {
        return usuarioService.autenticarUsuario(usuario.getEmail(), usuario.getPassword());
    }
    @PostMapping("/autenticar")
    public ResponseEntity<?> login(@RequestBody UsuarioModel usuario) {
        Optional<UsuarioModel> usuarioEncontrado = usuarioService.obtenerPorEmailYPassword(usuario.getEmail(), usuario.getPassword());

        if (usuarioEncontrado.isPresent()) {
            return ResponseEntity.ok("{\"mensaje\": \"Inicio de sesión exitoso\"}");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"mensaje\": \"Credenciales incorrectas\"}");
        }
    }



    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return usuarioService.eliminar(id) ? "Eliminado correctamente" : "No se encontró el ID";
    }
}