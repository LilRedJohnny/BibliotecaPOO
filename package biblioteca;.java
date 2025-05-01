package biblioteca;

public abstract class RecursoBibliografico {

    protected String titulo;
    protected String id;

    public RecursoBibliografico(String titulo, String id) {
        this.titulo = titulo;
        this.id     = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getId() {
        return id;
    }

    /**  Punto clave del polimorfismo: cada sub-clase lo sobreescribe. */
    public abstract void mostrarDetalle();
}

package biblioteca;

public class Libro extends RecursoBibliografico {

    private String  autor;
    private boolean prestado;

    public Libro(String titulo, String isbn, String autor) {
        super(titulo, isbn);
        this.autor    = autor;
        this.prestado = false;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void prestar() {
        prestado = true;
    }

    public void devolver() {
        prestado = false;
    }

    @Override
    public void mostrarDetalle() {
        System.out.printf("Libro  | %-25s | Autor: %-15s | ISBN: %-13s | Prestado: %s%n",
                          titulo, autor, id, prestado ? "Sí" : "No");
    }
}

package biblioteca;

public class Revista extends RecursoBibliografico {

    private int  anioPublicacion;
    private int  ejemplares;

    public Revista(String titulo, String issn, int anioPublicacion, int ejemplares) {
        super(titulo, issn);
        this.anioPublicacion = anioPublicacion;
        this.ejemplares      = ejemplares;
    }

    @Override
    public void mostrarDetalle() {
        System.out.printf("Revista| %-25s | ISSN: %-9s | Año: %-4d | Ejemplares: %-2d%n",
                          titulo, id, anioPublicacion, ejemplares);
    }
}

package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String nombre;
    private List<RecursoBibliografico> recursosPrestados;

    public Usuario(String nombre) {
        this.nombre            = nombre;
        this.recursosPrestados = new ArrayList<>();
    }

    public boolean prestarRecurso(RecursoBibliografico r) {
        if (r instanceof Libro libro) {
            if (libro.isPrestado()) return false;
            libro.prestar();
        }
        // Para revistas asumimos que basta con registrar la salida,
        // o integra tu propia lógica de “stock” si la práctica lo pide.
        recursosPrestados.add(r);
        return true;
    }

    public boolean devolverRecurso(RecursoBibliografico r) {
        if (!recursosPrestados.remove(r)) return false;
        if (r instanceof Libro libro) libro.devolver();
        return true;
    }
}

package biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<RecursoBibliografico> catalogo = new ArrayList<>();
    private static final Usuario usuario = new Usuario("Invitado");

    public static void main(String[] args) {

        poblarCatalogoInicial();

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n1) Listar recursos  2) Prestar  3) Devolver  0) Salir");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar salto

            switch (opcion) {
                case 1 -> catalogo.forEach(RecursoBibliografico::mostrarDetalle);   // 🔑 Polimorfismo
                case 2 -> {
                    System.out.print("ID a prestar: ");
                    String id = sc.nextLine();
                    prestar(id);
                }
                case 3 -> {
                    System.out.print("ID a devolver: ");
                    String id = sc.nextLine();
                    devolver(id);
                }
            }
        } while (opcion != 0);
    }

    private static void poblarCatalogoInicial() {
        catalogo.add(new Libro("1984",          "9780451524935", "George Orwell"));
        catalogo.add(new Libro("Clean Code",    "9780132350884", "Robert C. Martin"));
        catalogo.add(new Libro("El Señor de los Anillos", "9780618640157", "J.R.R. Tolkien"));
        catalogo.add(new Libro("La Odisea",     "9780140268867", "Homero"));
        catalogo.add(new Libro("Don Quijote",   "9788491050101", "Miguel de Cervantes"));

        catalogo.add(new Revista("Nature",              "0028-0836", 2025, 50));
        catalogo.add(new Revista("IEEE Spectrum",       "0018-9235", 2024, 12));
        catalogo.add(new Revista("Ciencia UNAM",        "0187-9073", 2023,  6));
    }

    private static void prestar(String id) {
        catalogo.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .ifPresentOrElse(r -> {
                    if (usuario.prestarRecurso(r))
                        System.out.println("Préstamo realizado.");
                    else
                        System.out.println("No disponible.");
                }, () -> System.out.println("ID inexistente."));
    }

    private static void devolver(String id) {
        catalogo.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .ifPresentOrElse(r -> {
                    if (usuario.devolverRecurso(r))
                        System.out.println("Devolución registrada.");
                    else
                        System.out.println("Ese recurso no está prestado por ti.");
                }, () -> System.out.println("ID inexistente."));
    }
}
