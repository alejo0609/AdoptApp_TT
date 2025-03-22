package com.pruebas.model;


import com.pruebas.model.HistoriaAnimalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface HistoriaAnimalRepo extends JpaRepository<HistoriaAnimalModel, Integer> {

}