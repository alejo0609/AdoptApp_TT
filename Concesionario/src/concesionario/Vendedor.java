
package concesionario;

/**
 *
 * @author Alejandro
 */
public class Vendedor extends Persona{
    
   
    private static int contadorVendedores = 0; // Contador global de vendedores
    private String idVendedor;
    
    private String generarID() {
    contadorVendedores++; // Aumentar contador
    return String.format("v%02", contadorVendedores); // Formato v01, v02, v03...
    }

    // CONSTRUCTOR
    public Vendedor( String cedula, String nombre_completo, String direccion, String telefono) {
        super(cedula, nombre_completo, direccion, telefono);
        this.idVendedor = generarID();
    }

    // GETTERS Y SETTERS
    public String getCodigo_vendedor() {
        return idVendedor;
    }

    public void setCodigo_vendedor(String codigo_vendedor) {
        this.idVendedor = idVendedor;
    }

    @Override
    public String toString() {
        return "Hemos creado un Vendedor con código: " + idVendedor;
    }
    
    
    
    
    
    
}
