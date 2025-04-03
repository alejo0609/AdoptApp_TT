package com.pruebas.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "historia_animal")
@Data
public class HistoriaAnimalModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHistoriAanimal;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String estado_salud; 

    @Column(nullable = false)
    private Boolean chip;

    @Column(nullable = false)
    private LocalDateTime fecha_creado; 

    @Column(nullable = false)
    private LocalDateTime fecha_modificado;

    public int getIdHistoriAanimal() {
        return idHistoriAanimal;
    }

    public void setIdHistoriAanimal(int idHistoriAanimal) {
        this.idHistoriAanimal = idHistoriAanimal;
    }

    public String getEstado_salud() {
        return estado_salud;
    }

    public void setEstado_salud(String estado_salud) {
        this.estado_salud = estado_salud;
    }

    public Boolean getChip() {
        return chip;
    }

    public void setChip(Boolean chip) {
        this.chip = chip;
    }

    public LocalDateTime getFecha_creado() {
        return fecha_creado;
    }

    public void setFecha_creado(LocalDateTime fecha_creado) {
        this.fecha_creado = fecha_creado;
    }

    public LocalDateTime getFecha_modificado() {
        return fecha_modificado;
    }

    public void setFecha_modificado(LocalDateTime fecha_modificado) {
        this.fecha_modificado = fecha_modificado;
    }
}