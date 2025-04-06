 /** 
 * @author Alejandro Perez CC 8.029.742
 * @author Julian David Giraldo Murillo CC 1.007.240.094
 * @author Andres Escobar Vasquez CC 1.038.096.962
 * @author Jorge Andres Restrepo Cataño CC 98.648.720
 **/
 
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