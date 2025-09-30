# Semana 3 · Tarea 2 — **Juguemos con los datos**

**RA1 (d, e, f, g)** · Crear programas que usen **variables, constantes y operadores**
**Herramientas:** Scratch (variables + operadores + entrada de datos), JDoodle (Java con variables, entrada de datos y constantes)

---

## 1) Objetivos de aprendizaje

* Identificar y usar **variables** con nombres significativos (RA1.d).
* **Declarar, inicializar y modificar** variables en flujo de programa (RA1.e).
* Definir y emplear **constantes** (`final` en Java; valores fijos en Scratch) (RA1.f).
* Aplicar **operadores aritméticos** básicos (`+ - * / %`) (RA1.g).

---

## 2) Enunciado (qué vas a hacer)

Realizarás **dos mini-tareas** y entregarás evidencias de cada una.

### A) Scratch — **Marcador con objetivo personalizado**

Crea un proyecto que:

1. **Variables**: `puntos` (empieza 0), `BONUS` (ej. 5; **no se modifica** durante la ejecución), `objetivo` (lo introduce el usuario).
2. **Al pulsar bandera verde**:

   * `establecer puntos a 0`
   * `establecer BONUS a 5`
   * `preguntar "¿Cuál es el objetivo de puntos?" y esperar`
   * `establecer objetivo a (respuesta)`
3. **Controles**:

   * Tecla **espacio** → `cambiar puntos por 1`.
   * Tecla **b** → `cambiar puntos por BONUS`.
4. **Condición** (después de cada cambio):

   * `si (puntos ≥ objetivo) → decir "¡Meta alcanzada!" 2 seg`.
5. **Mostrar** en pantalla `puntos` y `objetivo`.

**Entrega A:** archivo/enlace del proyecto + 2 capturas (scripts y ejecución mostrando la pregunta y el avance de puntos).

---

### B) JDoodle (Java) — **Operaciones con entrada de datos**

Escribe un programa sencillo que pida datos y practique operadores con **nombres semánticos**.

**Requisitos:**

* Entrada por teclado con `Scanner`.
* Variables con nombres **claros** (ej. `edad`, `cantidadDinero`).
* Una **constante** `final` (`FACTOR`).
* Operadores: `+ - * / %`.

**Código base recomendado (puedes adaptarlo):**

```java
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Introduce tu edad: ");
    int edad = sc.nextInt();

    System.out.print("Introduce una cantidad de dinero: ");
    double cantidadDinero = sc.nextDouble();

    final double FACTOR = 2.0; // constante de ejemplo

    int edadDoble = edad * 2;
    double cantidadMasFactor = cantidadDinero + FACTOR;

    double cociente = cantidadDinero / edad;
    int restoEdadEntreCinco = edad % 5;

    System.out.println("Edad: " + edad);
    System.out.println("Cantidad: " + cantidadDinero);
    System.out.println("Edad x2 = " + edadDoble);
    System.out.println("Cantidad + FACTOR = " + cantidadMasFactor);
    System.out.println("Cantidad / edad = " + cociente);
    System.out.println("Edad % 5 = " + restoEdadEntreCinco);

    sc.close();
  }
}
```

**Entrega B:** URL de JDoodle (o el código pegado) + **captura de la ejecución** con tus propios datos.

---

## 3) Entrega (un único envío en Classroom/Moodle)

1. **Scratch:** archivo/enlace + 2 capturas.
2. **JDoodle:** enlace o código + captura de la salida.
3. **README** (5–8 líneas) indicando:

   * Variables, constantes y operadores utilizados en cada mini-tarea.
   * Un pequeño **problema** encontrado y cómo lo solucionaste.

---

## 4) Rúbrica de calificación (única 0 · 3 · 6 · 10)

* **0 — No entregado** o evidencias insuficientes.
* **3 — Entregado, no supera**: falta una de las dos partes, variables/constantes u operadores incorrectos, o sin pruebas.
* **6 — Supera con algún error**: ambas partes entregadas; en general correcto, pero con fallos menores (nombres poco claros, constante mal usada, README escueto).
* **10 — Supera exitosamente**: evidencias completas y claras; nombres de variables significativos; constante bien definida (`final` en Java, valor fijo en Scratch); operadores aplicados correctamente; entrada de datos bien integrada.
