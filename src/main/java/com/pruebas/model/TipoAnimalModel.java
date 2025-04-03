package com.pruebas.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "tipo_animal")
@Data
public class TipoAnimalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int idTipoAnimal;

    @Column(nullable = false, length = 155)
    private String nombre_tipo_animal;

    public int getIdTipoAnimal() {
        return idTipoAnimal;
    }

    public void setIdTipoAnimal(int idTipoAnimal) {
        this.idTipoAnimal = idTipoAnimal;
    }

    public String getNombre_tipo_animal() {
        return nombre_tipo_animal;
    }

    public void setNombre_tipo_animal(String nombre_tipo_animal) {
        this.nombre_tipo_animal = nombre_tipo_animal;
    }
}
