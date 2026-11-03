# Cuaderno 1 de 5 · Datos, entradas y cálculos

Un programa puede ayudarnos a preparar una compra, calcular espacio libre o elaborar un presupuesto. En este cuaderno escribirás programas pequeños que **preguntan datos, realizan cálculos y muestran resultados comprensibles**.

## Cómo trabajar

Trabajaremos sin Internet, con los materiales locales y el apoyo del profesor.

1. Actualiza los materiales del repositorio antes de comenzar. Durante el trabajo utilizarás la copia local disponible en VSCode.
2. Crea una carpeta personal de prácticas **fuera del repositorio**. Guarda en ella un programa independiente por propuesta, con el nombre indicado. El nombre del archivo y el de su clase pública deben coincidir.
3. Lee el problema y su ejemplo. Antes de programar, identifica qué datos necesitas y qué resultado esperas.
4. Construye el programa poco a poco: pide un dato, comprueba que lo recibes y continúa con el siguiente paso. Compila y ejecuta con frecuencia.
5. Comprueba el ejemplo y una segunda prueba. Anota en un comentario de tu programa los datos de esa segunda prueba, el resultado esperado y el obtenido.

Puedes consultar la [guía de variables, operaciones y entrada/salida](../../guias/guia.md) y los [apuntes sobre los elementos de un programa](../../apuntes/S03_RA1/S03_Apuntes_RA1.md). Puedes reutilizar la estructura básica de un ejemplo local, pero los datos y los cálculos deben responder al problema que estás resolviendo.

**Herramientas del cuaderno:** Java, variables, constantes, operaciones aritméticas, entrada por teclado con Scanner y salida por consola con println. Trabajaremos con programas secuenciales.

### Acuerdos para todos los problemas

- Los datos que se introduzcan respetarán las condiciones de cada problema. En este cuaderno no se pide detectar entradas incorrectas.
- Los ejemplos usan el punto decimal. Si el Scanner de tu equipo espera una coma, introduce esos mismos valores con coma. Se aceptan salidas numéricamente equivalentes y pequeñas diferencias en los últimos decimales.
- No es obligatorio mostrar exactamente dos decimales: por ejemplo, 14 y 14.0 representan el mismo resultado.
- Los mensajes pueden variar si permiten reconocer claramente cada dato y su unidad.
- **El programa debe compilar.** Después debes comprobar que resuelve el problema: compilar no garantiza que el cálculo sea correcto.

### Recorrido

| Propuestas | Para qué sirven |
|---|---|
| 1–6 | Recorrido esencial: pedir datos, calcular, usar una constante y distinguir resultados enteros y decimales. |
| 7–8 | Consolidación: combinar operaciones que ya has utilizado. |
| 9–10 | Ampliación: aplicar esas operaciones a problemas con más resultados. |

Cada propuesta es un programa pequeño. Si una se atasca, muestra al profesor lo que ya funciona y la prueba que estás utilizando. La práctica individual de evaluación se anunciará por separado.

---

## 1. La ficha de un equipo

**Archivo:** `P01_FichaEquipo.java`

Un técnico necesita identificar los equipos de un aula. Escribe un programa que solicite el **nombre del equipo**, el **aula donde está instalado** y su **cantidad de RAM en GB**, expresada como número entero. Después debe mostrar una ficha con los tres datos y sus etiquetas.

**Ejemplo de ejecución:**

```text
Nombre del equipo: PC-03
Aula: Taller de redes
RAM en GB: 16

FICHA DEL EQUIPO
Equipo: PC-03
Aula: Taller de redes
RAM: 16 GB
```

**Segunda prueba:** utiliza otro equipo y un aula cuyo nombre contenga espacios. Comprueba que aparece el nombre completo del aula.

## 2. El espacio que queda

**Archivo:** `P02_EspacioLibre.java`

Antes de copiar unos archivos, quieres saber cuánto espacio queda en un disco. El programa debe pedir la **capacidad total en GB** y el **espacio ocupado en GB**. Ambos valores pueden contener decimales. Debe mostrar la capacidad, el espacio ocupado y el espacio libre. El espacio ocupado estará entre cero y la capacidad total.

