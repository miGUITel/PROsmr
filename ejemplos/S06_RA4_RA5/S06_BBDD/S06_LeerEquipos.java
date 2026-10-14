import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// Ejecutar desde la misma carpeta que S06_AnadirEquipos.
// Cada pulsación de Intro realiza una consulta nueva sobre equipos.db.
public class S06_LeerEquipos {
    public static void main(String[] args) {
        Path base = Path.of("equipos.db").toAbsolutePath().normalize();
        System.out.println("Base de datos: " + base);

        // mode=ro abre el archivo en modo de solo lectura y exige que exista.
        try (Connection conexion = DriverManager.getConnection(
                    "jdbc:sqlite:file:equipos.db?mode=ro");
                Scanner teclado = new Scanner(System.in)) {
            try (Statement sentencia = conexion.createStatement()) {
                sentencia.execute("PRAGMA busy_timeout = 5000");
            }

            while (true) {
                int total = 0;
                System.out.println("\nID | Nombre | RAM (GB)");
                try (PreparedStatement consulta = conexion.prepareStatement(
                        "SELECT id, nombre, ram FROM equipos ORDER BY id");
                        ResultSet filas = consulta.executeQuery()) {
                    while (filas.next()) {
                        System.out.println(filas.getInt("id") + " | "
                                + filas.getString("nombre") + " | " + filas.getInt("ram"));
                        total++;
                    }
                }
                // La consulta está cerrada antes de esperar al teclado.
                // Así el lector no mantiene bloqueada la base mientras espera.
                System.out.println("Total: " + total + " equipos.");
                System.out.print("Intro para actualizar; escribe salir para terminar: ");
                if (!teclado.hasNextLine()
                        || teclado.nextLine().trim().equalsIgnoreCase("salir")) {
                    break;
                }
            }
        } catch (SQLException error) {
            System.out.println("No se pudo leer la base: " + error.getMessage());
            System.out.println("Comprueba las librerías y abre la terminal en S06_BBDD.");
            System.out.println("Debe existir equipos.db con su tabla equipos.");
        }
    }
}
