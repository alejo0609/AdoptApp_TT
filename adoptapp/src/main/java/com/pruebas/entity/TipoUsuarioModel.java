 /** 
 * @author Alejandro Perez CC 8.029.742
 * @author Julian David Giraldo Murillo CC 1.007.240.094
 * @author Andres Escobar Vasquez CC 1.038.096.962
 * @author Jorge Andres Restrepo Cataño CC 98.648.720
 **/
 
package com.pruebas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tipo_usuario")
@Data
public class TipoUsuarioModel {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idTipoUsuario;

public void setIdTipoUsuario(Integer id) {
    this.idTipoUsuario = id;
}

@Column(nullable = false, length = 100)
private String nombre_tipo_usuario;

@Column(nullable = false)
private Boolean estado_tipo_usuario;


}