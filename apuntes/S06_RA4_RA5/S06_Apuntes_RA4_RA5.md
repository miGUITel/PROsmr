# S06 · RA4 y RA5: entrada, salida y persistencia

## Información que permanece

Las variables sirven para trabajar con datos durante la ejecución. Para recuperarlos cuando volvemos a abrir el programa, necesitamos guardarlos en un medio persistente, como un fichero o una base de datos almacenados en disco.

Mostrar un dato en la consola no equivale a guardarlo en un fichero. Tampoco toda base de datos persiste necesariamente: una base creada solo en memoria desaparece al cerrar su conexión, como ocurre en el ejemplo de esta sesión.

## Entrada y salida por consola

`System.out.print` muestra texto sin añadir un salto de línea y `println` añade ese salto. `Scanner` permite leer información:

```java
try (Scanner teclado = new Scanner(System.in)) {
    System.out.print("Nombre del equipo: ");
    String nombre = teclado.nextLine();
    System.out.println("Equipo: " + nombre);
}
```

Necesitamos `import java.util.Scanner;`. `nextLine()` devuelve el texto de una línea, aunque lo escrito parezca un número. Para obtener un entero usaríamos una conversión y comprobaríamos que el dato es válido. El ejemplo usa un único `Scanner`; al finalizar se cierra el recurso.

## Formato de la salida

```java
System.out.printf(Locale.US, "%s: %.2f euros%n", nombre, precio);
```

`%s` coloca un texto, `%.2f` muestra un decimal con dos cifras decimales y `%n` añade un salto de línea. También existe `%d` para enteros. Los argumentos deben corresponder con los marcadores y conservar el orden.

`Locale.US`, importado desde `java.util.Locale`, fija el punto como separador decimal en este ejemplo. Dar formato cambia la presentación del dato; la variable original conserva su valor. El precio `19.956` se muestra como `19.96`.

Abre [S06_Consola.java](../../ejemplos/S06_RA4_RA5/S06_Consola.java).

## Rutas y librerías de ficheros

Una ruta identifica un archivo o carpeta. Una ruta relativa, como `datos-pro/equipo.txt`, se interpreta desde el directorio de trabajo del programa. Una ruta absoluta indica su ubicación completa.

Java proporciona `Path` y `Files`, en `java.nio.file`. `Path.of` construye una ruta, pero no crea el fichero. `Files` contiene operaciones para crearlo, leerlo o escribirlo. Nuestro ejemplo utiliza Java 11 o superior.

## Escritura y lectura

```java
Path ficha = Path.of("datos-pro", "equipo.txt");
Files.writeString(ficha, "Equipo: PC-01\n", StandardCharsets.UTF_8);
String contenido = Files.readString(ficha, StandardCharsets.UTF_8);
System.out.println(contenido);
```

La carpeta debe existir. `writeString` sin opciones crea el fichero si hace falta y reemplaza su contenido si ya existe. Para añadir se utiliza una opción como `APPEND`; para exigir un archivo nuevo existe `CREATE_NEW`.

La codificación indica cómo convertir texto en bytes y recuperarlo. Usamos UTF-8 al escribir y al leer, evitando interpretaciones diferentes del mismo contenido.

Las operaciones pueden fallar por una ruta inexistente, permisos insuficientes u otros problemas de acceso. El ejemplo captura `IOException` y muestra un mensaje. No presupongas que una escritura ha funcionado si se ha producido un error.

## Texto libre y CSV

Un fichero de texto puede contener una ficha redactada. CSV organiza texto en filas y campos separados por un delimitador:

```text
id,nombre,ram
1,PC-01,16
2,PC-02,8
```

La primera fila describe los campos. CSV sigue siendo texto; su organización facilita el intercambio con otras aplicaciones. El ejemplo usa comas y campos sencillos, sin comas internas. En datos reales puede ser necesario entrecomillar campos y utilizar una librería de CSV. Un archivo CSV, por sí solo, no ofrece las restricciones ni las consultas de un gestor de bases de datos.

Abre [S06_Ficheros.java](../../ejemplos/S06_RA4_RA5/S06_Ficheros.java). Ejecútalo desde una copia personal: crea `datos-pro/`, una ficha TXT y un inventario CSV, y después los lee. Conserva los archivos existentes. La salida muestra la ruta absoluta para encontrarlos. Al ejecutarlo de nuevo, podrás comprobar que recupera los mismos archivos.

## Tablas y bases de datos relacionales

