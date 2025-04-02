package com.pruebas.repository;


import com.pruebas.model.TipoAnimalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TipoAnimalRepository extends JpaRepository<TipoAnimalModel, Integer> {

}