package com.pruebas.repository;


import com.pruebas.model.TipoDocumentosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TipoDocumentosRepository extends JpaRepository<TipoDocumentosModel, Integer> {

}