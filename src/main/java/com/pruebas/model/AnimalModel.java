package com.pruebas.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "animal")
@Data
public class AnimalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAnimal;
    public void setIdAnimal(Integer id) {
        this.idAnimal = id;
    }

    @Column(nullable = false, length = 155)
    private String nombre_animal;

    @Column(nullable = false, length = 45)
    private String raza;

    @Column(nullable = false, length = 4)
    private String edad;

    @Column(nullable = false)
    private Boolean esterilizado;

    @Column(nullable = false)
    private Boolean estado_animal;

    @Column(nullable = false, length = 255)
    private String imagen_animal;

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNombre_animal() {
        return nombre_animal;
    }

    public void setNombre_animal(String nombre_animal) {
        this.nombre_animal = nombre_animal;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public Boolean getEsterilizado() {
        return esterilizado;
    }

    public void setEsterilizado(Boolean esterilizado) {
        this.esterilizado = esterilizado;
    }

    public String getImagen_animal() {
        return imagen_animal;
    }

    public void setImagen_animal(String imagen_animal) {
        this.imagen_animal = imagen_animal;
    }

    public Boolean getEstado_animal() {
        return estado_animal;
    }

    public void setEstado_animal(Boolean estado_animal) {
        this.estado_animal = estado_animal;
    }
}