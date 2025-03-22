package com.pruebas.model;


import com.pruebas.model.AnimalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AnimalRepo extends JpaRepository<AnimalModel, Integer> {

}