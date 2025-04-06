 /** 
 * @author Alejandro Perez CC 8.029.742
 * @author Julian David Giraldo Murillo CC 1.007.240.094
 * @author Andres Escobar Vasquez CC 1.038.096.962
 * @author Jorge Andres Restrepo Cataño CC 98.648.720
 **/
 
package com.pruebas.service;

import com.pruebas.model.TipoDocumentosModel;
import com.pruebas.repository.TipoDocumentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDocumentosService {

    @Autowired
    private TipoDocumentosRepository tipoDocumentosRepository;

    public List<TipoDocumentosModel> obtenerTodos() {
        return tipoDocumentosRepository.findAll();
    }

    public Optional<TipoDocumentosModel> obtenerPorId(int id) {
        return tipoDocumentosRepository.findById(id);
    }

    public TipoDocumentosModel guardar(TipoDocumentosModel tipoDocumentos) {
        return tipoDocumentosRepository.save(tipoDocumentos);
    }

    public boolean eliminar(int id) {
        if (tipoDocumentosRepository.existsById(id)) {
            tipoDocumentosRepository.deleteById(id);
            return true;
        }
        return false;
    }
}