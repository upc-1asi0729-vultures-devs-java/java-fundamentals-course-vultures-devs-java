# Lección 04 - Condicionales para sobrevivir

## Objetivo de la lección

Explicar cómo funcionan los condicionales en Java y aplicarlos para que el programa tome decisiones dentro de la aventura de bloques.

Al finalizar la lección, el estudiante debe poder usar `if`, `else if` y `else` para ejecutar diferentes instrucciones según una condición.

## Conceptos clave

- Condicional.
- `if`.
- `else if`.
- `else`.
- Condición.
- Operadores de comparación.
- Mayor o igual que `>=`.
- Menor o igual que `<=`.
- Operador lógico `&&`.

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

        System.out.println("");
        System.out.println("=== Decision de Aventura ===");

        if (vida <= 0) {
            System.out.println("El jugador no tiene vida. La aventura ha terminado.");
        } else if (puedeExplorar && tienePico) {
            System.out.println("El jugador puede explorar la cueva y seguir minando.");
        } else if (energiaDespuesDeMinar > 0) {
            System.out.println("El jugador tiene poca energia. Es mejor descansar antes de explorar.");
        } else {
            System.out.println("El jugador no tiene energia. Debe descansar urgentemente.");
        }

        System.out.println("");
        System.out.println("=== Rango del Jugador ===");

        if (puntajeTotal >= 150) {
            System.out.println("Rango: Explorador experto");
        } else if (puntajeTotal >= 80) {
            System.out.println("Rango: Explorador aprendiz");
        } else {
            System.out.println("Rango: Explorador principiante");
        }
    }
}
```

## Explicación sugerida

La lección inicia recordando que en la lección anterior se calcularon puntaje y energía después de minar.

Luego se explica que un condicional permite que el programa tome decisiones.

Primero se crea una sección llamada `Decision de Aventura`.

Después se usa `if` para revisar si el jugador no tiene vida.

Luego se usa `else if` para revisar si puede explorar y además tiene pico.

En esa condición se usa `&&`, que significa “y”. Ambas condiciones deben ser verdaderas para que el bloque se ejecute.

Después se agrega otro `else if` para el caso donde el jugador tiene poca energía.

Finalmente, se usa `else` para cubrir el caso final donde no se cumple ninguna condición anterior.

También se agrega una segunda estructura condicional para asignar un rango según el puntaje total del jugador.

## Práctica para el estudiante

Modificar la energía inicial del jugador.

Ejemplo:

```java
int energia = 40;
```

Luego ejecutar el programa y observar cómo cambia la decisión.

Después modificar la variable `tienePico`.

Ejemplo:

```java
boolean tienePico = false;
```

Ejecutar nuevamente y observar cómo cambia el mensaje de la aventura.

## Conexión con la siguiente lección

En la siguiente lección se aprenderá a usar bucles para repetir acciones, por ejemplo, minar varios bloques sin escribir la misma instrucción muchas veces.
