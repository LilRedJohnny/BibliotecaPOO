import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Libro l1 = new Libro("Cien Años de Soledad", "ISBN001", "Gabriel García Márquez");
        Libro l2 = new Libro("1984", "ISBN002", "George Orwell");
        Libro l3 = new Libro("El Quijote", "ISBN003", "Miguel de Cervantes");
        Libro l4 = new Libro("La Odisea", "ISBN004", "Homero");
        Libro l5 = new Libro("Crónica de una muerte anunciada", "ISBN005", "Gabriel García Márquez");

        Revista r1 = new Revista("National Geographic", "ISSN001", 2023, 5);
        Revista r2 = new Revista("Ciencia Hoy", "ISSN002", 2022, 3);
        Revista r3 = new Revista("Muy Interesante", "ISSN003", 2024, 4);

        List<RecursoBibliografico> recursos = new ArrayList<>(Arrays.asList(l1, l2, l3, l4, l5, r1, r2, r3));

        Usuario usuario = new Usuario("Juan");

        int opcion;
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Ver recursos");
            System.out.println("2. Prestar recurso");
            System.out.println("3. Devolver recurso");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    for (int i = 0; i < recursos.size(); i++) {
                        System.out.print(i + ". ");
                        recursos.get(i).mostrarDetalle();
                    }
                    break;
                case 2:
                    System.out.print("Ingresa número de recurso a prestar: ");
                    int prestamo = scanner.nextInt();
                    usuario.prestarRecurso(recursos.get(prestamo));
                    break;
                case 3:
                    System.out.print("Ingresa número de recurso a devolver: ");
                    int devolucion = scanner.nextInt();
                    usuario.devolverRecurso(recursos.get(devolucion));
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }
}