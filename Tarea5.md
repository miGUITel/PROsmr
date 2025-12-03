- [INI](#ini)
    - [**INI Funciones sin parámetros y sin return**](#ini-funciones-sin-parámetros-y-sin-return)
    - [**INI Funciones con parámetros pero sin return**](#ini-funciones-con-parámetros-pero-sin-return)
    - [**INI Funciones con parámetros y return**](#ini-funciones-con-parámetros-y-return)
- [EXTRA](#extra)
    - [EXTRA Funciones **sin parámetros** y **sin return**](#extra-funciones-sin-parámetros-y-sin-return)
    - [EXTRA Funciones **con parámetros** pero **sin return**](#extra-funciones-con-parámetros-pero-sin-return)
    - [EXTRA Funciones **con parámetros** y **return**](#extra-funciones-con-parámetros-y-return)

# INI

### **INI Funciones sin parámetros y sin return**

**1. Mostrar un saludo**

> Crea una función llamada `mostrarSaludo` que escriba en pantalla “¡Bienvenido al programa de funciones!”.
> Llama a la función desde `main` dos veces seguidas.

**2. Mostrar una línea separadora**

> Crea una función llamada `linea` que muestre en pantalla una línea de guiones (`--------------------`).
> Úsala para separar diferentes secciones del programa principal.

---

### **INI Funciones con parámetros pero sin return**

**3. Mostrar un saludo personalizado**

> Crea una función llamada `saludar` que reciba un **nombre** como parámetro y muestre en pantalla:
> `Hola, <nombre>, ¡qué gusto verte!`
> Llama a la función con tres nombres distintos.

**4. Mostrar una tabla de multiplicar**

> Crea una función llamada `mostrarTabla` que reciba un **número entero** y muestre su tabla de multiplicar del 1 al 10.
> Ejemplo de salida:
>
> ```
> 5 x 1 = 5  
> 5 x 2 = 10  
> ...
> ```

---

### **INI Funciones con parámetros y return**

**5. Calcular el doble de un número**

> Crea una función llamada `doble` que reciba un número entero y devuelva su doble.
> En `main`, pide al usuario un número, llama a la función y muestra el resultado.

**6. Devolver un mensaje personalizado**

> Crea una función llamada que reciba el nombre de un usuario.
> Debe devolver (no imprimir en consola) el mensaje "Hola Nombre bienvenido a mi casa"
> En `main`, pide al usuario un nombre y muestra por consola (ahora sí) el mensaje .

**X. Calcular el mayor de dos números (Utiliza la función Math.max)**

> Crea una función llamada `mayor` que reciba dos números enteros y devuelva el mayor de ellos.
> En el programa principal, pide al usuario dos números y muestra cuál es el mayor utilizando el valor devuelto.

# EXTRA


### EXTRA Funciones **sin parámetros** y **sin return**

1. Mostrar información del curso

> Crea una función llamada `mostrarInfoCurso` que no reciba parámetros y no devuelva nada.
> La función debe mostrar en pantalla varias líneas, por ejemplo:
>
> * Nombre del módulo
> * Nombre del profesor
> * Grupo
>   Llama a la función desde `main` al inicio del programa.

---

2. Mostrar la “cabecera” del programa

> Crea una función llamada `cabeceraPrograma` que muestre algo como:
>
> ```
> ==========================
>   PROGRAMA DE NOTAS
> ==========================
> ```
>
> No recibe parámetros ni devuelve nada.
> Llama a la función desde `main` antes de hacer cualquier otra acción.

---

### EXTRA Funciones **con parámetros** pero **sin return**

3. Mostrar la suma formateada

> Crea una función llamada `mostrarSuma` que reciba **dos números enteros** como parámetros y muestre en pantalla una frase como:
> `La suma de 7 y 3 es 10`
> La función solo muestra el resultado, no lo devuelve.
> Desde `main`, llama a la función con distintos valores (por ejemplo, `mostrarSuma(7, 3)` y `mostrarSuma(10, 25)`).

---

4. Mostrar ficha de un alumno

> Crea una función llamada `mostrarFichaAlumno` que reciba tres parámetros:
>
> * `String nombre`
> * `int edad`
> * `double notaMedia`
>   La función debe mostrar algo como:
>
> ```
> Alumno: Ana López
> Edad: 17
> Nota media: 8.5
> ```
>
> Desde `main`, llama a la función al menos dos veces con datos diferentes.

---

### EXTRA Funciones **con parámetros** y **return**

5. Calcular la media de tres notas

> Crea una función llamada `mediaTresNotas` que reciba **tres números reales** (por ejemplo, `double n1, double n2, double n3`) y **devuelva** la media de las tres.
> En `main`:
>
> 1. Pide al usuario tres notas por teclado.
> 2. Llama a la función `mediaTresNotas`.
> 3. Muestra en pantalla la media calculada.

---

6. Calcular el perímetro de un rectángulo

> Crea una función llamada `perimetroRectangulo` que reciba dos números reales: `base` y `altura`, y **devuelva** el perímetro del rectángulo (2·base + 2·altura).
> En `main`, pide al usuario la base y la altura, llama a la función y muestra el perímetro resultante.

---
