package com.pruebas.repository;


import com.pruebas.model.RolesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RolesRepository extends JpaRepository<RolesModel, Integer> {

}