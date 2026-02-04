# 🧩 Examen de Fundamentos Java: Variables, Operadores, Condicionales y Bucles

**Duración:** 100 minutos
**Nombre de los archivos:** `inix.java` (mtm1.java, mtm2.java, ...)
**Material permitido:** Guía de repaso en VSC, sin conexión a internet.
**Criterios:** RA1, RA2, RA3 (*Fundamentos de la Programación*)

---

## **Bloque 1: Variables, Tipos y Operadores**

### **Pregunta 1 (2 puntos) — Ficha de Producto (Estática)**

Crea un programa que declare **cuatro variables** para guardar la información de un producto en un inventario (no debes pedir nada por teclado, asigna los valores tú mismo en el código):

* **Nombre** del producto (texto).
* **Precio** (número decimal).
* **Cantidad** en stock (número entero).
* **¿Está en oferta?** (valor booleano: `true` o `false`).

Muestra por pantalla una frase que combine estos datos de forma legible.

**Ejemplo de salida:**

```text
Producto: Zapatillas Deportivas
Precio: 45.99 € | Stock: 12 unidades
¿En oferta?: true

```

---

### **Pregunta 2 (2 puntos) — Calculadora de Nómina (Entrada/Salida)**

Pide al usuario los siguientes datos por teclado:

* **Nombre** del empleado.
* **Horas trabajadas** (número entero).
* **Precio por hora** (número decimal).

Calcula el **salario bruto** multiplicando las horas por el precio. Muestra un mensaje final con el nombre y el total calculado.

**Ejemplo de salida:**

```text
Introduce tu nombre: Carlos
Horas trabajadas: 40
Precio por hora: 12.5
-----------------------------------
Hola Carlos, tu salario bruto es 500.0 euros.

```

---

### **Pregunta 3 (2 puntos) — Calculadora de Nota Media (Operadores)**

Pide al usuario las **tres notas** (con decimales) que ha obtenido en sus exámenes del trimestre.

Calcula la **nota media** exacta y muéstrala por pantalla.
*Nota: Recuerda utilizar paréntesis para controlar el orden de las operaciones.*

**Ejemplo de salida:**

```text
Nota 1: 6.5
Nota 2: 8.0
Nota 3: 9.5
-----------------------------------
La nota media del trimestre es: 8.0

```

---

## **Bloque 2: Estructuras de Control**

### **Pregunta 4 (2 puntos) — Sistema de Calificaciones (Condicionales)**

Pide al usuario una **nota numérica** (decimal) entre 0 y 10.

Utilizando una estructura condicional (`if` / `else if`), clasifica la nota según la siguiente tabla y muestra el mensaje correspondiente:

* **Menor que 5:** "Insuficiente"
* **Entre 5 y 6.9:** "Bien"
* **Entre 7 y 8.9:** "Notable"
* **De 9 en adelante:** "Sobresaliente"

**Requisito extra:** Si el usuario introduce una nota negativa o mayor que 10, el programa debe mostrar: "Error: Nota no válida".

**Ejemplo de salida:**

```text
Introduce la nota: 7.5
Calificación: Notable

```

---

### **Pregunta 5 (2 puntos) — Contador de Pasos (Bucle While)**

Pide al usuario un **número objetivo** (por ejemplo, 50).

Utilizando obligatoriamente un bucle `while`, muestra una secuencia de números que empiece en **0** y vaya aumentando **de 5 en 5** hasta llegar (o superar ligeramente) al número introducido por el usuario.

**Ejemplo de salida (Usuario introduce 23):**

```text
Objetivo: 23
Secuencia:
0
5
10
15
20
25

```

---

# 📝 Guía de calificación (Rúbrica)

Cada pregunta se valora sobre **2 puntos**. La suma total es 10.

#### **Criterios generales para cada ejercicio:**

* **0.5 puntos — Sintaxis y Compilación:**
El código no tiene errores de sintaxis y compila a la primera. Las variables están declaradas con el tipo de dato correcto (`int`, `double`, `boolean`, `String`) según la naturaleza del dato.
* **1.0 punto — Lógica y Funcionamiento:**
* **P1-P3:** Realiza las operaciones matemáticas correctamente y usa `Scanner` adecuadamente.
* **P4:** Los rangos del `if/else` son correctos y excluyentes. Controla el error de nota inválida.
* **P5:** El bucle `while` inicializa correctamente, tiene la condición de parada adecuada y el incremento es correcto (+5).


* **0.5 puntos — Buenas prácticas y Salida:**
El código es legible. Los mensajes por pantalla son claros, coinciden con el ejemplo y tienen un formato amigable para el usuario.