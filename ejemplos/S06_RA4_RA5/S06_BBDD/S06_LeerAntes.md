# Probar una base en memoria y una base persistente con Java y SQLite

Esta carpeta reúne todo lo necesario para dos demostraciones. Primero ejecutaremos `S06_BaseDatos.java` con una base temporal en memoria. Después ejecutaremos a la vez `S06_AnadirEquipos.java` y `S06_LeerEquipos.java`, que utilizan el mismo archivo `equipos.db`. Cerraremos los dos y volveremos a abrir el lector para comprobar que los datos permanecen.

## Contenido

| Recurso | Función |
|---|---|
| `S06_BaseDatos.java` | Crea una base en memoria, añade dos equipos, modifica, consulta y elimina. Termina sin guardar esa base en disco. |
| `S06_AnadirEquipos.java` | Pide nombre y RAM, y guarda cada equipo. |
| `S06_LeerEquipos.java` | Muestra los equipos y repite la consulta al pulsar Intro. |
| `equipos.db` | Base SQLite con la tabla `equipos` y dos registros ficticios: PC-01 con 8 GB y PC-02 con 16 GB. |
| `lib/` | Controlador SQLite JDBC y sus librerías auxiliares. |
| `.vscode/` | Configuración para reconocer las librerías y ejecutar desde esta carpeta. |

La base es un archivo binario SQLite: no se edita como un fichero de texto.

## Qué necesita el ordenador con Ubuntu

- Un **JDK 11 o superior**. Comprueba los dos comandos siguientes en la terminal; ambos deben mostrar una versión 11 o superior. `java` ejecuta los programas; `javac` confirma que están disponibles las herramientas del JDK.
- Una carpeta personal local con permiso de escritura, que contenga una copia completa de `S06_BBDD`.
- VSCode para leer y editar los programas. **Extension Pack for Java** es útil para ejecutar y depurar desde el editor; los comandos de terminal funcionan sin esa extensión.

```bash
java -version
```

```bash
javac -version
```

Si ambos comandos funcionan con una versión válida, continúa. **Solo si falta el JDK o la versión es anterior a 11**, pide al profesor preparar el equipo. Ubuntu permite instalar el de su distribución así:

```bash
sudo apt update
sudo apt install default-jdk
```

