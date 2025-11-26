- [📝 **Batería de 8 ejercicios de condicionales (nivel inicial)**](#-batería-de-8-ejercicios-de-condicionales-nivel-inicial)
  - [**1. Comprobación de mayoría de edad**](#1-comprobación-de-mayoría-de-edad)
  - [**2. Temperatura bajo cero**](#2-temperatura-bajo-cero)
  - [**3. Contraseña vacía**](#3-contraseña-vacía)
  - [**4. Nota mínima**](#4-nota-mínima)
  - [**5. Comprobación de nombre**](#5-comprobación-de-nombre)
  - [**6. Batería del móvil**](#6-batería-del-móvil)
  - [**7. Edad imposible**](#7-edad-imposible)
  - [**8. Comprobación de red**](#8-comprobación-de-red)
- [🧩 **Batería avanzada de condicionales (nivel 2)**](#-batería-avanzada-de-condicionales-nivel-2)
  - [**1. Clasificación simple de notas**](#1-clasificación-simple-de-notas)
  - [**2. Rango de edad**](#2-rango-de-edad)
  - [**3. Comprobación de usuario y contraseña**](#3-comprobación-de-usuario-y-contraseña)
  - [**4. Número dentro o fuera del intervalo**](#4-número-dentro-o-fuera-del-intervalo)
  - [**5. Detector de descuentos**](#5-detector-de-descuentos)
  - [**6. Sensor de temperatura**](#6-sensor-de-temperatura)
  - [**7. Control de acceso por rol**](#7-control-de-acceso-por-rol)
  - [**8. Evaluación de contraseña segura**](#8-evaluación-de-contraseña-segura)
- [✔ Con esto tienen un nivel sólido](#-con-esto-tienen-un-nivel-sólido)

# 📝 **Batería de 8 ejercicios de condicionales (nivel inicial)**

## **1. Comprobación de mayoría de edad**

Pide al usuario su edad.
Si es mayor o igual que 18, muestra: **“Eres mayor de edad.”**

---

## **2. Temperatura bajo cero**

Pide una temperatura en grados.
Si la temperatura es menor que 0, muestra: **“Hace frío.”**

---

## **3. Contraseña vacía**

Pide una contraseña como texto.
Si la cadena está vacía (`""`), muestra: **“Contraseña no válida.”**

---

## **4. Nota mínima**

Pide una nota entre 0 y 10.
Si la nota es menor que 5, muestra: **“Suspenso.”**

---

## **5. Comprobación de nombre**

Pide un nombre.
Si el nombre es exactamente **“admin”**, muestra: **“Acceso permitido.”**

*(Usarán `equals()` si ya lo conocen; si no, basta una explicación rápida.)*

---

## **6. Batería del móvil**

Pide el porcentaje de batería.
Si es menor que 20, muestra: **“Activa el modo ahorro.”**

---

## **7. Edad imposible**

Pide la edad del usuario.
Si la edad es menor que 0, muestra: **“Edad no válida.”**

---

## **8. Comprobación de red**

Pide un valor booleano (true/false) que indique si hay conexión a internet.
Si **no** hay conexión, muestra: **“Revisa el cable o el WiFi.”**

---


Aquí tienes una **segunda batería**, un único bloque con **8 enunciados más avanzados**, pensados para trabajar:

* `if / else`
* `else if`
* Operadores lógicos simples (`&&`, `||`)
* Comparaciones múltiples
* Pequeños análisis sin necesidad de mucho código

Siguen siendo muy breves y centrados en **pensar la condición**, no en programar mucho.

---

# 🧩 **Batería avanzada de condicionales (nivel 2)**

## **1. Clasificación simple de notas**

Pide una nota.

* Si la nota es menor que 5 → **“Suspenso”**
* Si es mayor o igual que 5 → **“Aprobado”**

---

## **2. Rango de edad**

Pide una edad.

* Si está entre 0 y 12 inclusive → **“Niño”**
* Si está entre 13 y 17 → **“Adolescente”**
* En otro caso → **“Adulto”**

*(Analizan rangos y orden lógico.)*

---

## **3. Comprobación de usuario y contraseña**

Pide usuario y contraseña.

* Si el usuario es “admin” **y** la contraseña “1234” → **“Bienvenido”**
* En caso contrario → **“Acceso denegado”**

*(Primer contacto natural con `&&`.)*

---

## **4. Número dentro o fuera del intervalo**

Pide un número entero.

* Si está entre 1 y 100 → **“Dentro del intervalo”**
* Si no → **“Fuera del intervalo”**

---

## **5. Detector de descuentos**

Pide la edad.

* Si es menor de 18 **o** mayor de 65 → **“Descuento aplicado”**
* En otro caso → **“Precio completo”**

*(Uso intuitivo de `||`.)*

---

## **6. Sensor de temperatura**

Pide una temperatura.

* Si es menor de 0 → **“Congelación”**
* Si está entre 0 y 35 → **“Temperatura normal”**
* Si es mayor de 35 → **“Alerta: demasiado calor”**

---

## **7. Control de acceso por rol**

Pide el rol del usuario.

* Si es “admin” → **“Acceso total”**
* Si es “usuario” → **“Acceso limitado”**
* Si es cualquier otro valor → **“Rol desconocido”**

---

## **8. Evaluación de contraseña segura**

Pide una contraseña.

* Si la contraseña está vacía → **“No válida”**
* Si tiene menos de 8 caracteres → **“Contraseña débil”**
* En otro caso → **“Contraseña aceptada”**

---

# ✔ Con esto tienen un nivel sólido

Esta segunda batería obliga a:

* Encadenar condiciones
* Pensar rangos
* Usar operadores lógicos
* Identificar el orden correcto de evaluación
* Entender que un `else` recoge “todo lo demás”

Si quieres, preparo una **tercera batería** con ejercicios de errores típicos (para depurar), o una **plantilla de resoluciones** para corregir en clase.
