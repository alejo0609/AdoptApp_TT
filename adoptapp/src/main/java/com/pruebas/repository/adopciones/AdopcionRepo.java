package com.pruebas.model;


import com.pruebas.model.AdopcionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AdopcionRepo extends JpaRepository<AdopcionModel, Integer> {

}

