# RA1: elementos de un programa Java

## Estructura mínima

```java
public class Ejemplo {
    public static void main(String[] args) {
        System.out.println("Programa en ejecución");
    }
}
```

Una clase contiene código. El método `main` marca el inicio. Las llaves delimitan bloques y el punto y coma termina muchas instrucciones.

## Identificadores y palabras reservadas

Un **identificador** es un nombre elegido por el programador, como `memoriaRam` o `precioEquipo`.

Reglas útiles:

- No puede contener espacios.
- No puede empezar por un número.
- Java distingue mayúsculas y minúsculas.
- No puede ser una palabra reservada como `class`, `int` o `public`.

Usaremos `camelCase` para variables y métodos: `espacioLibre`. Las constantes usarán mayúsculas: `IVA`.

## Tipos básicos

| Tipo | Guarda | Ejemplo |
|---|---|---|
| `int` | Números enteros | `int puertos = 8;` |
| `double` | Números con decimales | `double precio = 19.95;` |
| `boolean` | Verdadero o falso | `boolean encendido = true;` |
| `char` | Un carácter | `char unidad = 'C';` |
| `String` | Texto | `String equipo = "PC-AULA-01";` |

`String` se escribe con comillas dobles. `char` utiliza comillas simples.

## Variables

```java
int memoriaRam = 8;       // Declaración e inicialización
memoriaRam = 16;          // Modificación
```

Una variable tiene nombre, tipo y valor. El valor puede cambiar si el nuevo valor es compatible con el tipo.

## Constantes y literales

```java
final double IVA = 0.21;
```

`IVA` es una constante y no se puede reasignar. En esa instrucción, `0.21` es un literal escrito directamente en el código.

Otros literales son `25`, `true`, `'A'` y `"admin"`.

## Operadores

```java
int total = unidades * precioUnitario;
int resto = capacidad % tamañoBloque;
boolean quedaEspacio = espacioLibre > 0;
```

- Aritméticos: `+`, `-`, `*`, `/`, `%`.
- Comparación: `==`, `!=`, `<`, `>`, `<=`, `>=`.
- Lógicos: `&&`, `||`, `!`.
- Asignación: `=` y formas abreviadas como `+=`.

Una expresión combina valores, variables y operadores para producir un resultado.

## Conversiones

### Conversión implícita

Java puede pasar de `int` a `double` sin perder información:

```java
int gigabytes = 8;
double capacidad = gigabytes;
```

### Casting

Para pasar de `double` a `int` debemos indicarlo. La parte decimal se pierde:

```java
double medida = 7.9;
int parteEntera = (int) medida; // 7
```

### Texto y número

```java
String texto = "16";
int numero = Integer.parseInt(texto);

String salida = String.valueOf(numero);
```

Si el texto no representa un entero, `Integer.parseInt` produce un error. Más adelante aprenderemos a controlarlo.

## División entera

```java
int resultado1 = 5 / 2;       // 2
double resultado2 = 5.0 / 2;  // 2.5
```

Cuando ambos operandos son enteros, Java realiza una división entera.

## Resumen

Antes de crear una variable, debemos preguntarnos qué dato guardará. Después elegimos un nombre y un tipo. Finalmente, mostramos el resultado para comprobar que las operaciones y conversiones producen lo esperado.

