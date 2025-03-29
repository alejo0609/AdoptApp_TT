package com.pruebas.service;

import com.pruebas.model.AdopcionModel;
import com.pruebas.repository.AdopcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;


@Service
public class AdopcionService {

    @Autowired
    private AdopcionRepository adopcionRepository;

    public List<AdopcionModel> findAll() {
        return adopcionRepository.findAll();
    }

    public Optional<AdopcionModel> findById(Integer id) {
        return adopcionRepository.findById(id);
    }

    public AdopcionModel save(AdopcionModel adopcion) {
        return adopcionRepository.save(adopcion);
    }

    public void deleteById(Integer id) {
        adopcionRepository.deleteById(id);
    }
}