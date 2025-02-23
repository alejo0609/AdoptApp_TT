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
public class Venta {
    
    private Vendedor vendedor;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private String fecha_venta;

    public Venta(Vendedor vendedor, Cliente cliente, Vehiculo vehiculo, String fecha_venta) {
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fecha_venta = fecha_venta;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    @Override
    public String toString() {
        return "Venta realizada por el{" + "vendedor=" + vendedor + ", al cliente=" + cliente + ", vehiculo=" + vehiculo + ", fecha_venta=" + fecha_venta + '}';
    }
    
    
    
}
