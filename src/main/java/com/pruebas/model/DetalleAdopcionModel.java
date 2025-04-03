package com.pruebas.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "detalle_adopcion")
@Data
public class DetalleAdopcionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddetalleadopcion") 
    private int idDetalleAdopcion;

    public int getIdDetalleAdopcion() {
        return idDetalleAdopcion;
    }

    public void setIdDetalleAdopcion(int idDetalleAdopcion) {
        this.idDetalleAdopcion = idDetalleAdopcion;
    }
}