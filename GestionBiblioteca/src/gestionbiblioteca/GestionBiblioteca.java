

/**
 * Clase principal de la gestión de la biblioteca.
 */
package gestionbiblioteca;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Clase que maneja las operaciones del sistema de biblioteca.
 */
public class GestionBiblioteca {
    
    /**
     * Constructor que inicializa la biblioteca.
     */
    private static Biblioteca biblioteca = new Biblioteca();

    
    
    /**
     * Método principal para ejecutar el menú de opciones.
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        do {
            try {
                System.out.println("\nMenú de Biblioteca");
                System.out.println("1. Agregar libro");
                System.out.println("2. Eliminar libro");
                System.out.println("3. Ver todos los libros");
                System.out.println("4. Buscar libro");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        try {
                            System.out.print("Ingrese título: ");
                            String titulo = scanner.nextLine();
                            System.out.print("Ingrese autor: ");
                            String autor = scanner.nextLine();
                            System.out.print("Ingrese ISBN (10 ó 13 dígitos): ");
                            String isbn = scanner.nextLine();
                            biblioteca.agregarLibro(new Libro(titulo, autor, isbn));
                        } catch (Exception e) {
                            System.out.println("Error al agregar libro: " + e.getMessage());
                        }
                        break;

                    case 2:
                        try {
                            System.out.print("Ingrese ISBN del libro a eliminar: ");
                            String isbnEliminar = scanner.nextLine();
                            biblioteca.eliminarLibro(isbnEliminar);
                        } catch (Exception e) {
                            System.out.println("Error al eliminar libro: " + e.getMessage());
                        }
                        break;

                    case 3:
                        try {
                            biblioteca.verTodosLosLibros();
                        } catch (Exception e) {
                            System.out.println("Error al mostrar los libros: " + e.getMessage());
                        }
                        break;

                    case 4:
                        try {
                            System.out.print("Ingrese ISBN del libro a buscar: ");
                            String isbnBuscar = scanner.nextLine();
                            Libro libro = biblioteca.buscarLibro(isbnBuscar);
                            if (libro != null) {
                                System.out.println("Libro encontrado: " + libro);
                            } else {
                                System.out.println("Libro no encontrado.");
                            }
                        } catch (Exception e) {
                            System.out.println("Error al buscar libro: " + e.getMessage());
                        }
                        break;

                    case 0:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.nextLine(); // Limpiar buffer para evitar bucle infinito
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        } while (opcion != 0);

        scanner.close();
    }
}
