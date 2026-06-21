# Lección 08 - Clases, objetos y constructores

## Objetivo de la lección

Explicar los conceptos básicos de programación orientada a objetos en Java creando una clase `Jugador`.

Al finalizar la lección, el estudiante debe poder crear una clase, definir atributos, crear un constructor, crear métodos y usar un objeto desde `Main.java`.

## Conceptos clave

- Clase.
- Objeto.
- Atributos.
- Constructor.
- `this`.
- `new`.
- Métodos de instancia.
- `private`.
- Separación de responsabilidades entre `Main.java` y `Jugador.java`.

## Archivos de la lección

En esta lección se trabajan dos archivos:

```txt
Main.java
Jugador.java
```

`Main.java` controla el flujo principal del programa y el menú.

`Jugador.java` contiene los datos y acciones del jugador.

## Código inicial - Main.java

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

## Código inicial - Jugador.java

```java
public class Jugador {
    // En esta lección construiremos esta clase paso a paso.
}
```

## Código final - Main.java

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        mostrarBienvenida();

        System.out.print("Escribe el nombre de tu jugador: ");
        String nombreJugador = scanner.nextLine();

        Jugador jugador = new Jugador(nombreJugador);

        int opcion = 0;

        while (opcion != 5) {
            mostrarMenu();

            System.out.print("Elige una opcion: ");
            opcion = scanner.nextInt();

            if (opcion == 1) {
                jugador.mostrarFicha();
            } else if (opcion == 2) {
                jugador.minarBloque();
            } else if (opcion == 3) {
                jugador.descansar();
            } else if (opcion == 4) {
                jugador.mostrarPuntajeYRango();
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
}
```

## Código final - Jugador.java

```java
public class Jugador {
    private String nombre;
    private int vida;
    private int energia;
    private int energiaMaxima;
    private int bloques;
    private int diamantes;
    private boolean tienePico;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.vida = 100;
        this.energia = 80;
        this.energiaMaxima = 100;
        this.bloques = 5;
        this.diamantes = 2;
        this.tienePico = true;
    }

    public void mostrarFicha() {
        System.out.println("");
        System.out.println("=== Ficha del Jugador ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Vida: " + vida);
        System.out.println("Energia: " + energia);
        System.out.println("Bloques recolectados: " + bloques);
        System.out.println("Diamantes recolectados: " + diamantes);
        System.out.println("Tiene pico: " + tienePico);
    }

    public void minarBloque() {
        System.out.println("");

        if (energia >= 10 && tienePico) {
            bloques++;
            energia -= 10;

            System.out.println("Minaste un bloque.");
            System.out.println("Bloques actuales: " + bloques);
            System.out.println("Energia actual: " + energia);
        } else if (!tienePico) {
            System.out.println("No puedes minar porque no tienes pico.");
        } else {
            System.out.println("No tienes energia suficiente para minar.");
        }
    }

    public void descansar() {
        System.out.println("");

        if (energia >= energiaMaxima) {
            System.out.println("Tu energia ya esta completa.");
        } else {
            energia += 20;

            if (energia > energiaMaxima) {
                energia = energiaMaxima;
            }

            System.out.println("Descansaste y recuperaste energia.");
            System.out.println("Energia actual: " + energia);
        }
    }

    public int calcularPuntaje() {
        int puntosPorBloque = 10;
        int puntosPorDiamante = 50;

        int puntajeBloques = bloques * puntosPorBloque;
        int puntajeDiamantes = diamantes * puntosPorDiamante;

        return puntajeBloques + puntajeDiamantes;
    }

    public void mostrarPuntajeYRango() {
        int puntajeTotal = calcularPuntaje();

        System.out.println("");
        System.out.println("=== Puntaje de Aventura ===");
        System.out.println("Puntaje total: " + puntajeTotal);

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

La lección inicia explicando que el código del jugador puede organizarse mejor usando programación orientada a objetos.

Primero se presenta una clase como un molde.

Luego se crea el archivo `Jugador.java` y dentro se define la clase `Jugador`.

Después se agregan atributos privados para guardar los datos del jugador:

- `nombre`
- `vida`
- `energia`
- `energiaMaxima`
- `bloques`
- `diamantes`
- `tienePico`

Luego se crea un constructor:

```java
public Jugador(String nombre)
```

El constructor permite crear un jugador con valores iniciales.

Se usa `this` para diferenciar los atributos del objeto y los valores recibidos.

Después se agregan métodos de instancia:

- `mostrarFicha`
- `minarBloque`
- `descansar`
- `calcularPuntaje`
- `mostrarPuntajeYRango`

Finalmente, en `Main.java` se crea un objeto:

```java
Jugador jugador = new Jugador(nombreJugador);
```

Y se reemplazan las acciones del menú por llamadas al objeto:

```java
jugador.mostrarFicha();
jugador.minarBloque();
jugador.descansar();
jugador.mostrarPuntajeYRango();
```

## Práctica para el estudiante

Modificar los valores iniciales del constructor.

Ejemplo:

```java
this.bloques = 0;
this.energia = 100;
```

Luego ejecutar el programa y observar cómo cambia la ficha inicial del jugador.

## Conexión con la siguiente lección

En la siguiente lección se aprenderá a usar `ArrayList` para crear un inventario donde el jugador pueda guardar objetos recolectados.
