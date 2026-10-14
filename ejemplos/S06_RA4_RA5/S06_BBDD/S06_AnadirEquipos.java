import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// Ejecutar desde la carpeta S06_BBDD de una copia personal.
// SQLite guarda los datos en equipos.db, no en :memory:.
public class S06_AnadirEquipos {
    public static void main(String[] args) {
        Path base = Path.of("equipos.db").toAbsolutePath().normalize();
        System.out.println("Base de datos: " + base);

        try (Connection conexion = DriverManager.getConnection("jdbc:sqlite:" + base);
                Scanner teclado = new Scanner(System.in)) {
            try (Statement sentencia = conexion.createStatement()) {
                // Esperar hasta 5 segundos si otro programa está usando la base.
                sentencia.execute("PRAGMA busy_timeout = 5000");
                // Crear la tabla si falta, conservando los datos existentes.
                sentencia.executeUpdate("CREATE TABLE IF NOT EXISTS equipos ("
                        + "id INTEGER PRIMARY KEY, nombre TEXT NOT NULL, "
                        + "ram INTEGER NOT NULL CHECK (ram > 0))");
            }

            System.out.println("Añade equipos. Deja el nombre vacío para salir.");
            while (true) {
                System.out.print("Nombre del equipo: ");
                if (!teclado.hasNextLine()) {
                    break;
                }
                String nombre = teclado.nextLine().trim();
                if (nombre.isEmpty()) {
                    break;
                }

                int ram = 0;
                while (ram <= 0) {
                    System.out.print("RAM en GB (entero positivo): ");
                    if (!teclado.hasNextLine()) {
                        return;
                    }
                    try {
                        ram = Integer.parseInt(teclado.nextLine().trim());
                        if (ram <= 0) {
                            System.out.println("La RAM debe ser mayor que cero.");
                        }
                    } catch (NumberFormatException error) {
                        System.out.println("Escribe un número entero, por ejemplo 16.");
                    }
                }

                // Los valores se envían como parámetros, sin concatenarlos al SQL.
                // SQLite asigna el id porque omitimos esa columna en el INSERT.
                try (PreparedStatement alta = conexion.prepareStatement(
                        "INSERT INTO equipos (nombre, ram) VALUES (?, ?)")) {
                    alta.setString(1, nombre);
                    alta.setInt(2, ram);
                    alta.executeUpdate();
                    // JDBC usa autocommit: el INSERT ya está confirmado en disco.
                    System.out.println("Guardado: " + nombre + " · " + ram + " GB");
                } catch (SQLException error) {
                    System.out.println("No se guardó el equipo: " + error.getMessage());
                }
            }
            System.out.println("Programa cerrado. Los equipos permanecen en equipos.db.");
        } catch (SQLException error) {
            System.out.println("No se pudo abrir o preparar la base: " + error.getMessage());
            System.out.println("Comprueba las librerías y el permiso de escritura en la carpeta.");
        }
    }
}
