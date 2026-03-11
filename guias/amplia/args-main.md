### ¿Qué es `args` en Java?

En Java, el método principal de un programa tiene esta forma:

```java
public static void main(String[] args)
```

El parámetro `args` es un **array de cadenas (`String[]`)** que contiene los **argumentos que el usuario escribe en la línea de comandos al ejecutar el programa**.

Cuando ejecutamos un programa desde la terminal podemos añadir datos después del nombre de la clase. Esos datos **Java los recoge automáticamente y los guarda en `args`**.

Ejemplo de ejecución:

```bash
java Programa hola 25 rojo
```

En ese caso Java construye el array:

```
args[0] = "hola"
args[1] = "25"
args[2] = "rojo"
```

Aspectos importantes:

* `args` es un **array de Strings**.
* Cada palabra escrita en la terminal se guarda en una posición.
* `args.length` indica cuántos argumentos se han recibido.

Este mecanismo permite crear programas que **reciben datos desde la terminal**, algo muy habitual en herramientas y scripts.

---

# Ejemplo mínimo: sumar dos números recibidos como argumentos

Programa:

```java
public class SumaArgs {

    public static void main(String[] args) {

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        int suma = a + b;

        System.out.println("Resultado: " + suma);
    }
}
```

---

### Compilar el programa

```bash
javac SumaArgs.java
```

---

### Ejecutar el programa

```bash
java SumaArgs 3 5
```

Salida:

```
Resultado: 8
```

En este caso:

```
args[0] = "3"
args[1] = "5"
```

Como `args` contiene **cadenas**, utilizamos `Integer.parseInt()` para convertirlas a números antes de sumarlas.
