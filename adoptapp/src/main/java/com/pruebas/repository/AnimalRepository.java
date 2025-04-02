package com.pruebas.repository;

import com.pruebas.model.AnimalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface AnimalRepository extends JpaRepository<AnimalModel, Integer> {
    List<AnimalModel> findTop10ByOrderByIdAnimalDesc();
    

}