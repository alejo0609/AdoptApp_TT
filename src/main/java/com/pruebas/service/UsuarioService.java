package com.pruebas.service;

import com.pruebas.model.UsuarioModel;
import com.pruebas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<UsuarioModel> login(String email, String password) {
        return usuarioRepository.findByEmailAndPassword(email, password);
    }

    public UsuarioModel save(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }
}
