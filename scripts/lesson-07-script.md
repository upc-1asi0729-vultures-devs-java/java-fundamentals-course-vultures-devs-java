# Lección 07 - Scanner y menú interactivo

## Objetivo de la lección

Explicar cómo usar `Scanner` en Java para leer datos desde consola y crear un menú interactivo para la aventura de bloques.

Al finalizar la lección, el estudiante debe poder pedir datos al usuario, leer opciones numéricas y ejecutar acciones según la opción elegida.

## Conceptos clave

- `Scanner`.
- `import java.util.Scanner`.
- `System.in`.
- `System.out.print`.
- `nextLine()`.
- `nextInt()`.
- Menú interactivo.
- Bucle `while`.
- Condicionales con `if` y `else if`.
- Comparación con `==`.

## Código inicial

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

## Código final

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        mostrarBienvenida();

        System.out.print("Escribe el nombre de tu jugador: ");
        String nombreJugador = scanner.nextLine();

        int vida = 100;
        int energia = 80;
        int energiaMaxima = 100;
        int bloques = 5;
        int diamantes = 2;
        boolean tienePico = true;

        int opcion = 0;

        while (opcion != 5) {
            mostrarMenu();

            System.out.print("Elige una opcion: ");
            opcion = scanner.nextInt();

            if (opcion == 1) {
                mostrarFicha(nombreJugador, vida, energia, bloques, diamantes, tienePico);
            } else if (opcion == 2) {
                if (energia >= 10 && tienePico) {
                    bloques++;
                    energia -= 10;
                    System.out.println("");
                    System.out.println("Minaste un bloque.");
                    System.out.println("Bloques actuales: " + bloques);
                    System.out.println("Energia actual: " + energia);
                } else if (!tienePico) {
                    System.out.println("");
                    System.out.println("No puedes minar porque no tienes pico.");
                } else {
                    System.out.println("");
                    System.out.println("No tienes energia suficiente para minar.");
                }
            } else if (opcion == 3) {
                energia = descansar(energia, energiaMaxima);
            } else if (opcion == 4) {
                int puntajeTotal = calcularPuntaje(bloques, diamantes);
                mostrarPuntaje(puntajeTotal);
                mostrarRango(puntajeTotal);
            } else if (opcion == 5) {
                System.out.println("");
                System.out.println("Gracias por jugar Aventura de Bloques.");
            } else {
                System.out.println("");
                System.out.println("Opcion no valida. Intenta nuevamente.");
            }
        }

        scanner.close();
    }

    public static void mostrarBienvenida() {
        System.out.println("=== Aventura de Bloques ===");
        System.out.println("Bienvenido, explorador.");
        System.out.println("En esta aventura podras ver tu ficha, minar, descansar y revisar tu puntaje.");
        System.out.println("");
    }

    public static void mostrarMenu() {
        System.out.println("");
        System.out.println("=== Menu Principal ===");
        System.out.println("1. Ver ficha del jugador");
        System.out.println("2. Minar un bloque");
        System.out.println("3. Descansar");
        System.out.println("4. Ver puntaje y rango");
        System.out.println("5. Salir");
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

    public static void mostrarPuntaje(int puntajeTotal) {
        System.out.println("");
        System.out.println("=== Puntaje de Aventura ===");
        System.out.println("Puntaje total: " + puntajeTotal);
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

    public static int descansar(int energiaActual, int energiaMaxima) {
        System.out.println("");

        if (energiaActual >= energiaMaxima) {
            System.out.println("Tu energia ya esta completa.");
            return energiaActual;
        }

        energiaActual += 20;

        if (energiaActual > energiaMaxima) {
            energiaActual = energiaMaxima;
        }

        System.out.println("Descansaste y recuperaste energia.");
        System.out.println("Energia actual: " + energiaActual);

        return energiaActual;
    }
}
```

## Explicación sugerida

La lección inicia explicando que hasta ahora el programa ejecutaba acciones automáticamente.

Luego se presenta `Scanner` como una herramienta que permite leer datos escritos por el usuario.

Primero se importa `Scanner` con:

```java
import java.util.Scanner;
```

Después se crea el objeto `scanner` dentro del método `main`:

```java
Scanner scanner = new Scanner(System.in);
```

Luego se pide el nombre del jugador usando `System.out.print` y `scanner.nextLine()`.

Después se crea una variable `opcion` y un bucle `while` para repetir el menú hasta que el usuario escriba la opción 5.

El método `mostrarMenu` muestra las opciones disponibles.

Luego se usa `scanner.nextInt()` para leer la opción del usuario.

Con condicionales `if` y `else if`, el programa ejecuta una acción diferente según la opción seleccionada:

- Opción 1: mostrar ficha.
- Opción 2: minar un bloque.
- Opción 3: descansar.
- Opción 4: ver puntaje y rango.
- Opción 5: salir.
- Otra opción: mostrar mensaje de error.

Finalmente, se cierra el scanner con:

```java
scanner.close();
```

## Práctica para el estudiante

Agregar una opción 6 al menú para mostrar un consejo de juego.

Ejemplo:

```java
System.out.println("Consejo: mina bloques para aumentar tu puntaje, pero cuida tu energia.");
```

Para resolverlo, el estudiante debe modificar el método `mostrarMenu` y agregar un nuevo `else if`.

## Conexión con la siguiente lección

En la siguiente lección se iniciará la programación orientada a objetos creando una clase `Jugador`.
