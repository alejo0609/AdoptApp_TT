 /** 
 * @author Alejandro Perez CC 8.029.742
 * @author Julian David Giraldo Murillo CC 1.007.240.094
 * @author Andres Escobar Vasquez CC 1.038.096.962
 * @author Jorge Andres Restrepo Cataño CC 98.648.720
 **/
 
package com.pruebas.service;

import com.pruebas.model.HistoriaAnimalModel;              // Esto cambia en cada Service por el nombre de la clase
import com.pruebas.repository.HistoriaAnimalRepository;      // Esto cambia en cada Service por el nombre de la clase

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HistoriaAnimalService {

    @Autowired
    private HistoriaAnimalRepository historiaAnimalRepository;

    public List<HistoriaAnimalModel> obtenerTodos() {
        return historiaAnimalRepository.findAll();
    }

    public Optional<HistoriaAnimalModel> obtenerPorId(int id) {
        return historiaAnimalRepository.findById(id);
    }

    public HistoriaAnimalModel guardar(HistoriaAnimalModel historiaAnimal) {
        return historiaAnimalRepository.save(historiaAnimal);
    }

    public boolean eliminar(int id) {
        if (historiaAnimalRepository.existsById(id)) {
            historiaAnimalRepository.deleteById(id);
            return true;
        }
        return false;
    }
}