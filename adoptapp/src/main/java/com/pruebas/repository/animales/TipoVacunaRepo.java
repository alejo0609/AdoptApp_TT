package com.pruebas.model;


import com.pruebas.model.TipoVacunaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TipoVacunaRepo extends JpaRepository<TipoVacunaModel, Integer> {

}