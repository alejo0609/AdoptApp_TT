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
public class Cliente extends Persona {
    // CODIGO NUEVO PARA EL ID
    private static int contadorClientes = 0; // Contador global de clientes 
    private String idCliente; 
    
    private String generarID() {
    contadorClientes++; // Aumentar contador
    return String.format("c%02d", contadorClientes); // Formato c01, c02, c03...
    }

    public String getIdCliente() {
        return idCliente;
    }
    
    
    
    //CODIGO DEL PROFE
    //private String codigo_cliente;

        public Cliente(String cedula, String nombre, String direccion, String telefono) {
        super(cedula, nombre, direccion, telefono);
        this.idCliente = generarID(); // Generar ID automáticamente
    }
/*    
    public Cliente(String codigo_cliente, String cedula, String nombre_completo, String direccion, String telefono) {
        super(cedula, nombre_completo, direccion, telefono);
        //this.codigo_cliente = codigo_cliente;
    }

    public String getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(String codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }
*/

 

   @Override
    public String toString() {
        return "Cliente{" + "id=" + idCliente + ", nombre=" + getNombre_completo() + ", cedula=" + getCedula() + "}";
    }





    
    
}
