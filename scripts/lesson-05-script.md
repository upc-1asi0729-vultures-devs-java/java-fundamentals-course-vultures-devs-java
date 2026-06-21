# Lección 05 - Bucles para repetir acciones

## Objetivo de la lección

Explicar cómo funcionan los bucles en Java y aplicarlos para repetir acciones dentro de la aventura de bloques.

Al finalizar la lección, el estudiante debe poder usar `for` y `while` para repetir instrucciones de forma controlada.

## Conceptos clave

- Bucle.
- Repetición.
- `for`.
- `while`.
- Contador.
- Condición.
- Incremento `++`.
- Asignación con suma `+=`.
- Asignación con resta `-=`.

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

        System.out.println("");
        System.out.println("=== Minado con for ===");

        int energiaActual = energiaDespuesDeMinar;
        int bloquesActuales = bloques;
        int bloquesPorMinar = 3;
        int costoEnergiaPorBloque = 10;

        for (int turno = 1; turno <= bloquesPorMinar; turno++) {
            if (energiaActual >= costoEnergiaPorBloque) {
                bloquesActuales++;
                energiaActual -= costoEnergiaPorBloque;
                System.out.println("Turno " + turno + ": bloque minado.");
                System.out.println("Bloques actuales: " + bloquesActuales);
                System.out.println("Energia actual: " + energiaActual);
            } else {
                System.out.println("Turno " + turno + ": no hay energia suficiente para minar.");
            }
        }

        System.out.println("");
        System.out.println("=== Descanso con while ===");

        while (energiaActual < energia) {
            energiaActual += 10;

            if (energiaActual > energia) {
                energiaActual = energia;
            }

            System.out.println("Descansando... Energia actual: " + energiaActual);
        }

        System.out.println("");
        System.out.println("=== Estado despues de los bucles ===");
        System.out.println("Bloques finales: " + bloquesActuales);
        System.out.println("Energia final: " + energiaActual);
    }
}
```

## Explicación sugerida

La lección inicia explicando que un bucle permite repetir instrucciones sin escribir manualmente la misma acción varias veces.

Luego se presenta el bucle `for` como una estructura útil cuando se conoce la cantidad de repeticiones.

En el ejemplo, el jugador intenta minar 3 bloques. Cada turno revisa si hay energía suficiente. Si la energía alcanza, el programa aumenta los bloques y resta energía.

Después se presenta el bucle `while`, que se usa cuando la repetición depende de una condición.

En el ejemplo, el jugador descansa mientras su energía actual sea menor que la energía inicial.

También se explican formas cortas para actualizar variables:

- `bloquesActuales++`
- `energiaActual += 10`
- `energiaActual -= costoEnergiaPorBloque`

## Práctica para el estudiante

Modificar la cantidad de bloques que el jugador intenta minar.

Ejemplo:

```java
int bloquesPorMinar = 5;
```

Modificar también el costo de energía por bloque.

Ejemplo:

```java
int costoEnergiaPorBloque = 15;
```

Luego ejecutar el programa y observar si el jugador logra minar todos los bloques o si se queda sin energía.

## Conexión con la siguiente lección

En la siguiente lección se aprenderá a organizar el código usando métodos para representar acciones como mostrar estado, minar y descansar.
