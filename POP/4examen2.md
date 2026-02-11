# 🧩 Examen de Recuperación — Fundamentos Java (Versión 2 revisada)

**Duración:** 100 minutos
**Nombre de los archivos:** `iniX.java` (rec1.java, rec2.java, …)
**Material permitido:** Guía de repaso en VSC, sin conexión a internet.
**Criterios:** RA1, RA2, RA3 (*Fundamentos de la Programación*)

---

## **Bloque 1: Variables, Tipos y Operadores**

### **Pregunta 1 (2 puntos) — Ficha de Evento (Estática)**

Crea un programa que declare **cuatro variables** y les asigne valores directamente en el código:

* **Nombre del evento** (texto)
* **Ciudad** (texto)
* **Aforo máximo** (entero)
* **¿Evento gratuito?** (booleano)

Muestra por pantalla la información con un formato claro y legible (varias líneas).

---

### **Pregunta 2 (2 puntos) — Cálculo de IVA (Entrada/Salida)**

Pide al usuario:

* **Nombre del producto** (texto)
* **Precio sin IVA** (número decimal)
* **Porcentaje de IVA** (entero, por ejemplo 21)

Calcula y muestra:

* el **importe del IVA**
* el **precio final con IVA**

Fórmula orientativa:

* `iva = precioSinIva * (porcentajeIva / 100.0)`
* `precioFinal = precioSinIva + iva`

La salida debe incluir el nombre del producto y los importes calculados.

---

### **Pregunta 3 (2 puntos) — Tiempo Total en Segundos (Operadores)**

Pide al usuario:

* horas (entero)
* minutos (entero)
* segundos (entero)

Calcula el **tiempo total en segundos** y muéstralo por pantalla.

---

## **Bloque 2: Estructuras de Control**

### **Pregunta 4 (2 puntos) — Tarifa de Envío (Condicionales)**

Pide al usuario el **importe de la compra** (decimal).

Según el importe, muestra la **tarifa de envío**:

* Si es **menor que 20** → “Gastos de envío: 6.99 €”
* Si está **entre 20 y 49.99** → “Gastos de envío: 3.99 €”
* Si es **50 o más** → “Gastos de envío: 0.00 € (Envío gratis)”

**Requisito extra:**
Si el importe introducido es **negativo**, muestra:

> “Error: importe no válido”

Además, muestra al final:

* el **importe de la compra**
* el **coste de envío**
* el **total final** (compra + envío)

---

### **Pregunta 5 (2 puntos) — Suma de Pares hasta Límite (Bucle While)**

Pide al usuario un **límite entero positivo**.

Usando obligatoriamente un bucle `while`, calcula la **suma de los números pares** desde 0 hasta el límite (incluyéndolo si es par).

Ejemplo si el usuario introduce 10:
0 + 2 + 4 + 6 + 8 + 10 = 30

**Requisito mínimo:** al final se debe mostrar la suma total.

---

## 📝 Guía de calificación

Cada ejercicio se valora sobre **2 puntos** (total 10).

* **0.5 puntos — Sintaxis y compilación:** compila sin errores, tipos correctos.
* **1.0 punto — Lógica y funcionamiento:**

  * P1–P3: cálculos correctos y uso adecuado de `Scanner` donde corresponda.
  * P4: rangos correctos y excluyentes + control de valor inválido + total final.
  * P5: `while` bien planteado (inicialización, condición de parada, actualización) y suma correcta.
* **0.5 puntos — Buenas prácticas y salida:** mensajes claros y salida ordenada.

---
