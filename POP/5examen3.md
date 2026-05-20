# Examen final — Fundamentos de Programación en Java

**Duración:** 100 minutos
**Nombre de los archivos:** `ApellidoNombre_pregunta1.java`, `ApellidoNombre_pregunta2.java`, etc.
**Material permitido:** guía de repaso en VSC, sin conexión a internet.
**Puntuación total:** 10 puntos

---

### Pregunta 1 — Ficha de un dispositivo informático

**2 puntos**

Crea un programa que declare variables y les dé valor directamente en el código, sin pedir datos por teclado.

Debes guardar la información de un dispositivo informático:

* nombre del dispositivo
* marca
* memoria RAM en GB
* precio
* si está encendido o apagado

Después, muestra todos los datos por pantalla con frases claras.

Ejemplo de salida:

```text
Dispositivo: Portátil
Marca: Lenovo
Memoria RAM: 16 GB
Precio: 699.99 euros
¿Está encendido?: true
```

Se valorará:

* uso correcto de tipos de datos adecuados
* declaración y asignación correcta de variables
* salida clara por pantalla

---

### Pregunta 2 — Nivel de batería

**3 puntos**

Crea un programa que pida al usuario el porcentaje de batería de un dispositivo.

El porcentaje será un número entero entre 0 y 100.

Según el valor introducido, el programa debe mostrar uno de estos mensajes:

* Si la batería es menor que 0 o mayor que 100:
  `Error: porcentaje no válido`

* Si la batería está entre 0 y 19:
  `Batería baja. Carga el dispositivo.`

* Si la batería está entre 20 y 79:
  `Batería suficiente.`

* Si la batería está entre 80 y 100:
  `Batería alta.`

Ejemplo de salida:

```text
Introduce el porcentaje de batería: 15
Batería baja. Carga el dispositivo.
```

Otro ejemplo:

```text
Introduce el porcentaje de batería: 120
Error: porcentaje no válido
```

Se valorará:

* uso correcto de `Scanner`
* uso adecuado de `if / else if / else`
* rangos bien planteados
* control de valores no válidos

---

### Pregunta 3 — Cuenta atrás para apagar el equipo

**2,5 puntos**

Crea un programa que pida al usuario un número entero positivo.

Usando obligatoriamente un bucle `while`, el programa debe mostrar una cuenta atrás desde ese número hasta 0.

Al final debe mostrar el mensaje:

```text
Equipo apagado.
```

Ejemplo de salida:

```text
Introduce los segundos para apagar: 5
5
4
3
2
1
0
Equipo apagado.
```

Si el usuario introduce un número negativo, el programa debe mostrar:

```text
Error: el número debe ser positivo.
```

Se valorará:

* uso obligatorio de `while`
* inicialización correcta de la variable de control
* condición de parada correcta
* actualización correcta dentro del bucle
* control básico de número negativo

---

### Pregunta 4 — Funciones para calcular el precio de entradas

**2,5 puntos**

Crea un programa que pida al usuario:

* nombre del cliente
* número de entradas
* precio de una entrada

Debes crear una función llamada `calcularTotal` que reciba:

```java
int numeroEntradas
double precioEntrada
```

y devuelva el precio total.

Después, en el `main`, muestra un resumen con el nombre del cliente, el número de entradas y el total a pagar.

Ejemplo de salida:

```text
Introduce el nombre del cliente: Laura
Introduce el número de entradas: 3
Introduce el precio de una entrada: 7.5

Cliente: Laura
Entradas: 3
Total a pagar: 22.5 euros
```

La función debe tener una estructura similar a esta:

```java
public static double calcularTotal(int numeroEntradas, double precioEntrada) {
    // código de la función
}
```

Se valorará:

* creación correcta de la función
* uso correcto de parámetros
* uso correcto de `return`
* llamada a la función desde `main`
* salida clara por pantalla

---

## Rúbrica de calificación

| Pregunta   |                             Contenido principal |    Puntuación |
| ---------- | ----------------------------------------------: | ------------: |
| Pregunta 1 | Variables, tipos de datos y salida por pantalla |      2 puntos |
| Pregunta 2 |             Entrada por teclado y condicionales |      3 puntos |
| Pregunta 3 |                                   Bucle `while` |    2,5 puntos |
| Pregunta 4 |             Funciones con parámetros y `return` |    2,5 puntos |
| **Total**  |                                                 | **10 puntos** |

### Criterios generales

En todos los ejercicios se valorará:

* **40% — Compilación correcta**
  El programa no presenta errores de sintaxis y puede ejecutarse.

* **40% — Funcionamiento correcto**
  El programa resuelve lo que pide el enunciado y muestra resultados coherentes.

* **20% — Claridad, orden y presentación del código**
  Se usan nombres de variables comprensibles, los mensajes por pantalla son claros, el código está ordenado y se añaden comentarios básicos explicando las partes principales del programa.

---

### Penalizaciones orientativas

* **No usar `while` en la pregunta 3:** no se puede obtener la parte principal de ese ejercicio.

* **No crear una función en la pregunta 4:** no se puede obtener la parte principal de ese ejercicio.

* **Rangos mal planteados en la pregunta 2:** penalización según la gravedad del error.
