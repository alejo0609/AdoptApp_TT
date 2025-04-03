package com.pruebas.controller;

import com.pruebas.model.UsuarioModel;
import com.pruebas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:5173")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public Optional<UsuarioModel> login(@RequestBody UsuarioModel usuario) {
        return usuarioService.login(usuario.getEmail(), usuario.getPassword());
    }

    @PostMapping
    public UsuarioModel registrar(@RequestBody UsuarioModel usuario) {
        return usuarioService.save(usuario);
    }
}
