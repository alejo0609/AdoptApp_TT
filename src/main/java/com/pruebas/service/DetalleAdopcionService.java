package com.pruebas.service;

import com.pruebas.model.DetalleAdopcionModel;              // Esto cambia en cada Service por el nombre de la clase
import com.pruebas.repository.DetalleAdopcionRepository;      // Esto cambia en cada Service por el nombre de la clase

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DetalleAdopcionService {

    @Autowired
    private DetalleAdopcionRepository detalleAdopcionRepository;

    public List<DetalleAdopcionModel> obtenerTodos() {
        return detalleAdopcionRepository.findAll();
    }

    public Optional<DetalleAdopcionModel> obtenerPorId(int id) {
        return detalleAdopcionRepository.findById(id);
    }

    public DetalleAdopcionModel guardar(DetalleAdopcionModel detalleAdopcion) {
        return detalleAdopcionRepository.save(detalleAdopcion);
    }

    public boolean eliminar(int id) {
        if (detalleAdopcionRepository.existsById(id)) {
            detalleAdopcionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}