Una tabla organiza información en filas y columnas. Cada fila representa un registro y cada columna un dato con una función definida.

| id | nombre | ram |
|---:|---|---:|
| 1 | PC-01 | 8 |
| 2 | PC-02 | 16 |

La clave primaria identifica cada registro sin duplicados ni valores nulos. Una clave ajena puede relacionar un registro con otro, por ejemplo el `aula_id` de un equipo con el identificador de una tabla de aulas.

Un sistema gestor de bases de datos (SGBD) ejecuta consultas, organiza el acceso y comprueba restricciones. SQLite es un motor embebido; otros gestores, como PostgreSQL, suelen utilizar un servidor. El programa se comunica con el gestor, no modifica a mano sus archivos internos.

## SQL: consultar y cambiar datos

SQL permite expresar operaciones sobre las tablas:

```sql
SELECT nombre, ram FROM equipos WHERE ram >= 16 ORDER BY id;
INSERT INTO equipos (id, nombre, ram) VALUES (3, 'PC-03', 8);
UPDATE equipos SET ram = 16 WHERE id = 1;
DELETE FROM equipos WHERE id = 2;
```

`SELECT` recupera datos, `INSERT` añade una fila, `UPDATE` modifica y `DELETE` elimina filas. `WHERE` limita las filas afectadas. Un `UPDATE` o `DELETE` sin `WHERE` actúa sobre todas las filas de la tabla. `ORDER BY` fija el orden; sin él no debemos depender del orden de salida.

Estas sentencias se leen por separado sobre la tabla inicial. El ejemplo Java realiza una secuencia concreta: crea la tabla, añade dos equipos, cambia la RAM del primero, consulta los dos y elimina el segundo.

## Integridad y consistencia

Las restricciones impiden guardar datos que incumplen reglas declaradas. `PRIMARY KEY` evita identificadores repetidos; `NOT NULL` exige un valor; `CHECK (ram > 0)` exige una RAM positiva cuando el valor no es nulo. Para impedir también el nulo combinaríamos `NOT NULL` y `CHECK`.

Una transacción agrupa cambios que deben completarse juntos. Por ejemplo, registrar un préstamo y marcar un equipo como prestado. Si falla una parte, `rollback` permite deshacer los cambios pendientes; `commit` los confirma. Aquí basta reconocer para qué sirven estas operaciones.

## Java y JDBC

JDBC es la API de Java para trabajar con bases de datos. Además de la API, se necesita un controlador compatible con el gestor.

```java
Connection conexion = DriverManager.getConnection("jdbc:sqlite::memory:");
PreparedStatement consulta = conexion.prepareStatement(
    "SELECT nombre, ram FROM equipos WHERE ram >= ?");
consulta.setInt(1, 16);
ResultSet filas = consulta.executeQuery();
```

La conexión representa la comunicación con la base. `PreparedStatement` contiene la consulta y `?` marca un dato que se enviará aparte. `setInt(1, 16)` asigna 16 al primer marcador. Esto permite tratar la entrada como un dato, sin concatenarla dentro del SQL.

`executeQuery()` obtiene un `ResultSet`. Para recorrer sus filas se utiliza `while (filas.next())`; `getString` y `getInt` recuperan columnas. `executeUpdate()` ejecuta cambios como un `UPDATE` y devuelve el número de filas afectadas. Los recursos se cierran con `try` con recursos y los problemas de acceso se gestionan mediante `SQLException`.

Abre [S06_BaseDatos.java](../../ejemplos/S06_RA4_RA5/S06_BaseDatos.java). Está preparado para **leer y seguir el código** en esta introducción. Su ejecución requiere un controlador SQLite JDBC en el classpath, que no forma parte del JDK ni se incluye en estos materiales. La conexión `:memory:` usa una base temporal para la demostración. La creación de una base persistente y su configuración se retomarán en la práctica guiada.

## Elección del recurso

Un TXT resulta suficiente para una nota pequeña. CSV facilita intercambiar registros sencillos. Una base de datos resulta útil cuando necesitamos consultas, relaciones y reglas sobre un conjunto de registros. La elección depende del problema, no de que una opción sea siempre mejor que las demás.

Para afianzar la lectura hay [dos propuestas de RA4](../../ejemplos/S06_RA4_RA5/S06_Ejercicios_RA4.md) y [dos de RA5](../../ejemplos/S06_RA4_RA5/S06_Ejercicios_RA5.md).
