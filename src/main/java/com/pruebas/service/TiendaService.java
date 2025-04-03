package com.pruebas.service;

import com.pruebas.model.TiendaModel;
import com.pruebas.repository.TiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TiendaService {

    @Autowired
    private TiendaRepository tiendaRepository;

    public List<TiendaModel> obtenerTodas() {
        return tiendaRepository.findAll();
    }

    public Optional<TiendaModel> obtenerPorId(Long id) {
        return tiendaRepository.findById(id);
    }

    public TiendaModel guardar(TiendaModel tienda) {
        return tiendaRepository.save(tienda);
    }

    public boolean eliminar(Long id) {
        if (tiendaRepository.existsById(id)) {
            tiendaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
