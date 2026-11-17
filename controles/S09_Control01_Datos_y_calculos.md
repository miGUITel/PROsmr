# Control 1 · Datos, entradas y cálculos

Resuelve tres problemas breves de Java relacionados con el cuaderno 1. En cada uno pedirás datos por teclado, harás un cálculo y mostrarás el resultado.

## Cómo trabajar

1. Actualiza el repositorio con `git pull` cuando lo indique el profesor y abre este enunciado en VSCode.
2. Trabaja individualmente y sin Internet. Puedes consultar tus apuntes y los materiales de la copia local del repositorio. [Cuaderno 1](../tareas/S07_RA1/S07_Cuaderno01_Datos_y_calculos.md) · [Apuntes de RA1](../apuntes/S03_RA1/S03_Apuntes_RA1.md) · [Guía de entrada y salida](../guias/guia.md).
3. Crea un programa independiente para cada ejercicio en tu carpeta personal, fuera del repositorio. El nombre de la clase pública debe coincidir con el del archivo, sin la extensión `.java`.
4. Usa `Scanner` para leer los datos y `System.out.println` para mostrar los resultados. Compila cada programa y comprueba el ejemplo y la segunda prueba.

Los datos de entrada serán válidos. Los ejemplos usan punto decimal. Si tu `Scanner` espera coma, introduce los mismos valores con coma. Puedes escribir los mensajes a tu manera si identifican cada resultado y su unidad. Se aceptan valores numéricamente equivalentes y pequeñas diferencias de redondeo.

## 1. Cable para una instalación

Guarda el programa como `C01_01_CableInstalacion.java`.

Tienes una bobina con **25 metros de cable** y necesitas cortar dos tramos para una instalación. Pide el **nombre de la instalación** y la **longitud de cada tramo en metros**. Las longitudes pueden tener decimales y siempre habrá cable suficiente. Muestra el nombre de la instalación, cuántos metros se han cortado en total y cuántos quedan en la bobina.

**Ejemplo de ejecución**

```text
Nombre de la instalación: Aula de redes
Longitud del primer tramo en metros: 6.5
Longitud del segundo tramo en metros: 8.25

Instalación: Aula de redes
Cable cortado: 14.75 m
Cable restante: 10.25 m
```

Para la segunda prueba, utiliza otro nombre y dos tramos de 12 y 13 metros. El total cortado debe ser **25 m** y deben quedar **0 m**.

## 2. ¿Cuántos equipos caben en el turno?

Guarda el programa como `C01_02_TurnoRevision.java`.

Al comenzar un turno en el taller necesitas **10 minutos para preparar el puesto**. Después, revisar cada equipo lleva **15 minutos**. Pide la **duración total del turno en minutos**, un número entero de al menos 10. Descuenta la preparación y muestra cuántos equipos puedes revisar por completo y cuántos minutos te sobran tras esas revisiones.

**Ejemplo de ejecución**

```text
Duración del turno en minutos: 72

Equipos que puedes revisar: 4
Minutos sobrantes: 2
```

Para la segunda prueba, utiliza un turno de 55 minutos. Debes poder revisar **3 equipos** y sobrarán **0 minutos**.

## 3. El coste de dejar un equipo encendido

Guarda el programa como `C01_03_CosteEnergia.java`.

Quieres estimar cuánto cuesta mantener encendido un equipo. Pide su **potencia en vatios** y el **tiempo de uso en horas**. El tiempo puede tener decimales. Para calcular la energía consumida, recuerda que **1.000 W equivalen a 1 kW** y que la energía en kWh se obtiene multiplicando la potencia en kW por las horas de uso. Guarda como constante un precio de **0,25 euros por kWh**. Muestra la energía consumida y el coste estimado.

**Ejemplo de ejecución**

```text
Potencia en vatios: 200
Tiempo de uso en horas: 4

Energía consumida: 0.8 kWh
Coste estimado: 0.20 euros
```

Para la segunda prueba, utiliza un equipo de 240 W durante 2,5 horas. El consumo debe ser **0,6 kWh** y el coste **0,15 euros**.

## Entrega

Sube a Moodle un máximo de **tres archivos `.java`**, uno por ejercicio, con los nombres indicados. Si solo terminas parte del control, entrega los programas que hayas conseguido hacer compilar.

**Para que un ejercicio cuente, su archivo debe compilar.** Se comprobará que al cambiar los datos el programa calcula y muestra los resultados correctos.
