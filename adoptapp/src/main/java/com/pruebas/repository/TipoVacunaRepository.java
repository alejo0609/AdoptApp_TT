package com.pruebas.repository;


import com.pruebas.model.TipoVacunaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TipoVacunaRepository extends JpaRepository<TipoVacunaModel, Integer> {

}