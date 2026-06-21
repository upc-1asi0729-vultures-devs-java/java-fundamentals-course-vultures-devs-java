# Lección 06 - Métodos: acciones del jugador

## Objetivo de la lección

Explicar qué son los métodos en Java y usarlos para organizar acciones del programa.

Al finalizar la lección, el estudiante debe poder crear métodos simples, llamar métodos desde `main`, usar parámetros y devolver valores con `return`.

## Conceptos clave

- Método.
- Llamada a método.
- `void`.
- Parámetros.
- `return`.
- Reutilización de código.
- Organización del programa.

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

## Código final

```java
public class Main {
    public static void main(String[] args) {
        String nombreJugador = "Alex";
        int vida = 100;
        int energia = 80;
        int bloques = 5;
        int diamantes = 2;
        boolean tienePico = true;

        mostrarBienvenida();
        mostrarFicha(nombreJugador, vida, energia, bloques, diamantes, tienePico);

        int puntajeTotal = calcularPuntaje(bloques, diamantes);

        System.out.println("");
        System.out.println("=== Puntaje de Aventura ===");
        System.out.println("Puntaje total: " + puntajeTotal);

        mostrarRango(puntajeTotal);

        System.out.println("");
        System.out.println("=== Acciones del Jugador ===");

        bloques = minarBloques(bloques, 3);
        energia = consumirEnergia(energia, 30);
        energia = descansar(energia, 80);

        System.out.println("");
        System.out.println("=== Estado Final ===");
        mostrarFicha(nombreJugador, vida, energia, bloques, diamantes, tienePico);
    }

    public static void mostrarBienvenida() {
        System.out.println("=== Aventura de Bloques ===");
        System.out.println("Bienvenido, explorador.");
        System.out.println("En este curso aprenderas Java creando una aventura de bloques.");
        System.out.println("Tu mision sera minar, explorar y guardar objetos en un inventario.");
    }

    public static void mostrarFicha(String nombreJugador, int vida, int energia, int bloques, int diamantes, boolean tienePico) {
        System.out.println("");
        System.out.println("=== Ficha del Jugador ===");
        System.out.println("Nombre: " + nombreJugador);
        System.out.println("Vida: " + vida);
        System.out.println("Energia: " + energia);
        System.out.println("Bloques recolectados: " + bloques);
        System.out.println("Diamantes recolectados: " + diamantes);
        System.out.println("Tiene pico: " + tienePico);
    }

    public static int calcularPuntaje(int bloques, int diamantes) {
        int puntosPorBloque = 10;
        int puntosPorDiamante = 50;

        int puntajeBloques = bloques * puntosPorBloque;
        int puntajeDiamantes = diamantes * puntosPorDiamante;

        return puntajeBloques + puntajeDiamantes;
    }

    public static void mostrarRango(int puntajeTotal) {
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

    public static int minarBloques(int bloquesActuales, int cantidad) {
        System.out.println("");
        System.out.println("Minando bloques...");

        for (int turno = 1; turno <= cantidad; turno++) {
            bloquesActuales++;
            System.out.println("Turno " + turno + ": bloque minado.");
            System.out.println("Bloques actuales: " + bloquesActuales);
        }

        return bloquesActuales;
    }

    public static int consumirEnergia(int energiaActual, int costo) {
        energiaActual -= costo;

        if (energiaActual < 0) {
            energiaActual = 0;
        }

        System.out.println("");
        System.out.println("Energia despues de la accion: " + energiaActual);

        return energiaActual;
    }

    public static int descansar(int energiaActual, int energiaMaxima) {
        System.out.println("");
        System.out.println("Descansando para recuperar energia...");

        while (energiaActual < energiaMaxima) {
            energiaActual += 10;

            if (energiaActual > energiaMaxima) {
                energiaActual = energiaMaxima;
            }

            System.out.println("Energia actual: " + energiaActual);
        }

        return energiaActual;
    }
}
```

## Explicación sugerida

La lección inicia explicando que el código ha crecido y que conviene organizarlo usando métodos.

Primero se presenta un método como un bloque de código con nombre.

Luego se crea `mostrarBienvenida`, un método `void` que muestra mensajes iniciales.

Después se crea `mostrarFicha`, que recibe parámetros como nombre, vida, energía, bloques, diamantes y pico.

Luego se crea `calcularPuntaje`, un método que devuelve un número entero usando `return`.

Después se crea `mostrarRango`, que usa condicionales para mostrar el rango del jugador.

También se crean métodos para representar acciones del jugador:

- `minarBloques`
- `consumirEnergia`
- `descansar`

Finalmente, se muestra que el método `mostrarFicha` puede reutilizarse para mostrar el estado final del jugador.

## Práctica para el estudiante

Cambiar la cantidad de bloques que se minan.

Ejemplo:

```java
bloques = minarBloques(bloques, 5);
```

Cambiar también el costo de energía.

Ejemplo:

```java
energia = consumirEnergia(energia, 50);
```

Luego ejecutar el programa y observar cómo cambia el estado final.

## Conexión con la siguiente lección

En la siguiente lección se aprenderá a usar `Scanner` para que el usuario pueda escribir datos y elegir acciones desde un menú interactivo.
