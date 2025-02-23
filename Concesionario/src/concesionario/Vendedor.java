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
public class Vendedor extends Persona{
    
    private String codigo_vendedor;

    // CONSTRUCTOR
    public Vendedor(String codigo_vendedor, String cedula, String nombre_completo, String direccion, String telefono) {
        super(cedula, nombre_completo, direccion, telefono);
        this.codigo_vendedor = codigo_vendedor;
    }

    // GETTERS AND SETTERS
    public String getCodigo_vendedor() {
        return codigo_vendedor;
    }

    public void setCodigo_vendedor(String codigo_vendedor) {
        this.codigo_vendedor = codigo_vendedor;
    }

    @Override
    public String toString() {
        return "Hemos creado un Vendedor con codigo_vendedor=" + codigo_vendedor;
    }
    
    
    
    
    
    
}
