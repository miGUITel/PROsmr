import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Ejemplo de lectura guiada de JDBC. Java incluye la API, pero no el controlador SQLite.
// Para ejecutarlo se necesita el controlador SQLite JDBC en el classpath.
// La base es temporal (:memory:), por lo que estas operaciones no alteran archivos.
// En esta sesión basta seguir el código y las consultas de los apuntes.
public class S06_BaseDatos {
    public static void main(String[] args) {
        try (Connection conexion = DriverManager.getConnection("jdbc:sqlite::memory:")) {
            try (Statement sentencia = conexion.createStatement()) {
                sentencia.executeUpdate("CREATE TABLE equipos ("
                        + "id INTEGER PRIMARY KEY, nombre TEXT NOT NULL, "
                        + "ram INTEGER CHECK (ram > 0))");
            }
            try (PreparedStatement alta = conexion.prepareStatement(
                    "INSERT INTO equipos (id, nombre, ram) VALUES (?, ?, ?)")) {
                alta.setInt(1, 1);
                alta.setString(2, "PC-01");
                alta.setInt(3, 8);
                alta.executeUpdate();
                alta.setInt(1, 2);
                alta.setString(2, "PC-02");
                alta.setInt(3, 16);
                alta.executeUpdate();
            }
            try (PreparedStatement cambio = conexion.prepareStatement(
                    "UPDATE equipos SET ram = ? WHERE id = ?")) {
                cambio.setInt(1, 16);
                cambio.setInt(2, 1);
                cambio.executeUpdate();
            }
            try (PreparedStatement consulta = conexion.prepareStatement(
                    "SELECT nombre, ram FROM equipos WHERE ram >= ? ORDER BY id")) {
                consulta.setInt(1, 16);
                try (ResultSet filas = consulta.executeQuery()) {
                    while (filas.next()) {
                        System.out.println(filas.getString("nombre") + ": "
                                + filas.getInt("ram") + " GB");
                    }
                }
            }
            try (PreparedStatement baja = conexion.prepareStatement(
                    "DELETE FROM equipos WHERE id = ?")) {
                baja.setInt(1, 2);
                System.out.println("Filas eliminadas: " + baja.executeUpdate());
            }
        } catch (SQLException error) {
            System.out.println("No se pudo usar la base de datos: " + error.getMessage());
            System.out.println("Para ejecutar, comprueba el controlador SQLite JDBC.");
        }
    }
}
