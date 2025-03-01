/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionario;
import java.util.ArrayList;

/**
 *
 * @author Alejandro
 * @see ver Inventario
 * @description 
 */

public class Inventario {
    private ArrayList<Vehiculo> vehiculos;
            
    // Constructor

    public Inventario(){
        this.vehiculos = new ArrayList<>();
    }
    
    // Metodo para agregar vehiculos
    public void agregarVehiculo(Vehiculo vehiculo){
    
        vehiculos.add(vehiculo);
    
    }
    
    // Metodo para eliminar del inventario
    public void eliminarVehiculo(Vehiculo vehiculo){
    
        vehiculos.remove(vehiculo);
    }
    
    // GETTERS

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    @Override
    public String toString() {
        return "Se ha agregado al inventario el {" + "vehiculo=" + vehiculos + '}';
    }
    
    
    
}
