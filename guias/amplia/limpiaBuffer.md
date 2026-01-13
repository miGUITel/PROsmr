Sí, **en este caso concreto es necesario**, y merece la pena entender bien *por qué*, porque es una de esas situaciones que en programación aparecen constantemente y que, si no se comprenden, parecen “errores mágicos”.

---

## Qué está pasando realmente

`Scanner` no “lee valores”, **lee desde un flujo de texto** (normalmente el teclado). Ese flujo contiene caracteres: números, letras… y también **saltos de línea** (`\n`).

Cuando haces:

```java
double tamanoMB = sc.nextDouble();
```

`nextDouble()`:

* Lee solo los caracteres que forman el número (por ejemplo `12.5`)
* **Pero no consume el salto de línea** que se genera cuando el usuario pulsa Enter.

En el buffer queda esto:

```
\n
```

Justo después haces:

```java
String tipo = sc.nextLine();
```

`nextLine()` no busca “texto útil”, busca **hasta el siguiente salto de línea**.
Como el salto de línea ya estaba ahí, lo que encuentra es una línea vacía, y por eso “se la salta” sin dejar escribir nada.

---

## Para qué sirve entonces `sc.nextLine();`

Esta línea intermedia:

```java
sc.nextLine(); // limpiar salto de línea
```

no es un adorno:
**consume el Enter pendiente**, dejando el buffer limpio para que el siguiente `nextLine()` sí pueda leer lo que escriba el usuario.

Es exactamente igual que:

👉 vaciar una bandeja antes de poner un documento nuevo.
Si no la vacías, el siguiente “recogedor” se lleva lo que ya había, no lo nuevo.

---

## ¿Siempre es necesario?

No. Es necesario **cuando mezclas métodos tipo**:

* `nextInt()`, `nextDouble()`, `next()` …
* con `nextLine()`

porque los primeros **no consumen el salto de línea** y `nextLine()` sí lo tiene en cuenta.

Ejemplos:

✔ No hace falta si solo usas `nextLine()` siempre.
✔ No hace falta entre dos `nextInt()`.
❌ Sí hace falta cuando pasas de un numérico a `nextLine()`.

---

## Forma alternativa (más “robusta” en muchos casos)

Otra estrategia muy usada en aplicaciones reales es:

👉 **leer siempre líneas completas** y convertirlas.

```java
double tamanoMB = Double.parseDouble(sc.nextLine());
String tipo = sc.nextLine();
```

Aquí no necesitas “limpiar” nada porque **todo se lee con `nextLine()`**, y tú decides cómo interpretar el texto.

Esto se parece mucho más a cómo funcionan los formularios, ficheros de texto o datos que llegan por red: primero llega texto, luego tú lo procesas.

---

## Idea clave para tus alumnos

No es un “truco de Scanner”.
Es un **efecto directo de cómo funciona la entrada de texto**:

* El teclado no envía números, envía caracteres.
* El Enter también es un carácter.
* Algunos métodos lo consumen, otros no.

Cuando entienden eso, dejan de memorizar `sc.nextLine()` como receta y empiezan a **razonar qué queda en el buffer**, que es exactamente lo que luego tendrán que hacer con ficheros, sockets o streams.
