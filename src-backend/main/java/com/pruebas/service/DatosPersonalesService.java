package com.pruebas.service;

import com.pruebas.model.DatosPersonalesModel;
import com.pruebas.repository.DatosPersonalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DatosPersonalesService {

    @Autowired
    private DatosPersonalesRepository datosPersonalesRepository;

    public List<DatosPersonalesModel> obtenerTodos() {
        return datosPersonalesRepository.findAll();
    }

    public Optional<DatosPersonalesModel> obtenerPorDni(long dni) {
        return datosPersonalesRepository.findByDni(dni);
    }

    public DatosPersonalesModel guardar(DatosPersonalesModel datosPersonales) {
        return datosPersonalesRepository.save(datosPersonales);
    }

    public boolean eliminarPorDni(Long dni) {
        Optional<DatosPersonalesModel> registro = datosPersonalesRepository.findByDni(dni);
        if (registro.isPresent()) {
            datosPersonalesRepository.delete(registro.get());
            return true;
        }
        return false;
    }
    
    
   
   
}