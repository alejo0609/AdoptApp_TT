package concesionario;
import java.util.ArrayList;
import java.util.Scanner;

public class Concesionario {
    private ArrayList<Cliente> clientes;
    private ArrayList<Vendedor> vendedores;
    private ArrayList<Venta> ventas;
    private Inventario inventario;

    // CONSTRUCTOR
    public Concesionario() {
        this.clientes = new ArrayList<>();
        this.vendedores = new ArrayList<>();
        this.ventas = new ArrayList<>();
        this.inventario = new Inventario();
    }

    // M�TODO PARA AGREGAR CLIENTES
    public void agregarCliente(String cedula, String nombre_completo, String direccion, String telefono) {
        Cliente nuevoCliente = new Cliente(cedula, nombre_completo, direccion, telefono);
        clientes.add(nuevoCliente);
        System.out.println("Cliente agregado con �xito. ID: " + nuevoCliente.getIdCliente()+ " - "+ nuevoCliente.getNombre_completo());
    }
    //LISTADO DE CLIENTES
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    // M�TODO PARA AGREGAR VENDEDORES
   
    public void agregarVendedor(String cedula, String nombre_completo, String direccion, String telefono) {
        Vendedor nuevoVendedor = new Vendedor(cedula, nombre_completo, direccion, telefono);
        vendedores.add(nuevoVendedor);
    }   

    public ArrayList<Vendedor> getVendedores() {
        return vendedores;
    }

    // M�TODO PARA AGREGAR VEH�CULO
    public void agregarVehiculo(String marca, int a�o, String modelo, double precio) {
        Vehiculo vehiculo = new Vehiculo(marca, a�o, modelo, precio);
        inventario.agregarVehiculo(vehiculo);
    }

    public ArrayList<Vehiculo> getInventario() {
        return inventario.getVehiculos();
    }

    // M�TODO PARA REGISTRAR UNA VENTA
    public void registrarVenta(Vendedor vendedor, Cliente cliente, Vehiculo vehiculo, String fecha_venta) {
        Venta venta = new Venta(vendedor, cliente, vehiculo, fecha_venta);
        ventas.add(venta);
    }
        
    // VOIS MAIN
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //INSTANCIO LAS CLASES
        Concesionario concesionario = new Concesionario();
        int opcion;

        do {
            System.out.println("\n--- Men� Concesionario ---");
            System.out.println("1. Crear Cliente");
            System.out.println("2. Crear Vendedor");
            System.out.println("3. Registrar Veh�culo");
            System.out.println("4. Crear Venta");
            System.out.println("5. Ver Inventario");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opci�n: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    // Crear Cliente
                    System.out.print("Ingrese la c�dula del cliente: ");
                    String cedula = scanner.nextLine();
                    System.out.print("Ingrese el nombre completo del cliente: ");
                    String nombre_completo = scanner.nextLine();
                    System.out.print("Ingrese la direcci�n del cliente: ");
                    String direccion = scanner.nextLine();
                    System.out.print("Ingrese el tel�fono del cliente: ");
                    String telefono = scanner.nextLine();
                    concesionario.agregarCliente(cedula, nombre_completo, direccion, telefono);
                    break;

                case 2:
                    // Crear Vendedor
                    System.out.print("Ingrese la c�dula del vendedor: ");
                    String cedulaV = scanner.nextLine();
                    System.out.print("Ingrese el nombre completo del vendedor: ");
                    String nombre_completoV = scanner.nextLine();
                    System.out.print("Ingrese la direcci�n del vendedor: ");
                    String direccionV = scanner.nextLine();
                    System.out.print("Ingrese el tel�fono del vendedor: ");
                    String telefonoV = scanner.nextLine();
                    concesionario.agregarVendedor(cedulaV, nombre_completoV, direccionV, telefonoV);
                    break;

                case 3:
                    // Registrar Veh�culo
                    System.out.print("Ingrese la marca del veh�culo: ");
                    String marca = scanner.nextLine();
                    System.out.print("Ingrese el a�o del veh�culo: ");
                    int a�o = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    System.out.print("Ingrese el modelo del veh�culo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Ingrese el precio del veh�culo: ");
                    double precio = scanner.nextDouble();
                    concesionario.agregarVehiculo(marca, a�o, modelo, precio);
                    break;

                case 4:
                    // Crear Venta
                    if (concesionario.getClientes().isEmpty() || concesionario.getVendedores().isEmpty() || concesionario.getInventario().isEmpty()) {
                        System.out.println("No hay suficientes datos para registrar una venta.");
                        break;
                    }

                    System.out.println("Seleccione un vendedor:");
                    for (int i = 0; i < concesionario.getVendedores().size(); i++) {
                        System.out.println(i + 1 + ". " + concesionario.getVendedores().get(i).getNombre_completo());
                    }
                    int vendedorIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    System.out.println("Seleccione un cliente:");
                    for (int i = 0; i < concesionario.getClientes().size(); i++) {
                        System.out.println(i + 1 + ". " + concesionario.getClientes().get(i).getNombre_completo());
                    }
                    int clienteIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    System.out.println("Seleccione un veh�culo:");
                    for (int i = 0; i < concesionario.getInventario().size(); i++) {
                        System.out.println(i + 1 + ". " + concesionario.getInventario().get(i).getMarca() + " " +
                                concesionario.getInventario().get(i).getModelo());
                    }
                    int vehiculoIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    System.out.print("Ingrese la fecha de la venta (YYYY-MM-DD): ");
                    String fechaVenta = scanner.nextLine();

                    concesionario.registrarVenta(
                            concesionario.getVendedores().get(vendedorIndex),
                            concesionario.getClientes().get(clienteIndex),
                            concesionario.getInventario().get(vehiculoIndex),
                            fechaVenta
                    );
                    break;

                case 5:
                    // Ver Inventario
                    System.out.println("\n--- Inventario ---");
                    if (concesionario.getInventario().isEmpty()) {
                        System.out.println("No hay veh�culos en el inventario.");
                    } else {
                        for (Vehiculo vehiculo : concesionario.getInventario()) {
                            System.out.println(vehiculo.getMarca() + " " + vehiculo.getModelo() + " - $" + vehiculo.getPrecio());
                        }
                    }
                    break;

                case 0:
                    // Salir
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opci�n no v�lida, intente nuevamente.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    @Override
    public String toString() {
        return "Concesionario{" +
                "clientes=" + clientes +
                ", vendedores=" + vendedores +
                ", ventas=" + ventas +
                ", inventario=" + inventario +
                '}';
    }
}