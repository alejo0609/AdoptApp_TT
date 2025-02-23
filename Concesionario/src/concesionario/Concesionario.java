/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionario;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Alejandro
 */
public class Concesionario {
    
    

    /**
     * @param args the command line arguments
     */
    
    private ArrayList<Cliente> clientes;
    private ArrayList<Vendedor>vendedores;
    private ArrayList<Venta> ventas;
    private Inventario inventario;
    
    
    //CONSTRUCTOR
    public Concesionario(){
    
        this.clientes = new ArrayList<>();    
        this.vendedores = new ArrayList<>();   
        this.ventas = new ArrayList<>();   
        this.inventario = new Inventario();   
    }

    //METODO PARA AGREGAR CLIENTES:
/*
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }
*/
    public void agregarCliente(String cedula, String nombre_completo, String direccion, String telefono) {
            Cliente nuevoCliente = new Cliente(cedula, nombre_completo, direccion, telefono);
            clientes.add(nuevoCliente);
        }
    public ArrayList <Cliente> getClientes(){
    
        return clientes;
    }
    
    // METODO PARA AGREGAR VENDEDORES
    public void agregarVendedor(Vendedor vendedor){
            vendedores.add(vendedor);
    }
    
    public ArrayList<Vendedor> getVendedores(){
    
    return vendedores;
    }
    
    //METODO PARA AGREGAR VEHICULO
    public void agregarVehiculo(Vehiculo vehiculo){
    
        inventario.agregarVehiculo(vehiculo);
    }
    
    // METODO PARA ELIMINAR VEHICULO
    public void eliminarVehiculo(Vehiculo vehiculo){
    
        inventario.eliminarVehiculo(vehiculo);
    }
       
    // METODO PARA VER EL INVENTARIO
    public ArrayList<Vehiculo> getInventario(){
    
        return inventario.getVehiculos();
    }
    
    //GESTION DE VENTAS    
    public void registrarVenta(Vendedor vendedor, Cliente cliente, Vehiculo vehiculo, String fecha_venta){
        Venta venta = new Venta(vendedor,cliente,vehiculo,fecha_venta);
        ventas.add(venta);
        
    }
    
    
    
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        //INSTANCIAR LAS CLASES
        Concesionario concesionario = new Concesionario();
        
        
        //CREAR OBJETOS, CLIENTE, VENDEDOR, VEHICULO:
        
        //CREAR CLIENTE POR CONSOLA
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("CEDULA: \n");
        String cedula = scanner.nextLine();
        System.out.println("NOMBRE: \n");
        String name = scanner.nextLine();
        System.out.println("DIRECCION: \n");
        String direccion = scanner.nextLine();
        System.out.println("TELEFONO: \n");
        String telefono = scanner.nextLine();
        */
        
        
        
        // CREAR CLIENTE POR DEFECTO
        //Cliente cliente1 = new Cliente("c001",cedula,name,direccion,telefono);
        //Cliente cliente1 = new Cliente("8029","Alejo","CALLE 54","321309");
        concesionario.agregarCliente("8029742", "Alejandro perez", "CALLE 54", "3148351405");
        
        
        //AGREGAR VENTA
        String fecha_venta = "2025-02-23";
        //concesionario.registrarVenta(vendedor1,cliente1,vehiculo1,fecha_venta);
        
        
        //IMPRIMIR EL OBJETO CONCESIONARIO         
        System.out.println("Cliente registrado satisfactoriamente: " + concesionario.getClientes().get(0).getNombre_completo());
        
    
    }

    @Override
    public String toString() {
        return "Concesionario{" + "clientes=" + clientes + ", vendedores=" + vendedores + ", ventas=" + ventas + ", inventario=" + inventario + '}';
    }
    
    
 
}
