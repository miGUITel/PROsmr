# Práctica RA1: ficha y presupuesto de un equipo

Tiempo recomendado: **30 minutos**.

Archivo de partida: `S02_PlantillaPractica.java`.

## Preparación

1. Actualiza el repositorio mediante `git pull --ff-only`.
2. Copia la plantilla a tu carpeta personal de prácticas.
3. Cambia el nombre de la copia si lo indica el profesor.
4. No trabajes directamente dentro del repositorio de materiales.

## Situación

Una pequeña tienda necesita mostrar la ficha de un equipo y calcular su precio final con IVA.

## Mínimo obligatorio

Completa los `TODO` para conseguir que el programa:

1. Guarde el nombre del equipo en un `String`.
2. Guarde la RAM en un `int`.
3. Guarde el precio base en un `double`.
4. Guarde si tiene SSD en un `boolean`.
5. Declare `IVA` como constante con valor `0.21`.
6. Calcule el importe del IVA y el precio final.
7. Muestre una ficha legible.
8. Convierta la RAM a texto con `String.valueOf` y la muestre dentro de una frase.

## Salida orientativa

```text
Equipo: Aula Mini
RAM: 16 GB
SSD: true
Precio base: 450.0 euros
IVA: 94.5 euros
Precio final: 544.5 euros
```

## Comprobaciones

Ejecuta al menos estas dos pruebas:

| Prueba | Precio base | Resultado final esperado |
|---|---:|---:|
| A | 450.00 | 544.50 |
| B | 600.00 | 726.00 |

No es obligatorio mostrar exactamente dos decimales todavía.

## Explicación breve

Completa en el `README.md`:

- He usado `int` para la RAM porque...
- `IVA` es una constante porque...
- La expresión que calcula el precio final es...
- La conversión realizada ha sido...

## Mejora opcional

- Añade el número de puertos USB.
- Calcula el precio de tres equipos iguales.
- Muestra si el precio final supera 500 euros mediante una variable `boolean`.

## Pistas

1. El importe del IVA se calcula multiplicando el precio base por `IVA`.
2. El precio final suma el precio base y el importe del IVA.
3. Una constante empieza por `final`: `final double ...`.

## Criterios de éxito

- [ ] El programa compila y se ejecuta.
- [ ] Cada dato tiene un tipo adecuado.
- [ ] La constante no se reasigna.
- [ ] Los cálculos coinciden con las pruebas.
- [ ] La salida permite comprobar todos los valores.
- [ ] La práctica está guardada en mi carpeta personal y preparada para entregarla en el Aula Virtual.
