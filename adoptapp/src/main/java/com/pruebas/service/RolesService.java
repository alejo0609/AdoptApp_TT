 /** 
 * @author Alejandro Perez CC 8.029.742
 * @author Julian David Giraldo Murillo CC 1.007.240.094
 * @author Andres Escobar Vasquez CC 1.038.096.962
 * @author Jorge Andres Restrepo Cataño CC 98.648.720
 **/
 
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
