package com.pruebas.repository;

import com.pruebas.model.Cuidador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuidadorRepository extends JpaRepository<Cuidador, Long> {
    // Métodos personalizados si es necesario
}