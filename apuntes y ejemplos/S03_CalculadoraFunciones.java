public class S03_CalculadoraFunciones {
    public static void mostrarCabecera() {
        System.out.println("=== UTILIDAD DE ALMACENAMIENTO ===");
    }

    public static double calcularEspacioLibre(double capacidadTotal, double espacioUsado) {
        return capacidadTotal - espacioUsado;
    }

    public static double convertirGbAMb(double gigabytes) {
        return gigabytes * 1024;
    }

    public static void mostrarResultado(String etiqueta, double valor, String unidad) {
        System.out.println(etiqueta + ": " + valor + " " + unidad);
    }

    public static void main(String[] args) {
        double capacidadTotal = 512;
        double espacioUsado = 320;

        mostrarCabecera();

        double espacioCalculado = calcularEspacioLibre(capacidadTotal, espacioUsado);
        double espacioLibre = Math.max(0, espacioCalculado);
        double espacioLibreMb = convertirGbAMb(espacioLibre);

        mostrarResultado("Capacidad total", capacidadTotal, "GB");
        mostrarResultado("Espacio usado", espacioUsado, "GB");
        mostrarResultado("Espacio libre", espacioLibre, "GB");
        mostrarResultado("Espacio libre", espacioLibreMb, "MB");
    }
}

