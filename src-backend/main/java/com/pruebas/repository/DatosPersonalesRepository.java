package com.pruebas.repository;


import com.pruebas.model.DatosPersonalesModel;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface DatosPersonalesRepository extends JpaRepository<DatosPersonalesModel, Integer> {
    Optional<DatosPersonalesModel> findByDni(Long dni);



}