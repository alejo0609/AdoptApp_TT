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
    private TipoUsuarioRepository tipoUsuarioRepository;

    public List<TipoUsuarioModel> obtenerTodos() {
        return tipoUsuarioRepository.findAll();
    }

    public Optional<TipoUsuarioModel> obtenerPorId(int id) {
        return tipoUsuarioRepository.findById(id);
    }

    public TipoUsuarioModel guardar(TipoUsuarioModel tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    public boolean eliminar(int id) {
        if (tipoUsuarioRepository.existsById(id)) {
            tipoUsuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}