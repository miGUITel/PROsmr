// Separa texto no numérico de un número fuera del rango permitido.
public class S05_Excepciones {
    public static void comprobarRam(String texto) {
        try {
            int ram = Integer.parseInt(texto);
            if (ram <= 0) {
                System.out.println("La RAM debe ser positiva");
                return;
            }
            System.out.println("RAM: " + ram + " GB");
        } catch (NumberFormatException error) {
            System.out.println("Escribe un numero entero");
        }
    }

    public static void main(String[] args) {
        comprobarRam("16");
        comprobarRam("dieciseis");
        comprobarRam("-1");
        System.out.println("Fin de las comprobaciones");
    }
}
