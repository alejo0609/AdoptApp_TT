package com.pruebas.service;

import com.pruebas.model.TipoUsuarioModel;
import com.pruebas.repository.TipoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoUsuarioService {

    @Autowired
    private TipoUsuarioRepository tipo_usuarioRepository;

    public List<TipoUsuarioModel> obtenerTodos() {
        return tipo_usuarioRepository.findAll();
    }

    public Optional<TipoUsuarioModel> obtenerPorId(int id) {
        return tipo_usuarioRepository.findById(id);
    }

    public TipoUsuarioModel guardar(TipoUsuarioModel tipo_usuario) {
        return tipo_usuarioRepository.save(tipo_usuario);
    }

    public boolean eliminar(int id) {
        if (tipo_usuarioRepository.existsById(id)) {
            tipo_usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}