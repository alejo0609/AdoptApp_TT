package gestionbiblioteca;
import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Libro> libros;

    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        try {
            libros.add(libro);
            System.out.println("Libro agregado: " + libro);
        } catch (Exception e) {
            System.out.println("Error al agregar el libro: " + e.getMessage());
        }
    }

    public void eliminarLibro(String isbn) {
        try {
            boolean eliminado = libros.removeIf(libro -> libro.getIsbn().equals(isbn));
            if (eliminado) {
                System.out.println("Libro con ISBN " + isbn + " eliminado.");
            } else {
                System.out.println("No se encontró un libro con ese ISBN.");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar el libro: " + e.getMessage());
        }
    }

    public void verTodosLosLibros() {
        try {
            if (libros.isEmpty()) {
                System.out.println("No hay libros en la biblioteca.");
            } else {
                libros.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar los libros: " + e.getMessage());
        }
    }

    public Libro buscarLibro(String isbn) {
        try {
            for (Libro libro : libros) {
                if (libro.getIsbn().equals(isbn)) {
                    return libro;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al buscar el libro: " + e.getMessage());
        }
        return null;
    }
}
