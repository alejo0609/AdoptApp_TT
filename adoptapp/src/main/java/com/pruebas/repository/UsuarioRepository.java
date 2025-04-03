package com.pruebas.repository;


import com.pruebas.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
    //Optional<UsuarioModel> findByEmailAndPassword(String email, String password);
    Optional<UsuarioModel> findByEmail(String email);
}