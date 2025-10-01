# Guía de repaso: Variables, Operaciones, Entrada/Salida y Conversiones en Java

## 1. Variables y tipos de datos básicos

Las variables almacenan información que el programa necesita usar.
Tipos básicos trabajados:

* `int`: números enteros.
* `double`: números decimales.
* `String`: texto.
* `char`: un solo carácter.

**Ejemplo en Java:**

```java
int edad = 20;
double precio = 9.99;
String nombre = "Ana";
char inicial = 'A';
```

---

## 2. Operaciones básicas

Podemos operar con los datos guardados en las variables.

* Aritmética: `+`, `-`, `*`, `/`
* Concatenación de texto: `+`

**Ejemplo en Java:**

```java
int suma = 5 + 3;          // 8
double division = 10 / 4.0; // 2.5
String saludo = "Hola " + nombre; // "Hola Ana"
```

---

## 3. Entrada y salida de datos

* **Salida**: mostrar por consola.
* **Entrada**: leer datos del usuario con `Scanner`.

**Ejemplo en Java:**

```java
import java.util.Scanner;

Scanner sc = new Scanner(System.in);

System.out.print("Introduce tu edad: ");
int edad = sc.nextInt();

System.out.println("Tienes " + edad + " años.");
```

---

## 4. Conversiones básicas

A veces es necesario transformar datos de un tipo a otro.

**Ejemplo en Java:**

```java
// int → double
int n = 5;
double d = (double) n; // 5.0

// double → int
double x = 7.9;
int y = (int) x; // 7

// String → int
String texto = "42";
int numero = Integer.parseInt(texto);

// int → String
int valor = 100;
String cadena = String.valueOf(valor);
```

---

¿Quieres que prepare esto en **versión “guía visual”** con cuadros resaltados (ejemplo + resultado esperado) para que los alumnos lo tengan aún más claro?
