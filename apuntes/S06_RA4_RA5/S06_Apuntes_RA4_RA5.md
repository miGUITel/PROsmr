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

## SQL: consultar y cambiar datos - recordamos de 1º

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

## Java y JDBC: PARA PODER TRABAJAR CON BBDD EN JAVA

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

Vamos a ejecutar dos demostraciones: primero una base temporal en memoria y después una base almacenada en un archivo. Todos los recursos están reunidos en [S06_BBDD](../../ejemplos/S06_RA4_RA5/S06_BBDD/S06_LeerAntes.md). La carpeta incluye una copia de [S06_BaseDatos.java](../../ejemplos/S06_RA4_RA5/S06_BBDD/S06_BaseDatos.java), los dos programas de altas y lectura, una base inicial y las librerías necesarias.

## Preparación de las dos demostraciones en Ubuntu

### 1. Comprobar Java antes de empezar

Abre una terminal de Ubuntu o de VSCode y ejecuta estos dos comandos por separado:

```bash
java -version
```

```bash
javac -version
```

Ambos deben mostrar una versión **11 o superior**. `java` ejecuta los programas y `javac` confirma que disponemos del JDK, el conjunto de herramientas para desarrollar en Java. No basta con que VSCode esté instalado.

Si ambos funcionan con una versión válida, continúa. **Solo si falta el JDK o la versión es anterior a 11**, pide al profesor preparar el equipo. En Ubuntu puede instalarse el JDK de la distribución:

```bash
sudo apt update
sudo apt install default-jdk
```

