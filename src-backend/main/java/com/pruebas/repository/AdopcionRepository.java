package com.pruebas.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebas.model.AdopcionModel;



@Repository
public interface AdopcionRepository extends JpaRepository<AdopcionModel, Integer> {

}

