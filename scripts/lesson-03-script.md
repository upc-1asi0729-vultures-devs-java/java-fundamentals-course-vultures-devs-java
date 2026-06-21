# Lección 03 - Operadores y puntaje de aventura

## Objetivo de la lección

Explicar qué son los operadores en Java y usarlos para calcular puntaje, recursos y cambios de energía dentro de la aventura de bloques.

Al finalizar la lección, el estudiante debe poder usar operadores aritméticos y de comparación en expresiones simples.

## Conceptos clave

- Operadores aritméticos.
- Suma `+`.
- Resta `-`.
- Multiplicación `*`.
- Operadores de comparación.
- Mayor o igual que `>=`.
- Expresiones con variables.
- Variable `boolean`.

## Código inicial

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Aventura de Bloques ===");
        System.out.println("Bienvenido, explorador.");
        System.out.println("En este curso aprenderas Java creando una aventura de bloques.");
        System.out.println("Tu mision sera minar, explorar y guardar objetos en un inventario.");

        String nombreJugador = "Alex";
        int vida = 100;
        int energia = 80;
        int bloques = 0;
        boolean tienePico = true;

        System.out.println("");
        System.out.println("=== Ficha del Jugador ===");
        System.out.println("Nombre: " + nombreJugador);
        System.out.println("Vida: " + vida);
        System.out.println("Energia: " + energia);
        System.out.println("Bloques recolectados: " + bloques);
        System.out.println("Tiene pico: " + tienePico);
    }
}
```

## Código final

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Aventura de Bloques ===");
        System.out.println("Bienvenido, explorador.");
        System.out.println("En este curso aprenderas Java creando una aventura de bloques.");
        System.out.println("Tu mision sera minar, explorar y guardar objetos en un inventario.");

        String nombreJugador = "Alex";
        int vida = 100;
        int energia = 80;
        int bloques = 5;
        int diamantes = 2;
        boolean tienePico = true;

        int puntosPorBloque = 10;
        int puntosPorDiamante = 50;
        int puntajeBloques = bloques * puntosPorBloque;
        int puntajeDiamantes = diamantes * puntosPorDiamante;
        int puntajeTotal = puntajeBloques + puntajeDiamantes;
        int energiaDespuesDeMinar = energia - 15;
        boolean puedeExplorar = energiaDespuesDeMinar >= 50;

        System.out.println("");
        System.out.println("=== Ficha del Jugador ===");
        System.out.println("Nombre: " + nombreJugador);
        System.out.println("Vida: " + vida);
        System.out.println("Energia inicial: " + energia);
        System.out.println("Bloques recolectados: " + bloques);
        System.out.println("Diamantes recolectados: " + diamantes);
        System.out.println("Tiene pico: " + tienePico);

        System.out.println("");
        System.out.println("=== Puntaje de Aventura ===");
        System.out.println("Puntaje por bloques: " + puntajeBloques);
        System.out.println("Puntaje por diamantes: " + puntajeDiamantes);
        System.out.println("Puntaje total: " + puntajeTotal);
        System.out.println("Energia despues de minar: " + energiaDespuesDeMinar);
        System.out.println("Puede explorar despues de minar: " + puedeExplorar);
    }
}
```

## Explicación sugerida

La lección inicia recordando que en la lección anterior se crearon variables para representar los datos del jugador.

Luego se explica que los operadores permiten realizar cálculos y comparaciones.

Se agregan variables para bloques y diamantes, y después se crean valores como `puntosPorBloque` y `puntosPorDiamante`.

Luego se calcula el puntaje por bloques usando multiplicación.

También se calcula el puntaje por diamantes y se suman ambos resultados para obtener el puntaje total.

Después se calcula la energía restante usando resta.

Finalmente, se usa el operador `>=` para verificar si el jugador puede explorar después de minar.

## Práctica para el estudiante

Modificar la cantidad de bloques y diamantes.

Ejemplo:

```java
int bloques = 8;
int diamantes = 3;
```

Modificar también el costo de energía por minar.

Ejemplo:

```java
int energiaDespuesDeMinar = energia - 40;
```

Luego ejecutar el programa y observar cómo cambian el puntaje total y el resultado de `puedeExplorar`.

## Conexión con la siguiente lección

En la siguiente lección se aprenderá a usar condicionales para que el programa tome decisiones, por ejemplo, si el jugador puede explorar, debe descansar o necesita recuperar vida.
