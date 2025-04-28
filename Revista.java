public class Revista extends RecursoBibliografico {
    private int anioPublicacion;
    private int ejemplares;

    public Revista(String titulo, String id, int anioPublicacion, int ejemplares) {
        super(titulo, id);
        this.anioPublicacion = anioPublicacion;
        this.ejemplares = ejemplares;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Revista: " + titulo + " | Año: " + anioPublicacion + " | ID: " + id + " | Ejemplares: " + ejemplares);
    }
}