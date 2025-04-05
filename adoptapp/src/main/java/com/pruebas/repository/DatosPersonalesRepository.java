package com.pruebas.repository;


import com.pruebas.model.DatosPersonalesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DatosPersonalesRepository extends JpaRepository<DatosPersonalesModel, Integer> {
     Optional<DatosPersonalesModel> findByEmail(String email);
     Optional<DatosPersonalesModel> findByDni(Long dni);
}