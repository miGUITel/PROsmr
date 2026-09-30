import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

// Java 11 o superior. Ejecutar desde una copia personal fuera del repositorio.
// Crea datos-pro/ junto al directorio de trabajo. Conserva los archivos existentes.
public class S06_Ficheros {
    public static void main(String[] args) {
        Path carpeta = Path.of("datos-pro");
        Path ficha = carpeta.resolve("equipo.txt");
        Path inventario = carpeta.resolve("inventario.csv");
        try {
            Files.createDirectories(carpeta);
            if (!Files.exists(ficha)) {
                Files.writeString(ficha, "Equipo: PC-01\nRAM: 16 GB\n",
                        StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW);
            }
            if (!Files.exists(inventario)) {
                Files.writeString(inventario, "id,nombre,ram\n1,PC-01,16\n2,PC-02,8\n",
                        StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW);
            }
            System.out.println("Carpeta: " + carpeta.toAbsolutePath());
            System.out.println(Files.readString(ficha, StandardCharsets.UTF_8));
            System.out.println(Files.readString(inventario, StandardCharsets.UTF_8));
        } catch (IOException error) {
            System.out.println("No se pudo acceder al fichero: " + error.getMessage());
        }
    }
}
