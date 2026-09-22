# Sesión 1: una primera mirada a la programación

## Problema, algoritmo y programa

Un **problema** describe algo que queremos resolver. Por ejemplo: calcular cuánto espacio libre queda en un disco.

Un **algoritmo** es una lista ordenada y finita de pasos para resolverlo:

1. Leer la capacidad total.
2. Leer el espacio usado.
3. Restar el espacio usado a la capacidad total.
4. Mostrar el espacio libre.

Un **programa** expresa esos pasos en un lenguaje que el ordenador puede procesar.

## Los datos

Los programas reciben, guardan y transforman datos. En el ejemplo anterior, la capacidad total y el espacio usado son datos de entrada. El espacio libre es un dato calculado.

## Lenguajes de programación

Un lenguaje de programación tiene reglas y palabras propias. Java diferencia mayúsculas y minúsculas. También exige símbolos como llaves, paréntesis y punto y coma.

No necesitamos memorizar todas las reglas al principio. Aprenderemos a:

- Leer ejemplos cortos.
- Ejecutarlos.
- Cambiar una parte.
- Comprobar el resultado.
- Interpretar los errores.

## Código fuente, compilación y ejecución

El **código fuente** es el texto que escribe el programador. En Java se guarda normalmente en archivos `.java`.

La **compilación** comprueba la sintaxis y transforma el código para que pueda ejecutarse en la máquina virtual de Java.

La **ejecución** pone en marcha el programa.

## Primer programa

```java
public class S01_HolaSMR {
    public static void main(String[] args) {
        System.out.println("Hola, SMR");
    }
}
```

Por ahora basta con reconocer:

- `class`: define una clase.
- `main`: señala el punto por el que empieza la ejecución.
- `System.out.println`: muestra información en la consola.
- Las llaves agrupan instrucciones.
- El punto y coma termina una instrucción.

## VSCode y GitHub

Usaremos **VSCode** para leer, modificar, ejecutar y depurar programas.

Usaremos **GitHub** para distribuir los materiales y observar cómo evoluciona el curso. El profesor publica los cambios y el alumnado actualiza su copia mediante `pull`. Las prácticas se copian y se realizan fuera del repositorio; las entregas se realizan mediante Moodle. El alumnado no necesita hacer `commit` ni `push`.

## Idea importante

Programar incluye equivocarse, observar qué ocurre y corregir. Un mensaje de error aporta una pista sobre el problema.
