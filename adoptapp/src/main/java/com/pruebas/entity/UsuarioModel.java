package com.pruebas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usuario")
@Data
public class UsuarioModel {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idUsuario;

public void setIdUsuario(Integer id) {
    this.idUsuario = id;
}

@Column(nullable = false, length = 155, unique = true)
private String email;

@Column(nullable = false, length = 155)
private String pass_usuario;

@Column(nullable = false)
private Boolean estado_usuario;


}