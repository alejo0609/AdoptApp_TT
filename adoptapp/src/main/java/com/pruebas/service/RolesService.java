package com.pruebas.service;

import com.pruebas.model.RolesModel;
import com.pruebas.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesService {

    @Autowired
    private RolesRepository rolesRepository;

    public List<RolesModel> obtenerTodos() {
        return rolesRepository.findAll();
    }

    public Optional<RolesModel> obtenerPorId(int id) {
        return rolesRepository.findById(id);
    }

    public RolesModel guardar(RolesModel roles) {
        return rolesRepository.save(roles);
    }

    public boolean eliminar(int id) {
        if (rolesRepository.existsById(id)) {
            rolesRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
