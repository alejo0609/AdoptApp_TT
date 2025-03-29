package com.pruebas.service;

import com.pruebas.model.UsuarioModel;
import com.pruebas.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioModel> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioModel> obtenerPorId(int id) {
        return usuarioRepository.findById(id);
    }

    public UsuarioModel guardar(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    public boolean eliminar(int id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}