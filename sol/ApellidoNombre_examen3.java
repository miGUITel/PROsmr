import java.util.Scanner;

public class ApellidoNombre_examen3 {

    // Devuelve la velocidad (Mbps) según el tipo de conexión
    public static int obtenerVelocidad(String tipoConexion) {
        if (tipoConexion.equalsIgnoreCase("rápida") || tipoConexion.equalsIgnoreCase("rapida")) {
            return 50;
        } else if (tipoConexion.equalsIgnoreCase("media")) {
            return 15;
        } else {
            return 5; // lenta (o cualquier otro texto)
        }
    }

    // Calcula el tiempo estimado en segundos
    public static double calcularTiempoSegundos(double tamanoMB, int velocidadMbps) {
        // Pasamos MB a megabits: 1 MB = 8 Mb
        double tamanoMb = tamanoMB * 8.0;
        return tamanoMb / velocidadMbps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedimos datos
        System.out.print("Introduce el tamaño del archivo (MB): ");
        double tamanoMB = sc.nextDouble();
        sc.nextLine(); // limpiar salto de línea

        System.out.print("Introduce el tipo de conexión (rápida, media, lenta): ");
        String tipo = sc.nextLine();

        // Calculamos usando funciones
        int velocidad = obtenerVelocidad(tipo);
        double tiempoSegundos = calcularTiempoSegundos(tamanoMB, velocidad);

        // Mostramos resultados (solo segundos)
        System.out.println("Tamaño del archivo: " + tamanoMB + " MB");
        System.out.println("Conexión: " + tipo + " (" + velocidad + " Mbps)");
        System.out.println("Tiempo estimado: " + tiempoSegundos + " segundos");

        sc.close();
    }
}
