# Práctica RA2: calculadora de almacenamiento

Tiempo recomendado: **25 minutos**.

Archivo de partida: `S03_PlantillaPractica.java`.

## Preparación

1. Actualiza el repositorio mediante `git pull --ff-only`.
2. Copia `S03_PlantillaPractica.java` a tu carpeta personal.
3. Realiza la práctica sobre esa copia, fuera del repositorio.

## Situación

Necesitamos una pequeña utilidad que calcule espacio libre y convierta gigabytes a megabytes.

## Mínimo obligatorio

Completa los métodos marcados con `TODO`:

1. `mostrarCabecera()`: no recibe datos y no devuelve valor.
2. `calcularEspacioLibre(double total, double usado)`: devuelve la resta.
3. `convertirGbAMb(double gb)`: devuelve los megabytes usando 1024.
4. `mostrarResultado(String etiqueta, double valor, String unidad)`: muestra una línea formateada.
5. Usa `Math.max` para asegurar que el espacio mostrado nunca sea negativo.
6. Llama a todos los métodos desde `main`.

## Pruebas

| Total | Usado | Libre esperado | Libre en MB |
|---:|---:|---:|---:|
| 512 | 320 | 192 | 196608 |
| 256 | 256 | 0 | 0 |
| 128 | 150 | 0 después de `Math.max` | 0 |

## Explicación breve

En el `README.md`, responde:

- ¿Qué métodos devuelven un valor?
- ¿Qué parámetros recibe `mostrarResultado`?
- ¿Por qué usamos `Math.max`?
- ¿Qué prueba demuestra que el resultado no se hace negativo?

## Mejora opcional

Crea:

```java
public static double calcularPorcentajeUsado(double total, double usado)
```

Para `total = 512` y `usado = 320`, debe devolver `62.5`.

## Pistas

1. Una función que devuelve un decimal comienza con `public static double`.
2. Los datos de la llamada se escriben entre paréntesis y en el mismo orden que los parámetros.
3. `Math.max(0, valor)` devuelve el mayor de ambos.

## Criterios de éxito

- [ ] Los cuatro métodos se ejecutan.
- [ ] Los cálculos superan las tres pruebas.
- [ ] `main` coordina el programa sin repetir cálculos.
- [ ] Los nombres y comentarios permiten entender el código.
- [ ] El programa está guardado en mi carpeta personal y preparado para entregarlo en el Aula Virtual.