**Ejemplo de ejecución:**

```text
Capacidad total en GB: 512
Espacio ocupado en GB: 320

Capacidad: 512.0 GB
Ocupado: 320.0 GB
Libre: 192.0 GB
```

**Segunda prueba:** capacidad de 256 GB y espacio ocupado de 200 GB. Deben quedar **56 GB libres**.

## 3. Una compra de material

**Archivo:** `P03_CompraMaterial.java`

El centro va a comprar varias unidades del mismo producto. El programa debe pedir el **nombre del producto**, el **número de unidades**, que será entero y positivo, y el **precio de una unidad**. Debe mostrar qué se compra, cuántas unidades se compran y el importe total. El precio introducido es el precio final: no hay que añadir impuestos.

**Ejemplo de ejecución:**

```text
Producto: Cable de red
Unidades: 4
Precio de una unidad en euros: 3.5

Producto: Cable de red
Unidades: 4
Importe total: 14.0 euros
```

**Segunda prueba:** dos unidades a 7.25 euros cada una. El importe total debe ser **14.50 euros**.

## 4. La media de tres pruebas

**Archivo:** `P04_MediaPruebas.java`

Una alumna quiere conocer la media de tres pruebas que tienen el mismo peso. El programa debe pedir su **nombre** y las **tres notas**, que pueden contener decimales y estarán entre cero y diez. Debe mostrar el nombre, las notas introducidas y la media aritmética. Solo se calcula la media; todavía no se pide indicar si aprueba o suspende.

**Ejemplo de ejecución:**

```text
Nombre: Ana
Primera nota: 6
Segunda nota: 7
Tercera nota: 8

Alumna: Ana
Notas: 6.0, 7.0, 8.0
Media: 7.0
```

**Segunda prueba:** notas 5, 5 y 8. La media debe ser **6**. Prueba también una combinación cuya media tenga decimales.

## 5. Un presupuesto con IVA

**Archivo:** `P05_PresupuestoIva.java`

Una tienda prepara presupuestos para sus servicios. El programa debe pedir la **descripción del servicio** y su **precio sin IVA**, que será un número no negativo. El IVA es siempre del **21 %** y su valor debe guardarse como una constante. El programa debe mostrar la descripción, el precio sin IVA, el importe del IVA y el total que pagará el cliente.

Un IVA del 21 % significa que se añaden 21 euros por cada 100 euros de precio sin IVA.

**Ejemplo de ejecución:**

```text
Servicio: Puesta a punto
Precio sin IVA en euros: 50

Servicio: Puesta a punto
Precio sin IVA: 50.0 euros
IVA: 10.5 euros
Total: 60.5 euros
```

**Segunda prueba:** precio sin IVA de 80 euros. El IVA debe ser **16.80 euros** y el total, **96.80 euros**.

## 6. ¿Cuánto ha durado la intervención?

**Archivo:** `P06_DuracionIntervencion.java`

El registro de un taller almacena las intervenciones en minutos. Escribe un programa que pida una **duración total en minutos**, expresada como entero no negativo, y la muestre como **horas completas y minutos restantes**. Una hora tiene 60 minutos.

**Ejemplo de ejecución:**

```text
Duracion total en minutos: 125

Horas completas: 2
Minutos restantes: 5
```

**Segunda prueba:** una intervención de 60 minutos debe dar **1 hora y 0 minutos restantes**. Comprueba también una duración inferior a una hora.

## 7. Una compra con descuento

**Archivo:** `P07_CompraDescuento.java`

Una papelería aplica un descuento a la compra de varias unidades de un mismo producto. El programa debe pedir el **nombre del producto**, el **número entero y positivo de unidades**, el **precio de una unidad** y el **porcentaje de descuento**, situado entre cero y cien. Debe mostrar el importe de la compra antes del descuento, el dinero descontado y el importe final. Los precios ya incluyen impuestos.

**Ejemplo de ejecución:**

