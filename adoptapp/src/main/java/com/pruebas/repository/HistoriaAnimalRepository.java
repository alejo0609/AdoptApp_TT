package com.pruebas.repository;


import com.pruebas.model.HistoriaAnimalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface HistoriaAnimalRepository extends JpaRepository<HistoriaAnimalModel, Integer> {

}