package com.pruebas.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "adopcion")
@Data
public class AdopcionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idadopcion;

    @Column(nullable = false)
    private LocalDateTime fecha; 

    @Column(nullable = false)
    private Boolean estado_adopcion;
}