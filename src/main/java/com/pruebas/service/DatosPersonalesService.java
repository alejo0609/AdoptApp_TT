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

    public Optional<DatosPersonalesModel> obtenerPorId(int id) {
        return datosPersonalesRepository.findById(id);
    }

    public DatosPersonalesModel guardar(DatosPersonalesModel datosPersonales) {
        return datosPersonalesRepository.save(datosPersonales);
    }

    public boolean eliminar(int id) {
        if (datosPersonalesRepository.existsById(id)) {
            datosPersonalesRepository.deleteById(id);
            return true;
        }
        return false;
    }
}