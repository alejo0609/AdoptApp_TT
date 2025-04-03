package com.pruebas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "datos_personales")
@Data
public class DatosPersonalesModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDatosPersonales;

    public void setIdDatosPersonales(Integer id) {
        this.idDatosPersonales = id;
    }

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, length = 55, unique = true)
    private String dni;

    @Column(nullable = false, length = 255)
    private String direccion;

    @Column(nullable = false, length = 55)
    private String ciudad;

    @Column(nullable = false, length = 15)
    private String telefono;


    @Column(nullable = false, length = 155, unique = true)
    private String email;


    @Column(nullable = false, length = 155)
    private String password;

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

    public int getIdDatosPersonales() {
        return idDatosPersonales;
    }

    public void setIdDatosPersonales(int idDatosPersonales) {
        this.idDatosPersonales = idDatosPersonales;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(nullable = false, length = 155)
    private String confirm_password;

}
