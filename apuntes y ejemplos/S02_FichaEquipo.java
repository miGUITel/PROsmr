public class S02_FichaEquipo {
    public static void main(String[] args) {
        String nombreEquipo = "PC-AULA-01";
        int memoriaRamGb = 16;
        double capacidadDiscoGb = 512.0;
        boolean tieneSsd = true;
        char unidadPrincipal = 'C';
        final String UBICACION = "Aula 2.14";

        System.out.println("=== FICHA DEL EQUIPO ===");
        System.out.println("Nombre: " + nombreEquipo);
        System.out.println("RAM: " + memoriaRamGb + " GB");
        System.out.println("Disco: " + capacidadDiscoGb + " GB");
        System.out.println("SSD: " + tieneSsd);
        System.out.println("Unidad: " + unidadPrincipal);
        System.out.println("Ubicación: " + UBICACION);
    }
}

