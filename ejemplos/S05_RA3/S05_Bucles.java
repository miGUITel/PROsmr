// Observa el inicio, la condición y el cambio en cada repetición.
public class S05_Bucles {
    public static void main(String[] args) {
        for (int equipo = 1; equipo <= 3; equipo++) {
            System.out.println("Equipo " + equipo);
        }

        int pendientes = 3;
        while (pendientes > 0) {
            System.out.println("Pendientes: " + pendientes);
            pendientes--;
        }

        int intentos = 0;
        do {
            System.out.println("Primera comprobacion");
            intentos++;
        } while (intentos < 0);

        // continue omite el resto de una vuelta; break termina el bucle.
        for (int equipo = 1; equipo <= 5; equipo++) {
            if (equipo == 2) {
                continue;
            }
            if (equipo == 4) {
                break;
            }
            System.out.println("Revisado: " + equipo);
        }
    }
}
