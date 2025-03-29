package com.pruebas.repository;


import com.pruebas.model.DetalleAdopcionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface DetalleAdopcionRepository extends JpaRepository<DetalleAdopcionModel, Integer> {

}