package com.pruebas.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "tipo_vacuna")
@Data
public class TipoVacunaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVacuna;

    @Column(nullable = false, length = 155)
    private String nombre_tipo_vacuna;

    public int getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(int idVacuna) {
        this.idVacuna = idVacuna;
    }

    public String getNombre_tipo_vacuna() {
        return nombre_tipo_vacuna;
    }

    public void setNombre_tipo_vacuna(String nombre_tipo_vacuna) {
        this.nombre_tipo_vacuna = nombre_tipo_vacuna;
    }
}