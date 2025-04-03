package com.pruebas.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(nullable = false, length = 155, unique = true)
    private String email;

    @Column(nullable = false, length = 155)
    private String password;

    @Column(nullable = false)
    private Boolean estadoUsuario;
}