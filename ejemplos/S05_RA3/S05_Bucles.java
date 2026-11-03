// Observa el inicio, la condición y el cambio en cada repetición.
public class S05_Bucles {
    public static void main(String[] args) {
        for (int equipo = 1; equipo <= 3; equipo++) {//joel dice que se imprimirá tres veces
            System.out.println("For Equipo " + equipo);
        }

        int pendientes = 5;//Miguel dice 5 veces
        while (pendientes > 0) {
            System.out.println("While Pendientes: " + pendientes);
            pendientes--;
        }

        int intentos = 0;
        do {
            System.out.println("Do while: Primera comprobacion");//Rodrigo dice una vez
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

            System.out.println(" For 2 - Revisado: " + equipo);
        }

        int equipo;
        // mustra que el ++ se ejecuta, la variable valdrá algo distinto de 5
        for (equipo = 1; equipo <= 5; equipo++) {

        System.out.println("For 2 - Revisado: " + equipo);

            
        }
        System.out.println("Pero el valor de la variable  equipo es : " + equipo);
    }
}
