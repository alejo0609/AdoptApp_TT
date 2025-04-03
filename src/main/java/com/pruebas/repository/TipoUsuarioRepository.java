package com.pruebas.repository;


import com.pruebas.model.TipoUsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuarioModel, Integer> {

}