```text
Producto: Cuaderno
Unidades: 2
Precio de una unidad en euros: 25
Descuento en porcentaje: 10

Importe inicial: 50.0 euros
Descuento: 5.0 euros
Importe final: 45.0 euros
```

**Segunda prueba:** tres unidades a 20 euros y un descuento del 25 %. Deben descontarse **15 euros** y el importe final debe ser **45 euros**.

## 8. El tiempo de una transferencia

**Archivo:** `P08_TiempoTransferencia.java`

Quieres estimar cuánto tardará en copiarse un archivo. El programa debe pedir el **tamaño del archivo en MB** y la **velocidad de transferencia en MB por segundo**, que será positiva. Supón que la velocidad permanece constante. Debe mostrar el tiempo necesario en segundos, admitiendo decimales cuando hagan falta.

**Ejemplo de ejecución:**

```text
Tamano del archivo en MB: 1500
Velocidad en MB por segundo: 25

Tiempo estimado: 60.0 segundos
```

**Segunda prueba:** un archivo de 900 MB a 40 MB por segundo debe tardar **22.5 segundos**. Comprueba que el programa conserva esa parte decimal.

## 9. Memorias USB en cajas

**Archivo:** `P09_CajasUsb.java`

Un almacén guarda memorias USB en cajas de igual capacidad. El programa debe pedir el **número total de memorias**, entero no negativo, y **cuántas caben en cada caja**, entero positivo. Debe indicar cuántas cajas pueden llenarse por completo y cuántas memorias quedan sueltas. Solo se cuentan las cajas completas.

**Ejemplo de ejecución:**

```text
Memorias USB disponibles: 78
Memorias por caja: 8

Cajas completas: 9
Memorias sueltas: 6
```

**Segunda prueba:** 64 memorias en cajas de 16. Deben obtenerse **4 cajas completas y ninguna memoria suelta**.

## 10. El balance de una venta

**Archivo:** `P10_BalanceVenta.java`

Una tienda quiere conocer el resultado de vender parte de sus existencias. El programa debe pedir el **nombre del producto**, las **unidades disponibles al principio**, las **unidades vendidas**, el **coste de compra de una unidad** y el **precio de venta de una unidad**. Las cantidades serán enteras; las unidades vendidas estarán entre cero y las disponibles. Los precios serán no negativos y ya incluyen los impuestos que correspondan.

Debe mostrar las unidades que quedan, el dinero ingresado por la venta, el coste de las unidades vendidas y el beneficio obtenido en esa venta. Para este problema, el beneficio es la diferencia entre los ingresos y ese coste; no se consideran otros gastos.

**Ejemplo de ejecución:**

```text
Producto: Raton USB
Unidades iniciales: 10
Unidades vendidas: 4
Coste de una unidad en euros: 8
Precio de venta de una unidad en euros: 12.5

Unidades restantes: 6
Ingresos: 50.0 euros
Coste de lo vendido: 32.0 euros
Beneficio: 18.0 euros
```

**Segunda prueba:** 20 unidades iniciales, 5 vendidas, un coste unitario de 2.40 euros y un precio de venta de 3 euros. Deben quedar **15 unidades**; los ingresos serán **15 euros**, el coste de lo vendido **12 euros** y el beneficio **3 euros**.

---

## Antes de dar un programa por terminado

- [ ] El archivo y su clase pública tienen el mismo nombre.
- [ ] El programa compila y se ejecuta.
- [ ] Solicita todos los datos necesarios y los utiliza en los cálculos.
- [ ] La salida identifica cada resultado y su unidad.
- [ ] He comprobado el ejemplo y una segunda prueba.
- [ ] Distingo cuándo necesito un resultado entero y cuándo debo conservar los decimales.
- [ ] Puedo explicar de dónde sale cada resultado.
- [ ] Mi trabajo está guardado fuera del repositorio de materiales.

Conserva un máximo de **diez archivos Java, uno por propuesta**. Las comprobaciones se anotan como comentarios en esos mismos archivos; no hace falta preparar un PDF ni una memoria adicional. La entrega evaluable y su formato se indicarán en el enunciado del examen.
