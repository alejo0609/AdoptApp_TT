package com.pruebas.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "roles")
@Data
public class RolesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idroles;

    @Column(nullable = false)
    private LocalDateTime creado; 

    @Column(nullable = false)
    private LocalDateTime modificado; 

}