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
public class Vehiculo {
    private String marca;
    private int modelo;
    private String referencia;
    private double precio;

    public Vehiculo(String marca, int modelo, String referencia, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.referencia = referencia;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Vehiculo de {" + "marca=" + marca + ", modelo=" + modelo + ", referencia=" + referencia + ", precio=" + precio + '}';
    }
    
    
}
