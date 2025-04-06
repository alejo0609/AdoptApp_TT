 /** 
 * @author Alejandro Perez CC 8.029.742
 * @author Julian David Giraldo Murillo CC 1.007.240.094
 * @author Andres Escobar Vasquez CC 1.038.096.962
 * @author Jorge Andres Restrepo Cataño CC 98.648.720
 **/
 
package com.pruebas.service;

import com.pruebas.model.TipoVacunaModel;
import com.pruebas.repository.TipoVacunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoVacunaService {

    @Autowired
    private TipoVacunaRepository tipoVacunaRepository;

    public List<TipoVacunaModel> obtenerTodos() {
        return tipoVacunaRepository.findAll();
    }

    public Optional<TipoVacunaModel> obtenerPorId(int id) {
        return tipoVacunaRepository.findById(id);
    }

    public TipoVacunaModel guardar(TipoVacunaModel tipoVacuna) {
        return tipoVacunaRepository.save(tipoVacuna);
    }

    public boolean eliminar(int id) {
        if (tipoVacunaRepository.existsById(id)) {
            tipoVacunaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}