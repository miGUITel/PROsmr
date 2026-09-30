// Demostración de métodos, parámetros, retorno y uso de Math.
public class S04_Almacenamiento {
    public static void mostrarCabecera() {
        System.out.println("UTILIDAD DE ALMACENAMIENTO");
    }

    public static void mostrarEquipo(String nombre, int ram) {
        System.out.println(nombre + " - " + ram + " GB de RAM");
    }

    public static double calcularLibre(double total, double usado) {
        // Limitamos la salida a cero; esto no valida los datos recibidos.
        return Math.max(0, total - usado);
    }

    public static void main(String[] args) {
        mostrarCabecera();
        mostrarEquipo("PC-04", 16);
        System.out.println(calcularLibre(512, 320));
        System.out.println(calcularLibre(256, 256));
        System.out.println(calcularLibre(128, 150));
    }
}
