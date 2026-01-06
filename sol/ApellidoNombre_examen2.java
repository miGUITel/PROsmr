import java.util.Scanner;

public class ApellidoNombre_examen2 {

    // Devuelve true si n es par
    public static boolean esPar(int n) {
        return n % 2 == 0;
    }

    // Devuelve true si n es positivo o cero
    public static boolean esPositivo(int n) {
        return n >= 0;
    }

    // Devuelve true si n es múltiplo de 3
    public static boolean esMultiploDe3(int n) {
        return n % 3 == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedimos el número
        System.out.print("Introduce un número entero: ");
        int n = sc.nextInt();

        // Mostramos análisis usando las funciones
        System.out.println("Número analizado: " + n);

        if (esPar(n)) {
            System.out.println("Es par: sí");
        } else {
            System.out.println("Es par: no");
        }

        if (esPositivo(n)) {
            System.out.println("Es positivo: sí");
        } else {
            System.out.println("Es positivo: no");
        }

        if (esMultiploDe3(n)) {
            System.out.println("Es múltiplo de 3: sí");
        } else {
            System.out.println("Es múltiplo de 3: no");
        }

        sc.close();
    }
}
