

/**
 * Clase principal de la gesti�n de la biblioteca.
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
     * M�todo principal para ejecutar el men� de opciones.
     * @param args Argumentos de l�nea de comandos.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        do {
            try {
                System.out.println("\nMen� de Biblioteca");
                System.out.println("1. Agregar libro");
                System.out.println("2. Eliminar libro");
                System.out.println("3. Ver todos los libros");
                System.out.println("4. Buscar libro");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opci�n: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        try {
                            System.out.print("Ingrese t�tulo: ");
                            String titulo = scanner.nextLine();
                            System.out.print("Ingrese autor: ");
                            String autor = scanner.nextLine();
                            System.out.print("Ingrese ISBN (10 � 13 d�gitos): ");
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
                        System.out.println("Opci�n inv�lida. Intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un n�mero v�lido.");
                scanner.nextLine(); // Limpiar buffer para evitar bucle infinito
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        } while (opcion != 0);

        scanner.close();
    }
}
