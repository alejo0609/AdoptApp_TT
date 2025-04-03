package com.pruebas.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "tipo_documentos")
@Data
public class TipoDocumentosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int idTipoDocumentos;

    @Column(nullable = false, length = 45)
    private String nombre_tipo_documento;

    public int getIdTipoDocumentos() {
        return idTipoDocumentos;
    }

    public void setIdTipoDocumentos(int idTipoDocumentos) {
        this.idTipoDocumentos = idTipoDocumentos;
    }

    public String getNombre_tipo_documento() {
        return nombre_tipo_documento;
    }

    public void setNombre_tipo_documento(String nombre_tipo_documento) {
        this.nombre_tipo_documento = nombre_tipo_documento;
    }
}
    