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

    @ManyToOne
    //@OneToMany(targetEntity = tipo_animal_model.class, cascade = CascadeType.Persist )
    @JoinColumn(name = "idtipoanimal", nullable = false)
    private TipoAnimalModel tipo_animal;

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
}