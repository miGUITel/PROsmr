# Examen de recuperación — Fundamentos de Programación en Java

**Duración:** 100 minutos
**Nombre de los archivos:** `ApellidoNombre_pregunta1.java`, `ApellidoNombre_pregunta2.java`, `ApellidoNombre_pregunta3.java`, `ApellidoNombre_pregunta4.java`
**Material permitido:** guía de repaso en VSC, sin conexión a internet.
**Puntuación total:** 10 puntos

---

## Pregunta 1 — Ficha de un libro

**2 puntos**

Crea un programa que declare variables y les dé valor directamente en el código, **sin pedir datos por teclado**.

Debes guardar la información de un libro:

* título
* autor
* número de páginas
* precio
* si está prestado o no

Después, muestra todos los datos por pantalla con frases claras.

Ejemplo de salida:

```text
Título: El camino
Autor: Miguel Delibes
Páginas: 256
Precio: 12.95 euros
¿Está prestado?: false
```

Se valorará:

* uso correcto de tipos de datos: `String`, `int`, `double`, `boolean`
* declaración y asignación correcta de variables
* salida clara por pantalla

---

## Pregunta 2 — Clasificación de temperatura

**3 puntos**

Crea un programa que pida al usuario una temperatura en grados Celsius.

Según el valor introducido, el programa debe mostrar uno de estos mensajes:

* Si la temperatura es menor que 0:
  `Hace frío intenso`

* Si la temperatura está entre 0 y 15:
  `Hace frío`

* Si la temperatura está entre 16 y 25:
  `Temperatura agradable`

* Si la temperatura está entre 26 y 35:
  `Hace calor`

* Si la temperatura es mayor que 35:
  `Hace mucho calor`

Ejemplo de salida:

```text
Introduce la temperatura: 22
Temperatura agradable
```

Otro ejemplo:

```text
Introduce la temperatura: -3
Hace frío intenso
```

Se valorará:

* uso correcto de `Scanner`
* uso adecuado de `if / else if / else`
* rangos bien planteados
* salida clara por pantalla

---

## Pregunta 3 — Mostrar números impares hacia atrás

**2,5 puntos**

Crea un programa que pida al usuario un número entero positivo.

Usando obligatoriamente un bucle `while`, el programa debe mostrar los números impares desde el número introducido por el usuario hasta 0.

Si el número introducido es par, no debe mostrarse ese número, sino empezar por el impar anterior.

Si el usuario introduce un número menor que 1, el programa debe mostrar:

```text
Error: el número debe ser mayor o igual que 1.
```

Ejemplo de salida:

```text
Introduce un número: 9
Números impares desde 9 hasta 0:
9
7
5
3
1
```

Otro ejemplo:

```text
Introduce un número: 8
Números impares desde 8 hasta 0:
7
5
3
1
```

Se valorará:

* uso obligatorio de `while`
* inicialización correcta de la variable de control
* condición de parada correcta
* actualización correcta dentro del bucle
* control básico de número no válido

---

## Pregunta 4 — Función para calcular el doble de un número

**2,5 puntos**

Crea un programa que pida al usuario:

* su nombre
* un número entero

Debes crear una función llamada `calcularDoble` que reciba un número entero y devuelva su doble.

Después, en el `main`, llama a la función y muestra un mensaje con el nombre del usuario, el número introducido y su doble.

Ejemplo de salida:

```text
Introduce tu nombre: Ana
Introduce un número: 6

Ana, el doble de 6 es 12
```

Se valorará:

* creación correcta de la función
* uso correcto de parámetros
* uso correcto de `return`
* llamada a la función desde `main`
* salida clara por pantalla

---

# Rúbrica de calificación

| Pregunta   |                             Contenido principal |    Puntuación |
| ---------- | ----------------------------------------------: | ------------: |
| Pregunta 1 | Variables, tipos de datos y salida por pantalla |      2 puntos |
| Pregunta 2 |             Entrada por teclado y condicionales |      3 puntos |
| Pregunta 3 |                                   Bucle `while` |    2,5 puntos |
| Pregunta 4 |             Funciones con parámetros y `return` |    2,5 puntos |
| **Total**  |                                                 | **10 puntos** |

---

# Criterios generales

En todos los ejercicios se valorará:

* **40% — Compilación correcta**
  El programa no presenta errores de sintaxis y puede ejecutarse.

* **40% — Funcionamiento correcto**
  El programa resuelve lo que pide el enunciado y muestra resultados coherentes.

* **20% — Claridad, orden y presentación del código**
  Se usan nombres de variables comprensibles, los mensajes por pantalla son claros, el código está ordenado y se añaden comentarios básicos explicando las partes principales del programa.

---

# Penalizaciones orientativas

* **No usar `while` en la pregunta 3:** no se puede obtener la parte principal de ese ejercicio.

* **No crear una función en la pregunta 4:** no se puede obtener la parte principal de ese ejercicio.

* **Rangos mal planteados en la pregunta 2:** penalización según la gravedad del error.
