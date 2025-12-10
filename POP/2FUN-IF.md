# 🧩 Ejercicio repaso Java — Variables, Operaciones, Entrada/Salida, **Funciones** y **Condicionales**

**Duración:** 60 minutos
**Nombre del archivo:** `ApellidoNombre_examenX.java` (cambia X por el número de ejercicio)
**Material permitido:** guía de repaso en VSC, sin conexión a internet.
**Criterios:** RA1.d–h, RA2.a–f, RA3.a y RA3.f (*Fundamentos de la Programación*, SMR)

---

## **Pregunta 1 (3 puntos)**

### **Calculadora de IMC con clasificación**

Pide al usuario:

* su **peso** en kg (decimal)
* su **altura** en metros (decimal)

Crea una **función** que reciba peso y altura y devuelva el **IMC**, usando la fórmula:

```
IMC = peso / (altura * altura)
```

Después, utiliza un **condicional** para clasificar el resultado:

* IMC < 18.5 → *Bajo peso*
* 18.5–24.9 → *Normal*
* 25.0–29.9 → *Sobrepeso*
* ≥ 30 → *Obesidad*

Ejemplo de salida:

```
Tu IMC es 22.86
Clasificación: Normal
```

---

## **Pregunta 2 (3 puntos)**

### **Análisis simple de un número**

Pide al usuario un **número entero**.

Crea **tres funciones**, cada una devolviendo un booleano:

* `esPar(int n)`
* `esPositivo(int n)`
* `esMultiploDe3(int n)`

Utiliza estas funciones dentro de condicionales para mostrar un análisis como:

```
Número analizado: 18
Es par: sí
Es positivo: sí
Es múltiplo de 3: sí
```

**Pista:** puedes usar funciones dentro de un `if`. Por ejemplo:

```
if (esPar(2)) { ... }
```

---

## **Pregunta 3 (3 puntos)**

### **Estimación de tiempo de descarga según la calidad de la conexión**

Pide al usuario:

* el **tamaño del archivo** en MB (decimal)
* el **tipo de conexión** (texto): “rápida”, “media”, “lenta”

Crea una función que, según el tipo de conexión, devuelva la **velocidad** en Mbps:

* rápida → 50 Mbps
* media → 15 Mbps
* lenta → 5 Mbps

Crea otra función que calcule el **tiempo estimado de descarga en segundos**, usando tamaño y velocidad.

**Nota:** deja el resultado final **solo en segundos**, sin convertirlo a minutos.

Ejemplo de salida:

```
Tamaño del archivo: 1200 MB
Conexión: media (15 Mbps)
Tiempo estimado: 640 segundos
```

---

# 📝 **Guía de calificación (para cada pregunta)**

Cada pregunta vale **3 puntos**, distribuidos así:

### ✔ **1 punto — Comentarios en el código**

El alumno explica brevemente qué hace cada parte del programa:
declaración de variables, lectura de datos, funciones creadas, uso de condicionales y salida final.

### ✔ **1 punto — Código que responde al enunciado**

Incluye todas las funciones, variables, condicionales y operaciones requeridas, siguiendo exactamente las reglas del ejercicio.

### ✔ **1 punto — Funcionamiento correcto**

El programa compila, ejecuta correctamente y muestra resultados coherentes con los ejemplos.
