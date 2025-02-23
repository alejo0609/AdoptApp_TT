/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionario;

/**
 *
 * @author Alejandro
 */
public class Persona {
    private String cedula;
    private String nombre_completo;
    private String direccion;
    private String telefono;

    //CONSTRUCTOR
    public Persona(String cedula, String nombre_completo, String direccion, String telefono) {
        this.cedula = cedula;
        this.nombre_completo = nombre_completo;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // GETTERS AND SETTERS
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" + "cedula=" + cedula + ", nombre_completo=" + nombre_completo + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }
    
    
}
