// Antes de ejecutar, predice el mensaje para 85, 84 y 100.
public class S05_Seleccion {
    public static void mostrarEstado(int ocupacion) {
        if (ocupacion >= 85) {
            System.out.println("Revisar espacio");
        } else {
            System.out.println("Espacio suficiente");
        }
    }

    public static void mostrarInstalacion(int ram, int espacioLibre) {
        // Se necesitan los dos requisitos: RAM y espacio libre suficientes.
        if (ram >= 8 && espacioLibre >= 20) {
            System.out.println("Puede instalarse");
        } else {
            System.out.println("No cumple los requisitos");
        }
    }

    public static void main(String[] args) {
        mostrarEstado(85);
        mostrarEstado(84);
        mostrarEstado(100);

        mostrarInstalacion(16, 20);
        mostrarInstalacion(4, 20);
        mostrarInstalacion(16, 10);

        int opcion = 2;
        switch (opcion) {
            case 1:
                System.out.println("Consultar equipo");
                break;
            case 2:
                System.out.println("Revisar disco");
                break;
            default:
                System.out.println("Opcion desconocida");
        }
    }
}
