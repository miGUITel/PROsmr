# Semana 3 · Tarea 2 — **Juguemos con los datos**

**RA1 (d, e, f, g)** · Crear programas que usen **variables, constantes y operadores**
**Herramientas:** Blockly (ejercicios guiados), Scratch (variables + operadores + **entrada de datos**), JDoodle (Java con variables, **entrada de datos** y constantes)

---

## 1) Objetivos de aprendizaje

* Identificar y usar **variables** con nombres significativos (RA1.d).
* **Declarar, inicializar y modificar** variables en flujo de programa (RA1.e).
* Definir y emplear **constantes** (`final`, valores fijos en Scratch) (RA1.f).
* Aplicar **operadores** aritméticos, relacionales y lógicos simples (RA1.g).

---

## 2) Enunciado (qué vas a hacer)

Realizarás **tres mini-tareas** y entregarás evidencias de cada una.

### A) Blockly — **Explorando variables y operadores** (guiado)

1. Entra en **Blockly Games** y completa **al menos 3 niveles** en juegos donde aparezcan variables u operaciones (p. ej., **Tortuga**, **Música** o **Pájaros**).
2. En al menos **una captura**, debe verse una **variable** y un **operador** (suma, resta, comparación, etc.).
3. Escribe 2–3 líneas explicando **qué hace** esa combinación de bloques.

**Entrega A:** 1–2 capturas + breve explicación (2–3 líneas).

---

### B) Scratch — **Marcador con objetivo personalizado**

Crea un proyecto que:

1. **Variables**: `puntos` (empieza 0), `BONUS` (ej. 5; **no la modifiques** durante la ejecución), `objetivo` (lo introduce el usuario).
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

**Entrega B:** enlace/archivo del proyecto + 2 capturas (scripts y ejecución mostrando la **pregunta** y el **avance**).

---

### C) JDoodle (Java) — **Operaciones con entrada de datos**

Escribe un programa sencillo que pida dos datos y practique operadores con **nombres semánticos**.

**Requisitos:**

* Entrada por teclado con `Scanner`.
* Variables con nombres **claros** (por ej. `edad`, `cantidadDinero`).
* Una **constante** `final` (p. ej. `FACTOR`).
* Operadores: `+ - * / %`.
* Evitar división por cero.

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

    double cocienteSegunEdad = cantidadDinero / (edad == 0 ? 1 : edad); // evita /0
    int restoEdadEntreCinco = edad % 5;

    System.out.println("Edad: " + edad);
    System.out.println("Cantidad: " + cantidadDinero);
    System.out.println("Edad x2 = " + edadDoble);
    System.out.println("Cantidad + FACTOR = " + cantidadMasFactor);
    System.out.println("Cantidad / edad = " + cocienteSegunEdad);
    System.out.println("Edad % 5 = " + restoEdadEntreCinco);

    sc.close();
  }
}
```

**Entrega C:** URL de JDoodle (o el código pegado) + **captura de la ejecución** con tus propios datos.

---

## 3) Entrega (un único envío en AulaVirtual)

1. **Blockly:** 1–2 capturas + mini explicación.
2. **Scratch:** archivo/enlace + 2 capturas (scripts y ejecución).
3. **JDoodle:** enlace o código + captura de la salida.
4. **README** (5–8 líneas) indicando por mini-tarea:

   * Variables, constantes y operadores utilizados.
   * Un pequeño **problema** encontrado y cómo lo solucionaste.

---

## 4) Rúbrica de calificación (única 0 · 3 · 6 · 10)

* **0 — No entregado** o evidencias insuficientes/inlegibles.
* **3 — Entregado, no supera**: falta alguna parte (A/B/C), uso incorrecto de variables/constantes u operadores, o no reproducible.
* **6 — Supera con algún error**: A, B y C presentes; en general correcto, pero hay fallos menores (nombres poco claros, “constante” que se cambia, entradas no validadas mínimamente, README escueto).
* **10 — Supera exitosamente**: evidencias completas y claras; **nombres semánticos** adecuados; **constantes** correctas (`final` en Java; valor fijo en Scratch); **operadores** usados y justificados; entrada de datos bien integrada; README conciso con reflexión y corrección de un error.

---

## 5) Recomendaciones rápidas

* Usa **nombres significativos**: `objetivo`, `puntos`, `cantidadDinero`, `edad`.
* En Scratch, muestra las variables en pantalla mientras pruebas.
* En Java, comenta brevemente cada bloque y **prueba con varios valores** (ej.: `edad = 0`, `edad = 5`).
* Si algo no sale, anótalo en el README: **también suma** mostrar cómo lo solucionaste.


