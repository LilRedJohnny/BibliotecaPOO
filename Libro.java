public class Libro extends RecursoBibliografico {
    private String autor;

    public Libro(String titulo, String id, String autor) {
        super(titulo, id);
        this.autor = autor;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Libro: " + titulo + " | Autor: " + autor + " | ID: " + id);
    }
}