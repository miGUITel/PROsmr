# S05 · RA3: decisiones, repeticiones y errores

## El orden de ejecución

Por defecto, Java ejecuta las instrucciones de un bloque en orden. Una estructura de control permite elegir qué instrucciones ejecutar o repetirlas. Seguiremos tres preguntas: qué condición se comprueba, qué bloque se ejecuta y qué valor cambia.

## Selección con `if` y `else`

```java
int ocupacion = 85;
if (ocupacion >= 85) {
    System.out.println("Revisar espacio");
} else {
    System.out.println("Espacio suficiente");
}
```

La condición debe producir `true` o `false`. Cuando es verdadera, se ejecuta el primer bloque; cuando es falsa, se ejecuta el de `else`. El valor 85 entra en el primer bloque porque `>=` incluye la igualdad. `else` es opcional.

Para distinguir más casos podemos encadenar condiciones:

```java
if (ocupacion >= 95) {
    System.out.println("Critico");
} else if (ocupacion >= 85) {
    System.out.println("Aviso");
} else {
    System.out.println("Normal");
}
```

En una cadena se ejecuta solo el primer bloque cuya condición sea verdadera. Por eso comprobamos antes el caso más restrictivo. Varias instrucciones `if` independientes sí pueden ejecutar varios bloques.

## Condiciones y comparación

`==` compara valores numéricos y `=` asigna un valor. Para combinar condiciones utilizamos `&&` (ambas verdaderas), `||` (al menos una verdadera) y `!` (negación).

```java
boolean admiteInstalacion = memoriaRam >= 8 && espacioLibre >= 20;
```

Para comparar el contenido de textos usamos `equals`, por ejemplo `"admin".equals(usuario)`. `==` no comprueba el contenido de dos objetos `String`.

## Selección con `switch`

`switch` resulta útil para elegir entre valores concretos, como opciones de un menú:

```java
switch (opcion) {
    case 1:
        System.out.println("Consultar equipo");
        break;
    case 2:
        System.out.println("Revisar disco");
        break;
    default:
        System.out.println("Opcion desconocida");
}
```

En esta sintaxis, `break` termina el `switch`. Si falta, la ejecución puede continuar por el caso siguiente. `default` recoge los valores sin un caso específico. Existen otras sintaxis de `switch`; aquí utilizamos esta para leer sus pasos con claridad.

Abre [S05_Seleccion.java](../../ejemplos/S05_RA3/S05_Seleccion.java) y predice los mensajes antes de ejecutarlo.

## Repetición con `while`

```java
int pendientes = 3;
while (pendientes > 0) {
    System.out.println(pendientes);
    pendientes--;
}
```

`while` comprueba la condición antes de cada vuelta. Este ejemplo muestra 3, 2 y 1. Después, `pendientes` vale 0 y el bucle termina. Si el valor inicial fuera 0, no ejecutaría el cuerpo ninguna vez. Si olvidamos actualizar `pendientes`, la condición seguirá siendo verdadera y tendremos un bucle infinito.

## Repetición con `for`

```java
for (int equipo = 1; equipo <= 3; equipo++) {
    System.out.println("Equipo " + equipo);
}
```

La cabecera reúne la inicialización, la condición y la actualización. La inicialización ocurre una vez; la condición se revisa antes de cada vuelta y la actualización se realiza después del cuerpo. Aquí se muestran los equipos 1, 2 y 3. Cambiar `<=` por `<` excluiría el 3.

## Repetición con `do-while`

```java
int intentos = 0;
do {
    System.out.println("Primera comprobacion");
    intentos++;
} while (intentos < 0);
```

`do-while` comprueba la condición al final, así que ejecuta el cuerpo al menos una vez. El ejemplo muestra el mensaje una vez, aunque la condición final sea falsa. Observa el punto y coma después del `while`.

## Saltos: `break`, `continue` y `return`

- `break` termina el bucle más cercano o el `switch` correspondiente.
- `continue` omite lo que queda de la vuelta actual y continúa con la siguiente. En un `for`, se realiza la actualización de la cabecera antes de volver a comprobar la condición.
- `return` termina el método. Si el método devuelve un valor, lo entrega a quien lo llamó.

El [ejemplo de bucles](../../ejemplos/S05_RA3/S05_Bucles.java) reúne las tres formas de repetición y una comparación de `break` y `continue`.

## Excepciones y validación

Una excepción señala un problema durante la ejecución. Por ejemplo, convertir `"dieciseis"` con `Integer.parseInt` provoca `NumberFormatException`.

```java
try {
    int ram = Integer.parseInt(texto);
    System.out.println(ram);
} catch (NumberFormatException error) {
    System.out.println("Escribe un numero entero");
}
```

Java intenta ejecutar el bloque `try`. Si aparece esa excepción, deja el resto de ese bloque y ejecuta el `catch` compatible. Después puede continuar con el código que sigue. El `catch` no arregla automáticamente el dato ni captura cualquier error posible.

El texto `"-1"` sí representa un entero. La conversión funciona, pero una RAM negativa no es válida para nuestro problema. Esa regla se comprueba con un `if`. La validación del dato y la gestión de excepciones resuelven situaciones diferentes.

Abre [S05_Excepciones.java](../../ejemplos/S05_RA3/S05_Excepciones.java) y sigue los casos `"16"`, `"dieciseis"` y `"-1"`.

## Pruebas y depuración

Antes de ejecutar, anota qué resultado esperas. Para un aviso que empieza en 85, prueba 84, 85 y 86. Para un bucle, prueba cero, una y varias vueltas. Para una conversión, prueba un texto válido y otro que no represente un número.

Una tabla de traza ayuda a seguir los valores:

| `pendientes` antes de comprobar | `pendientes > 0` | Acción |
|---:|:---:|---|
| 3 | Verdadero | Muestra 3 y resta 1 |
| 2 | Verdadero | Muestra 2 y resta 1 |
| 1 | Verdadero | Muestra 1 y resta 1 |
| 0 | Falso | Sale del bucle |

Si el resultado no coincide, localiza el primer paso diferente. En VSCode puedes poner un punto de interrupción y avanzar paso a paso, observando la condición y las variables. Un error de compilación impide ejecutar; un error lógico puede producir una salida incorrecta sin lanzar ninguna excepción.

Las [dos propuestas opcionales](../../ejemplos/S05_RA3/S05_Ejercicios_RA3.md) permiten practicar estas ideas con cambios pequeños.
