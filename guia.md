# Guía de repaso: Variables, Operaciones, Entrada/Salida y Conversiones en Java

## 1. Crear variables con su tipo y darles un valor

En Java, **todas las variables deben tener un tipo**.
El tipo indica qué tipo de dato puede guardar la variable (número, texto, letra…).

| Tipo     | Qué guarda                      | Ejemplo de declaración     |
| -------- | ------------------------------- | -------------------------- |
| `int`    | Números enteros (sin decimales) | `int edad = 20;`           |
| `double` | Números con decimales           | `double nota = 8.5;`       |
| `String` | Textos o palabras               | `String nombre = "Laura";` |
| `char`   | Una sola letra o símbolo        | `char inicial = 'L';`      |

📌 **Recuerda:**

* Los textos van entre **comillas dobles (" ")**.
* Las letras (`char`) van entre **comillas simples (' ')**.
* Cada línea termina con **punto y coma (;)**.

🧩 **Ejemplo:**

```java
int edad = 20;
double nota = 8.5;
String nombre = "Laura";
char inicial = 'L';
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

## 3. Pedir datos al usuario (entrada por teclado)

Para leer datos que escribe el usuario, usamos un **objeto de tipo `Scanner`**.

1. Primero se **importa** la clase:

   ```java
   import java.util.Scanner;
   ```
2. Luego se **crea el objeto**:

   ```java
   Scanner sc = new Scanner(System.in);
   ```
3. Y después se **piden los datos** con diferentes métodos según el tipo:

| Tipo de dato | Método             | Ejemplo                               |
| ------------ | ------------------ | ------------------------------------- |
| `int`        | `nextInt()`        | `int edad = sc.nextInt();`            |
| `double`     | `nextDouble()`     | `double nota = sc.nextDouble();`      |
| `String`     | `nextLine()`       | `String nombre = sc.nextLine();`      |
| `char`       | `next().charAt(0)` | `char inicial = sc.next().charAt(0);` |


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


🧩 **Ejemplo completo:**

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce tu edad: ");
        int edad = sc.nextInt();

        System.out.print("Introduce tu nota: ");
        double nota = sc.nextDouble();

        sc.nextLine(); // limpia el salto de línea pendiente

        System.out.print("Introduce tu nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Introduce la inicial de tu nombre: ");
        char inicial = sc.next().charAt(0);

        System.out.println("\n--- Datos introducidos ---");
        System.out.println("Edad: " + edad);
        System.out.println("Nota: " + nota);
        System.out.println("Nombre: " + nombre);
        System.out.println("Inicial: " + inicial);
    }
}
```

📤 **Ejecución típica:**

```
Introduce tu edad: 20
Introduce tu nota: 8.5
Introduce tu nombre: Laura
Introduce la inicial de tu nombre: L

--- Datos introducidos ---
Edad: 20
Nota: 8.5
Nombre: Laura
Inicial: L
```