La instalación necesita Internet y permiso de administración. Después hay que repetir `java -version` y `javac -version`. [Guía oficial de Ubuntu](https://ubuntu.com/developers/docs/howto/java-setup/).

No hace falta instalar un servidor de BBDD, el comando `sqlite3`, Maven ni un visor de SQLite. Tampoco se necesitan usuario o contraseña. Una vez copiada la carpeta y disponible el JDK, el ejemplo funciona sin Internet. El controlador incluido lleva el motor SQLite para Linux, además de otras plataformas.

## Preparar una copia de trabajo

1. Actualiza el repositorio del profesor.
2. Localiza `repositorio/ejemplos/S06_RA4_RA5/S06_BBDD` y copia la carpeta completa fuera del repositorio, por ejemplo a `Documentos/PRO/S06_BBDD`. Copia también `equipos.db`, `lib/` y `.vscode/`; no copies solamente los archivos Java.
3. En VSCode, utiliza **Archivo → Abrir carpeta** y abre esa copia de `S06_BBDD`. Esto permite que se aplique su configuración de librerías.
4. Selecciona **Terminal → Nueva terminal**. Comprueba el directorio de trabajo y los archivos:

```bash
pwd
ls
ls lib
```

`pwd` debe señalar la copia personal de `S06_BBDD`. `ls` debe mostrar los tres `.java`, `equipos.db` y `lib`. `ls lib` debe mostrar los tres JAR indicados en «Librerías incluidas». Si aparecen otros nombres o `pwd` muestra otra carpeta, sitúate en la copia de `S06_BBDD` antes de seguir. La carpeta `.vscode` puede estar oculta en el gestor de archivos; los comandos de terminal no dependen de ella.

El repositorio distribuye la base inicial. Las altas se realizan en la copia personal. Para conservar lo añadido, sigue trabajando con esa copia; volver a copiar encima la base inicial sustituiría tus datos.

## Primera prueba: base en memoria

### 1. Abrir y reconocer la conexión

Abre `S06_BaseDatos.java` dentro de tu copia de `S06_BBDD` y localiza:

```java
DriverManager.getConnection("jdbc:sqlite::memory:")
```

`jdbc:` indica el acceso mediante la API JDBC de Java; `sqlite:` selecciona el controlador y motor SQLite; `:memory:` crea una base nueva en RAM para esta conexión. No utiliza `equipos.db`, aunque ese archivo esté ya en la carpeta. Es una base real que permite ejecutar SQL; su contenido desaparece al cerrar la conexión. [Bases en memoria de SQLite](https://www.sqlite.org/inmemorydb.html).

### 2. Ejecutar la primera vez

En la terminal situada en la copia personal de `S06_BBDD`, ejecuta:

```bash
java -cp 'lib/*' S06_BaseDatos.java
```

El programa no solicita datos por teclado. Debe mostrar y terminar:

```text
PC-01: 16 GB
PC-02: 16 GB
Filas eliminadas: 1
```

`-cp 'lib/*'` indica a Java que utilice los JAR de `lib/`; conserva las comillas. Desde Java 11 se puede ejecutar el archivo fuente directamente así, sin generar primero un `.class` con otro comando. Usa estos comandos de terminal para seguir la demostración.

### 3. Seguir el código y repetir

El programa abre la conexión, crea la tabla `equipos`, añade PC-01 con 8 GB y PC-02 con 16 GB, cambia PC-01 a 16 GB, consulta los equipos con al menos 16 GB y elimina el id 2. La consulta se muestra antes de esa eliminación, por eso vemos los dos equipos. `Filas eliminadas: 1` informa del resultado del `DELETE`.

Vuelve a ejecutar **el mismo comando**. Debe aparecer la misma salida: cada ejecución crea otra base vacía y repite la secuencia. PC-02 no se queda eliminado para la siguiente ejecución porque la base anterior desapareció al cerrar.

Esta prueba **no crea un archivo `.db` y no cambia `equipos.db`**. La base incluida sigue preparada para la segunda prueba, con PC-01 de 8 GB y PC-02 de 16 GB. Cada conexión independiente a `:memory:` tendría su propia base en este ejemplo; para que nuestras dos aplicaciones compartan los equipos utilizaremos el mismo archivo.

## Segunda prueba: dos programas y el mismo archivo

### 1. Abrir el programa que añade

En la primera terminal de la copia personal de `S06_BBDD`, ejecuta:

```bash
java -cp 'lib/*' S06_AnadirEquipos.java
```

Mostrará la ruta absoluta de la base, `Añade equipos. Deja el nombre vacío para salir.` y `Nombre del equipo:`. **Déjalo abierto esperando el nombre**; todavía no escribas PC-03.

### 2. Abrir el lector al mismo tiempo

Selecciona **Terminal → Nueva terminal** para abrir otra terminal. Ejecuta `pwd` y comprueba que estás en exactamente la misma copia de `S06_BBDD`. Después ejecuta:

```bash
java -cp 'lib/*' S06_LeerEquipos.java
```

Los dos programas muestran al arrancar la ruta absoluta del archivo utilizado. **Compara las rutas: deben coincidir completamente**, incluido el nombre `equipos.db`. Así sabemos que no están usando dos archivos distintos en carpetas diferentes.

En una copia inicial, el lector debe mostrar:

```text
ID | Nombre | RAM (GB)
1 | PC-01 | 8
2 | PC-02 | 16
Total: 2 equipos.
Intro para actualizar; escribe salir para terminar:
```

Los dos programas siguen abiertos: el de altas espera un nombre y el lector espera que pidas otra consulta.

### 3. Añadir un equipo y consultar otra vez

1. Vuelve a la primera terminal, donde pide `Nombre del equipo:`. Escribe `PC-03` y pulsa **Intro**.
2. Donde pide `RAM en GB (entero positivo):`, escribe `32` y pulsa **Intro**.
3. Comprueba que aparece `Guardado: PC-03 · 32 GB`. El programa vuelve a pedir un nombre; mantenlo abierto.
4. Vuelve a la segunda terminal y pulsa **Intro sin escribir nada**. El lector ejecutará un `SELECT` nuevo.

Si partimos de la base inicial, el nuevo listado será:

```text
ID | Nombre | RAM (GB)
1 | PC-01 | 8
2 | PC-02 | 16
3 | PC-03 | 32
Total: 3 equipos.
Intro para actualizar; escribe salir para terminar:
```

El lector **no actualiza automáticamente el texto ya impreso**: Intro hace una consulta nueva y muestra otro listado. Esta parte comprueba que el lector recupera el dato confirmado por el escritor mientras ambos programas están abiertos.

Si ya habías añadido equipos, aparecerán más filas y el id de PC-03 podrá ser mayor que 3. Eso es normal: los datos se conservan. No borres la base ni vuelvas a copiar la inicial encima para reproducir exactamente esta salida.

### 4. Cerrar y volver a abrir: comprobar persistencia

1. En la primera terminal, cuando vuelve a pedir `Nombre del equipo:`, pulsa **Intro sin escribir nada**. Debe mostrar `Programa cerrado. Los equipos permanecen en equipos.db.` y devolver el control a la terminal.
2. En la segunda terminal, escribe `salir` y pulsa **Intro**. También debe terminar y devolver el control a la terminal.
3. Ahora están cerrados los dos programas. Desde la misma copia personal, ejecuta de nuevo:

```bash
java -cp 'lib/*' S06_LeerEquipos.java
```

PC-03 con 32 GB debe seguir apareciendo. **Esta es la comprobación de persistencia:** el proceso anterior terminó y el dato se recupera del archivo `equipos.db`. Para terminar, escribe `salir` y pulsa Intro. Conserva esta copia personal si quieres recuperar tus altas otro día.

Los nombres pueden repetirse: cada alta recibe un identificador propio. La RAM debe ser un número entero positivo; si escribes texto, cero o un negativo, el programa vuelve a pedirla sin guardar esa entrada.

## Qué ocurre en el código

### JDBC en el programa de memoria

`Connection` representa la conexión. Un `Statement` envía el `CREATE TABLE` fijo. Un `PreparedStatement` contiene SQL con marcadores `?`; `setInt` y `setString` asignan los valores por posición, empezando por 1. Los valores se tratan como datos, sin concatenarlos dentro del SQL.

`executeUpdate()` ejecuta los cambios y devuelve el número de filas afectadas en un `INSERT`, `UPDATE` o `DELETE`. `executeQuery()` obtiene un `ResultSet` para un `SELECT`. `next()` avanza por las filas y `getString`/`getInt` recuperan las columnas. Cada `try` con recursos cierra los objetos que contiene al terminar; cuando se cierra la conexión de memoria, desaparece esa base. `SQLException` permite gestionar un fallo de acceso.

### Escritura en el archivo

El programa de altas abre una conexión como esta:

```java
DriverManager.getConnection("jdbc:sqlite:" + base)
```

`base` es la ruta de `equipos.db`, construida con `Path.of("equipos.db").toAbsolutePath().normalize()` a partir del directorio de trabajo. Ya no utilizamos `:memory:`. Si el archivo falta, el programa de altas puede crearlo junto con la tabla; si existe, conserva los registros. `CREATE TABLE IF NOT EXISTS` no borra ni reinicia la tabla. Para seguir la muestra de dos equipos iniciales usamos el archivo distribuido en esta carpeta.

El único `Scanner` del programa pide nombre y RAM y repite las altas hasta que el nombre queda vacío. El `INSERT` envía el nombre y la RAM mediante un `PreparedStatement`. No pide el identificador: SQLite lo asigna al omitir una columna declarada como `INTEGER PRIMARY KEY`.

JDBC mantiene el modo de **confirmación automática o autocommit** por defecto; cada alta que termina correctamente queda confirmada en el archivo y puede leerse desde la otra conexión. Por eso en este ejemplo no hay que llamar a `commit()` manualmente. Al salir del `try` se cierran la conexión y el teclado; las altas confirmadas permanecen en disco. [Confirmación automática en JDBC](https://docs.oracle.com/javase/tutorial/jdbc/basics/transactions.html).

### Lectura y nueva consulta

El lector abre `jdbc:sqlite:file:equipos.db?mode=ro`: `mode=ro` selecciona solo lectura y exige que exista el archivo. Ejecuta `SELECT id, nombre, ram FROM equipos ORDER BY id`, recorre el `ResultSet` y cierra tanto la consulta como sus resultados **antes de esperar al teclado**. Así no mantiene una consulta abierta mientras espera. Cada Intro inicia una consulta nueva, por lo que puede mostrar las altas confirmadas por el otro programa. `salir` termina el bucle y el `try` con recursos cierra la conexión y el teclado.

SQLite coordina el acceso de los dos procesos mediante bloqueos breves. Ambos programas esperan hasta cinco segundos si encuentran la base ocupada. Para esta demostración no hace falta activar WAL ni montar un servidor. Pueden aparecer brevemente archivos auxiliares como `equipos.db-journal`; no los borres mientras haya programas usando la base. [Bloqueos de SQLite](https://www.sqlite.org/lockingv3.html), [tiempo de espera](https://www.sqlite.org/pragma.html#pragma_busy_timeout).

## Librerías incluidas

- `sqlite-jdbc-3.45.3.0.jar`: controlador JDBC y motor SQLite.
- `slf4j-api-2.0.9.jar`: API de registro requerida por esta versión del controlador.
- `slf4j-simple-2.0.9.jar`: implementación sencilla de ese registro.

Son versiones concretas incluidas para reproducir el ejemplo; no es necesario descargarlas durante la clase. Su procedencia y licencias están en `lib/S06_Licencias.txt`.

Si ejecutas desde los controles de Java de VSCode, la carpeta `.vscode` declara `lib/*.jar` como librerías y fija esta carpeta como directorio de trabajo en las tres configuraciones de ejecución. Para que se aplique, abre **la copia personal de `S06_BBDD` como carpeta**, no una carpeta superior. [Gestión de librerías en VSCode](https://code.visualstudio.com/docs/java/java-project#_dependency-management).

## Si algo falla

| Mensaje o situación | Qué comprobar |
|---|---|
| `java` o `javac` no se encuentra, o la versión es anterior a 11 | Preparar el JDK con el profesor y repetir ambas comprobaciones. |
| `No suitable driver` o `NoClassDefFoundError` | Usa el comando completo con `-cp 'lib/*'` y conserva los tres JAR en `lib/`. |
| No encuentra el archivo Java o `equipos.db` | Abre la terminal en la copia de `S06_BBDD`. |
| Las altas no aparecen al actualizar | Comprueba el mensaje `Guardado`, pulsa Intro en el lector y compara las rutas de la base. Deben acceder al mismo archivo. |
| El lector no abre la base | `mode=ro` no crea el archivo: debe existir `equipos.db` con la tabla `equipos` en la carpeta de trabajo. |
| El listado tiene más filas o un id diferente | Son altas anteriores conservadas. No reinicies ni sustituyas la base personal para reproducir la muestra. |
| `database is locked` | Comprueba que ninguna otra aplicación mantiene una operación pendiente; termina esa operación y repite la consulta o el alta. |
| No puede escribir | La copia de trabajo y su carpeta deben tener permiso de escritura. |

En Windows PowerShell, los mismos tres comandos de ejecución con `-cp 'lib/*'` también sirven si el JDK está accesible como `java`.

## Diferencia comprobada

| Prueba | Qué sucede al cerrar | Cómo lo comprobamos |
|---|---|---|
| `S06_BaseDatos.java` con `:memory:` | Desaparece la base creada en RAM. | Ejecutamos dos veces: la tabla y los dos registros se crean de nuevo y la salida se repite. |
| Altas y lector con `equipos.db` | Permanecen las filas confirmadas en el archivo. | Cerramos los dos programas y abrimos de nuevo el lector: PC-03 sigue en el listado. |

Un archivo `.db` y una base en memoria son dos ubicaciones distintas para los datos. JDBC sirve para comunicarse con ambas; SQLite ejecuta el SQL en los dos casos.
