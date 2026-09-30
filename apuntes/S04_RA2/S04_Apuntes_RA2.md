# S04 · RA2: programas sencillos y funciones

## Entrada, proceso y salida

Un programa sencillo puede analizarse mediante tres preguntas:

1. ¿Qué datos recibe?
2. ¿Qué operaciones realiza?
3. ¿Qué resultado muestra o devuelve?

Ejemplo: calcular el espacio libre de un disco.

- Entrada: capacidad total y espacio usado.
- Proceso: `total - usado`.
- Salida: espacio libre.

## Métodos

Un método agrupa instrucciones que realizan una tarea concreta.

```java
public static void mostrarCabecera() {
    System.out.println("UTILIDAD DE ALMACENAMIENTO");
}
```

`void` indica que el método no devuelve un valor. Para ejecutarlo se realiza una llamada:

```java
mostrarCabecera();
```

## Parámetros y argumentos

```java
public static void mostrarEquipo(String nombre) {
    System.out.println("Equipo: " + nombre);
}
```

`String nombre` es un parámetro. En la llamada siguiente, `"PC-AULA-04"` es el argumento:

```java
mostrarEquipo("PC-AULA-04");
```

## Valores devueltos

```java
public static double calcularEspacioLibre(double total, double usado) {
    double libre = total - usado;
    return libre;
}
```

El tipo escrito antes del nombre del método indica el tipo que devuelve. El resultado se puede guardar:

```java
double espacioLibre = calcularEspacioLibre(512, 320);
```

## Mostrar no significa devolver

`System.out.println` escribe en la consola. `return` entrega un valor al código que llamó al método.

Un método puede calcular y devolver el resultado. Después, `main` decide cómo mostrarlo.

## Librerías

Java incluye código preparado. La clase `Math` ofrece operaciones matemáticas:

```java
int mayor = Math.max(8, 16);
double raiz = Math.sqrt(81);
```

`Scanner` pertenece a otra parte de la biblioteca estándar y necesita una importación:

```java
import java.util.Scanner;
```

Usar una librería evita reescribir soluciones conocidas.

## Comentarios y documentación

```java
// Convertimos de MB a GB para mostrar una unidad más legible.
double gigabytes = megabytes / 1024.0;
```

Un comentario útil explica el motivo, una decisión o una limitación. Comentarios como `// sumamos a y b` suelen aportar poco cuando el código ya dice `a + b`.

Los nombres también documentan:

```java
public static double calcularPrecioFinal(double precioBase, double iva) {
    return precioBase * (1 + iva);
}
```

resulta más comprensible que:

```java
public static double calc(double x, double y) {
    return x * (1 + y);
}
```

## Programa completo

```java
public class EjemploFunciones {
    public static double calcularEspacioLibre(double total, double usado) {
        return total - usado;
    }

    public static void main(String[] args) {
        double libre = calcularEspacioLibre(512, 320);
        System.out.println("Espacio libre: " + libre + " GB");
    }
}
```

## Estrategia para crear una función

1. Escribir en una frase qué debe hacer.
2. Decidir qué datos necesita.
3. Decidir si devuelve un resultado.
4. Ponerle un nombre claro.
5. Probarla con valores sencillos.

El [ejemplo de métodos](../../ejemplos/S04_RA2/S04_Metodos.java) muestra una llamada con argumento y un método que devuelve un valor.

La [demostración de almacenamiento](../../ejemplos/S04_RA2/S04_Almacenamiento.java) reúne los métodos de la presentación y utiliza `Math.max` para limitar el resultado a cero. Esa limitación no sustituye la validación: si el espacio usado supera al total, los datos deben revisarse. También hay [dos ejercicios opcionales](../../ejemplos/S04_RA2/S04_Ejercicios_RA2.md).
