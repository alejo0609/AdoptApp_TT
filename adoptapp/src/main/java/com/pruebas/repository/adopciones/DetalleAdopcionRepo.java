package com.pruebas.model;


import com.pruebas.model.DetalleAdopcionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface DetalleAdopcionRepo extends JpaRepository<DetalleAdopcionModel, Integer> {

}