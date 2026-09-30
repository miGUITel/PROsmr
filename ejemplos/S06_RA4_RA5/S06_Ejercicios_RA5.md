# S06 · Dos ejercicios opcionales de RA5

Propuestas de lectura y escritura breve, de 5–10 minutos. Se pueden resolver en papel o en un archivo de texto, sin instalar un gestor ni conectarse a Internet.

## 1. Equipos con memoria suficiente

Considera esta tabla `equipos`:

| id | nombre | ram |
|---:|---|---:|
| 1 | PC-01 | 8 |
| 2 | PC-02 | 16 |
| 3 | PC-03 | 32 |

Escribe una consulta que muestre solo el nombre y la RAM de los equipos con al menos 16 GB, ordenados por `id`. Dibuja el resultado que esperas. Señala qué parte elige las columnas y cuál filtra las filas.

## 2. Una ampliación de RAM

Sobre la misma tabla, escribe una sentencia para cambiar a 16 GB la RAM del equipo con `id = 1`. Explica qué ocurriría si faltase `WHERE`.

Después, indica por qué no debería permitirse insertar otro equipo con `id = 1` y qué restricción declararía esa regla. No ejecutes operaciones sobre una base real: basta razonar sobre esta tabla de ejemplo.
