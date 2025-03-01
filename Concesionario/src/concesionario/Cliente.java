package concesionario;

public class Cliente extends Persona {
    private static int contadorClientes = 0; // Contador global de clientes
    private String idCliente;

    private String generarID() {
        contadorClientes++; // Aumentar contador
        return String.format("c%02", contadorClientes); // Formato c01, c02, c03...
    }

    public Cliente(String cedula, String nombre, String direccion, String telefono) {
        super(cedula, nombre, direccion, telefono);
        this.idCliente = generarID(); // Generar ID automáticamente
    }

    public String getIdCliente() {
        return idCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + idCliente + ", nombre=" + getNombre_completo() + ", cedula=" + getCedula() + "}";
    }
}
