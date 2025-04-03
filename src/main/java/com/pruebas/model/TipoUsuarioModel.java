package com.pruebas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tipo_usuario")
@Data
public class TipoUsuarioModel {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idTipoUsuario;

public void setIdTipoUsuario(Integer id) {
    this.idTipoUsuario = id;
}

@Column(nullable = false, length = 100)
private String nombre_tipo_usuario;

@Column(nullable = false)
private Boolean estado_tipo_usuario;

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getNombre_tipo_usuario() {
        return nombre_tipo_usuario;
    }

    public void setNombre_tipo_usuario(String nombre_tipo_usuario) {
        this.nombre_tipo_usuario = nombre_tipo_usuario;
    }

    public Boolean getEstado_tipo_usuario() {
        return estado_tipo_usuario;
    }

    public void setEstado_tipo_usuario(Boolean estado_tipo_usuario) {
        this.estado_tipo_usuario = estado_tipo_usuario;
    }
}