 /** 
 * @author Alejandro Perez CC 8.029.742
 * @author Julian David Giraldo Murillo CC 1.007.240.094
 * @author Andres Escobar Vasquez CC 1.038.096.962
 * @author Jorge Andres Restrepo Cataño CC 98.648.720
 **/
 
package com.pruebas.service;

import com.pruebas.model.TipoAnimalModel;
import com.pruebas.repository.TipoAnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoAnimalService {

    @Autowired
    private TipoAnimalRepository tipoAnimalRepository;

    public List<TipoAnimalModel> obtenerTodos() {
        return tipoAnimalRepository.findAll();
    }

    public Optional<TipoAnimalModel> obtenerPorId(int id) {
        return tipoAnimalRepository.findById(id);
    }

    public TipoAnimalModel guardar(TipoAnimalModel tipoAnimal) {
        return tipoAnimalRepository.save(tipoAnimal);
    }

    public boolean eliminar(int id) {
        if (tipoAnimalRepository.existsById(id)) {
            tipoAnimalRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
