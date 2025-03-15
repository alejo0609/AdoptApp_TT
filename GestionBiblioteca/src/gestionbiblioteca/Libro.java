package gestionbiblioteca;

/**
 * Clase que representa un libro con t�tulo, autor e ISBN.
 */
public class Libro {

    private String titulo;
    private String autor;
    private String isbn;

    /**
     * Constructor del libro con validaciones.
     */
    public Libro(String titulo, String autor, String isbn) {
        setTitulo(titulo);
        setAutor(autor);
        setIsbn(isbn);
    }

    // GETTERS AND SETTERS con validaciones
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El t�tulo no puede estar vac�o.");
        }
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("El autor no puede estar vac�o.");
        }
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("El ISBN no puede estar vac�o.");
        }
        if (!isbn.matches("\\d{10}|\\d{13}")) { // Verifica que tenga entre 10 y 13 d�gitos
            throw new IllegalArgumentException("El ISBN debe tener 10 o 13 d�gitos num�ricos.");
        }
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Libro{" + "titulo='" + titulo + '\'' + ", autor='" + autor + '\'' + ", isbn='" + isbn + '\'' + '}';
    }
}
