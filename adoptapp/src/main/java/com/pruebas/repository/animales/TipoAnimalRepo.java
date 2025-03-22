package com.pruebas.model;


import com.pruebas.model.TipoAnimalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TipoAnimalRepo extends JpaRepository<TipoAnimalModel, Integer> {

}