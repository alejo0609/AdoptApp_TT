package com.pruebas.repository;


import com.pruebas.model.AdopcionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AdopcionRepository extends JpaRepository<AdopcionModel, Integer> {

}

