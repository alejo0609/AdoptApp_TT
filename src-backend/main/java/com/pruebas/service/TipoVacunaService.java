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