Esta instalación necesita Internet y una cuenta con permiso de administración. Después hay que repetir las dos comprobaciones. [Guía oficial de Ubuntu](https://ubuntu.com/developers/docs/howto/java-setup/).

### 2. Copiar todos los recursos a una carpeta personal

1. Actualiza tu copia del repositorio del profesor.
2. Localiza `repositorio/ejemplos/S06_RA4_RA5/S06_BBDD`.
3. **Copia la carpeta completa `S06_BBDD` fuera del repositorio**, por ejemplo dentro de `Documentos/PRO`. No copies solo los `.java`: necesitamos también la carpeta `lib/` y `equipos.db`.
4. En VSCode, selecciona **Archivo → Abrir carpeta** y abre tu copia personal de `S06_BBDD`.
5. Selecciona **Terminal → Nueva terminal**. Antes de ejecutar los programas, comprueba dónde estás:

```bash
pwd
ls
ls lib
```

`pwd` debe terminar en tu copia personal de `S06_BBDD`. El primer `ls` debe mostrar `S06_BaseDatos.java`, `S06_AnadirEquipos.java`, `S06_LeerEquipos.java`, `equipos.db` y `lib`. `ls lib` debe mostrar estos tres JAR:

- `sqlite-jdbc-3.45.3.0.jar`: el controlador JDBC y el motor SQLite.
- `slf4j-api-2.0.9.jar`: una librería auxiliar que requiere el controlador incluido.
- `slf4j-simple-2.0.9.jar`: completa esa librería auxiliar.

Si `pwd` muestra otra carpeta, sitúate en la copia de `S06_BBDD` antes de continuar. La carpeta debe tener permiso de escritura. Conserva también `.vscode`, aunque el gestor de archivos pueda ocultarla; las pruebas de terminal funcionan con los comandos indicados. La extensión Java de VSCode es opcional para estas pruebas.

No necesitamos instalar un servidor de bases de datos, crear un usuario o una contraseña, instalar Maven ni utilizar un visor de SQLite. Los JAR incluidos permiten trabajar desde Java; una vez preparada la copia y disponible el JDK, las demostraciones funcionan sin Internet.

**Trabaja siempre sobre la copia personal.** El repositorio del profesor distribuye los materiales iniciales. Si después vuelves a copiar `equipos.db` encima de tu archivo personal, sustituirás los equipos que hayas añadido.

### 3. Entender el comando que utilizaremos

```bash
java -cp 'lib/*' S06_BaseDatos.java
```

`java` inicia la ejecución. `-cp 'lib/*'` indica dónde están las librerías: `lib` es la carpeta y `*` incluye sus JAR. Las comillas conservan ese texto como un único argumento. El último elemento es el archivo fuente que vamos a ejecutar. Desde Java 11 podemos ejecutarlo directamente así, sin crear antes un `.class` con otro comando.

En los tres comandos cambia únicamente el nombre del `.java`. Todos se ejecutan **desde la misma copia de `S06_BBDD`**. Usa la terminal para estas comprobaciones: no dependemos de que el botón de ejecución de una extensión elija correctamente las librerías o el directorio de trabajo.

## Primera demostración: una base de datos en memoria

### Paso 1. Localizar la conexión

Abre `S06_BaseDatos.java` en la copia personal y busca:

```java
DriverManager.getConnection("jdbc:sqlite::memory:")
```

| Parte | Significado |
|---|---|
| `jdbc:` | El programa accede a la base mediante JDBC. |
| `sqlite:` | El controlador y el motor utilizados son SQLite. |
| `:memory:` | La base se crea en RAM para esta conexión. |

Es una base de datos real, con tabla y consultas SQL. Su contenido es temporal: desaparece al cerrar la conexión. No necesita una BBDD preparada previamente y **no utiliza el archivo `equipos.db` que ya está en la carpeta**.

### Paso 2. Ejecutar una vez y observar

En la terminal situada en tu copia personal de `S06_BBDD`, ejecuta:

```bash
java -cp 'lib/*' S06_BaseDatos.java
```

No hay que introducir datos por teclado. El propio código realiza las operaciones y termina. La salida debe ser:

```text
PC-01: 16 GB
PC-02: 16 GB
Filas eliminadas: 1
```

Sigue la secuencia en el archivo Java:

1. **Conectar:** `getConnection` abre la base nueva en memoria.
2. **Crear la tabla:** `Statement` ejecuta el `CREATE TABLE equipos`. Solo necesitamos crearlo para enviar esa instrucción fija.
3. **Añadir dos equipos:** un `PreparedStatement` contiene el `INSERT` con tres `?`. `setInt` y `setString` rellenan sus parámetros, numerados desde 1. Se añade PC-01 con 8 GB y después PC-02 con 16 GB.
4. **Modificar:** otro `PreparedStatement` ejecuta `UPDATE ... WHERE id = ?`. PC-01 pasa de 8 a 16 GB.
5. **Consultar:** `executeQuery` ejecuta el `SELECT` con RAM mínima 16. `ResultSet` contiene las filas devueltas; `next()` avanza a la siguiente y `getString`/`getInt` leen sus columnas. En este momento ambos equipos tienen 16 GB, por eso aparecen los dos.
6. **Eliminar:** `executeUpdate` ejecuta el `DELETE` del id 2. Devuelve 1 porque ha eliminado una fila. La consulta anterior ya se mostró; la eliminación sucede después.
7. **Cerrar:** al terminar cada `try` con recursos se cierran sus objetos JDBC. El cierre de la conexión final elimina la base que estaba en RAM.

`executeUpdate()` se usa en este ejemplo para crear la tabla y para insertar, modificar y eliminar. En los cambios de filas devuelve cuántas se han afectado. `executeQuery()` se usa para recuperar filas con `SELECT`. Si una operación de acceso falla, `SQLException` permite mostrar un mensaje de error.

### Paso 3. Ejecutar otra vez y comparar

Repite exactamente el mismo comando. Debe aparecer **la misma salida completa**, aunque la ejecución anterior haya eliminado PC-02. La conexión nueva ha creado otra base vacía y el código ha vuelto a crear la tabla y los dos registros.

Esta prueba no crea ningún archivo `.db` ni cambia el `equipos.db` que ya estaba incluido en la carpeta. Dos programas independientes que utilicen cada uno `:memory:` no compartirían esta base: cada conexión del ejemplo tendría la suya. Para compartir datos entre nuestras dos aplicaciones vamos a abrir el mismo archivo en disco.

## Segunda demostración: añadir y consultar un archivo `equipos.db`

### Paso 1. Reconocer la base inicial

`equipos.db` es una base SQLite en formato binario. Contiene la tabla `equipos` y dos equipos ficticios:

| id | nombre | ram |
|---:|---|---:|
| 1 | PC-01 | 8 |
| 2 | PC-02 | 16 |

No la edites como si fuera un TXT. Esta base es independiente de la creada en memoria: **PC-01 mantiene aquí 8 GB**. Cada programa accede al archivo mediante SQLite y JDBC.

El programa de altas construye la ruta absoluta de `equipos.db` a partir de la carpeta de trabajo y abre una conexión como esta:

```java
DriverManager.getConnection("jdbc:sqlite:" + base)
```

El lector abre `jdbc:sqlite:file:equipos.db?mode=ro`: `mode=ro` pide solo lectura y exige que el archivo exista. Cada programa tiene su propia conexión; las dos apuntan al mismo archivo porque los lanzamos desde la misma carpeta.

### Paso 2. Abrir el programa que añade

En la primera terminal de VSCode, ejecuta:

```bash
java -cp 'lib/*' S06_AnadirEquipos.java
```

Se muestra `Base de datos: .../S06_BBDD/equipos.db` y después:

```text
Añade equipos. Deja el nombre vacío para salir.
Nombre del equipo:
```

Déjalo abierto, esperando el nombre. Todavía no añadas el equipo.

### Paso 3. Abrir el lector a la vez

Selecciona **Terminal → Nueva terminal** para abrir una segunda terminal. Comprueba `pwd`: debe señalar exactamente la misma copia personal de `S06_BBDD`. Ejecuta:

```bash
java -cp 'lib/*' S06_LeerEquipos.java
```

Compara la ruta que muestra con la de la primera terminal: **debe ser la misma ruta completa a `equipos.db`**. En una copia inicial se verá:

```text
ID | Nombre | RAM (GB)
1 | PC-01 | 8
2 | PC-02 | 16
Total: 2 equipos.
Intro para actualizar; escribe salir para terminar:
```

El lector permanece abierto. Tener dos programas abiertos significa que el escritor espera nuevos equipos y el lector espera que pidamos una consulta. No hay que cerrar uno para utilizar el otro.

### Paso 4. Añadir PC-03 y actualizar la consulta

1. Vuelve a la primera terminal. Donde pide el nombre, escribe `PC-03` y pulsa **Intro**.
2. Donde pide `RAM en GB (entero positivo):`, escribe `32` y pulsa **Intro**.
3. Debe aparecer `Guardado: PC-03 · 32 GB`. El programa vuelve a pedir un nombre y permanece abierto.
4. Vuelve a la segunda terminal y pulsa **Intro**, sin escribir otra cosa. Esto ejecuta un `SELECT` nuevo.

Si partimos de la base inicial, ahora se verá:

```text
ID | Nombre | RAM (GB)
1 | PC-01 | 8
2 | PC-02 | 16
3 | PC-03 | 32
Total: 3 equipos.
Intro para actualizar; escribe salir para terminar:
```

**El texto ya impreso en la terminal no se actualiza solo.** Intro hace que el lector consulte de nuevo y muestre otro listado. La prueba demuestra que una aplicación puede leer el dato que otra acaba de guardar en el mismo archivo.

Si ya habías realizado altas, habrá más filas y PC-03 puede recibir un id mayor que 3. El nombre puede repetirse; cada registro recibe su propio identificador. No borres la base ni copies la inicial encima para hacer que coincida la salida con esta muestra.

### Paso 5. Cerrar los dos programas y comprobar la persistencia

1. En el programa de altas, cuando vuelve a pedir `Nombre del equipo:`, pulsa **Intro sin escribir nada**. Mostrará que se ha cerrado y que los equipos permanecen en `equipos.db`.
2. En el lector, escribe `salir` y pulsa **Intro**. También debe volver a aparecer el indicador normal de la terminal.
3. Con ambos programas cerrados, vuelve a ejecutar el lector desde la misma copia:

```bash
java -cp 'lib/*' S06_LeerEquipos.java
```

PC-03 con 32 GB debe seguir en el listado. **Esa es la comprobación de persistencia:** el proceso anterior ya terminó y el dato se recupera del archivo. Intro en el lector mientras ambos estaban abiertos comprobaba una lectura nueva; cerrar y volver a abrir comprueba que la información se conserva entre ejecuciones.

Puedes cerrar de nuevo el lector escribiendo `salir`. Conserva tu copia personal de `equipos.db` para continuar otro día.

## Cómo funcionan los dos programas

### `S06_AnadirEquipos.java`

`Path.of("equipos.db").toAbsolutePath().normalize()` calcula y muestra la ruta que vamos a usar. La conexión abre ese archivo. `CREATE TABLE IF NOT EXISTS` crea la tabla solamente si falta: **no borra ni reinicia los registros existentes**. Si el archivo falta en una carpeta con permiso de escritura, el programa de altas puede crear una nueva base; para seguir la muestra de los dos equipos iniciales necesitamos la base incluida.

Un único `Scanner` lee el nombre y la RAM. El nombre vacío termina el bucle. La RAM se convierte a entero y debe ser positiva; si escribes texto, cero o un negativo, se vuelve a pedir la RAM y no se guarda esa entrada.

La inserción es:

```java
PreparedStatement alta = conexion.prepareStatement(
    "INSERT INTO equipos (nombre, ram) VALUES (?, ?)");
alta.setString(1, nombre);
alta.setInt(2, ram);
alta.executeUpdate();
```

Cada `?` recibe un valor aparte; no concatenamos la entrada dentro del SQL. Omitimos `id` para que SQLite asigne uno a la columna `INTEGER PRIMARY KEY`. La conexión mantiene la **confirmación automática** o *autocommit*, activada por defecto en JDBC: cada `INSERT` que termina correctamente queda confirmado. Por eso aparece `Guardado` y la otra conexión ya puede recuperar la fila; no tenemos que añadir aquí un `commit()` manual.

### `S06_LeerEquipos.java`

La conexión de solo lectura permite consultar sin modificar los registros. El `SELECT id, nombre, ram FROM equipos ORDER BY id` obtiene todos los equipos en orden de identificador. Un `ResultSet` permite recorrer cada fila con `next()` y recuperar sus columnas.

La consulta y sus resultados se cierran **antes de esperar al teclado**. Al pulsar Intro, el bucle crea y ejecuta otra consulta; por eso muestra las nuevas altas confirmadas. Al escribir `salir`, termina el bucle y se cierran la conexión y el teclado mediante `try` con recursos.

Los programas establecen un tiempo de espera de hasta cinco segundos si encuentran la base ocupada (`PRAGMA busy_timeout = 5000`). Las operaciones de la demostración son breves y SQLite coordina el acceso al archivo. Puede crear un archivo auxiliar como `equipos.db-journal` durante una escritura; no lo borres mientras estén funcionando los programas.

## Si la demostración no funciona

| Problema | Qué hacer |
|---|---|
| `java` o `javac` no se encuentra, o la versión es anterior a 11 | Revisar con el profesor la instalación del JDK y repetir las dos comprobaciones. |
| No encuentra el archivo `.java` | Ejecutar `pwd` y `ls`; abrir la terminal en la copia personal de `S06_BBDD`. |
| `No suitable driver` o `NoClassDefFoundError` | Usar el comando completo con `-cp 'lib/*'` y comprobar que `lib/` conserva los tres JAR. |
| El lector no puede abrir la base | Comprobar que `equipos.db` está en la carpeta de trabajo y que se ha copiado la carpeta completa. El lector de solo lectura no crea el archivo. |
| PC-03 no aparece | Verificar que el escritor ha mostrado `Guardado`, pulsar Intro en el lector y comparar las dos rutas de `equipos.db`. |
| El listado tiene más filas o un id diferente | Se han conservado altas anteriores. Usar ese listado; no sustituir ni reiniciar la base personal. |
| No se puede escribir | Usar una carpeta personal con permiso de escritura, incluido permiso para crear archivos auxiliares. |
| `database is locked` | Terminar cualquier operación pendiente en otra aplicación que use la base y volver a intentar la consulta o el alta. |

En Windows PowerShell también sirven los mismos tres comandos si `java` está disponible. La condición sigue siendo ejecutar desde la copia personal de `S06_BBDD`.

## Memoria y archivo: qué hemos comprobado

| Aspecto | `S06_BaseDatos.java` | Altas y lector |
|---|---|---|
| Base utilizada | Nueva base en RAM para su conexión. | El mismo archivo `equipos.db` en disco. |
| Datos de partida | El código crea la tabla e introduce dos equipos cada vez. | El archivo incluido contiene dos equipos; las altas personales se conservan. |
| Después de cerrar | La base en memoria desaparece. | Los registros confirmados permanecen en el archivo. |
| Cómo comprobarlo | Repetir la ejecución: vuelve a empezar de cero. | Cerrar ambos programas y volver a abrir el lector: PC-03 sigue ahí. |
| Dos programas | Cada conexión `:memory:` de nuestros ejemplos tendría su propia base. | Ambos acceden al mismo archivo usando dos conexiones. |

Referencias para ampliar: [bases en memoria de SQLite](https://www.sqlite.org/inmemorydb.html), [controlador SQLite JDBC](https://github.com/xerial/sqlite-jdbc) y [conceptos de conexiones y confirmación automática en JDBC](https://docs.oracle.com/javase/tutorial/jdbc/basics/transactions.html).

## Elección del recurso

Un TXT resulta suficiente para una nota pequeña. CSV facilita intercambiar registros sencillos. Una base de datos resulta útil cuando necesitamos consultas, relaciones y reglas sobre un conjunto de registros. La elección depende del problema, no de que una opción sea siempre mejor que las demás.

Para afianzar la lectura hay [dos propuestas de RA4](../../ejemplos/S06_RA4_RA5/S06_Ejercicios_RA4.md) y [dos de RA5](../../ejemplos/S06_RA4_RA5/S06_Ejercicios_RA5.md).
