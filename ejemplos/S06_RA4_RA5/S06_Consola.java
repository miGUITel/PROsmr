import java.util.Locale;
import java.util.Scanner;

// Escribe un nombre de equipo cuando aparezca la pregunta.
public class S06_Consola {
    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.print("Nombre del equipo: ");
            String nombre = teclado.nextLine();
            double precio = 19.956;
            System.out.printf(Locale.US, "%s: %.2f euros%n", nombre, precio);
        }
    }
}
