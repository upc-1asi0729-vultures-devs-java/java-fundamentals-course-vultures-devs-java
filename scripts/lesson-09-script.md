# Lección 09 - Inventario con ArrayList

## Objetivo de la lección

Explicar qué es `ArrayList` en Java y usarlo para crear un inventario dentro de la clase `Jugador`.

Al finalizar la lección, el estudiante debe poder crear una lista dinámica, agregar elementos y recorrerla para mostrar su contenido.

## Conceptos clave

- `ArrayList`.
- `import java.util.ArrayList`.
- Lista dinámica.
- `ArrayList<String>`.
- `add()`.
- `size()`.
- `get()`.
- Bucle `for`.
- Inventario del jugador.

## Archivos de la lección

En esta lección se trabajan dos archivos:

```txt
Main.java
Jugador.java
```

`Main.java` controla el menú principal.

`Jugador.java` contiene los datos, acciones e inventario del jugador.

## Código inicial - Main.java

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

## Código inicial - Jugador.java

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

        while (opcion != 6) {
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
                jugador.verInventario();
            } else if (opcion == 6) {
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
        System.out.println("En esta aventura podras ver tu ficha, minar, descansar, revisar tu puntaje y ver tu inventario.");
        System.out.println("");
    }

    public static void mostrarMenu() {
        System.out.println("");
        System.out.println("=== Menu Principal ===");
        System.out.println("1. Ver ficha del jugador");
        System.out.println("2. Minar un bloque");
        System.out.println("3. Descansar");
        System.out.println("4. Ver puntaje y rango");
        System.out.println("5. Ver inventario");
        System.out.println("6. Salir");
    }
}
```

## Código final - Jugador.java

```java
import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private int vida;
    private int energia;
    private int energiaMaxima;
    private int bloques;
    private int diamantes;
    private boolean tienePico;
    private ArrayList<String> inventario;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.vida = 100;
        this.energia = 80;
        this.energiaMaxima = 100;
        this.bloques = 5;
        this.diamantes = 2;
        this.tienePico = true;
        this.inventario = new ArrayList<>();

        inventario.add("Pico de madera");
        inventario.add("Mapa inicial");
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
        System.out.println("Objetos en inventario: " + inventario.size());
    }

    public void minarBloque() {
        System.out.println("");

        if (energia >= 10 && tienePico) {
            bloques++;
            energia -= 10;
            inventario.add("Bloque de piedra");

            System.out.println("Minaste un bloque.");
            System.out.println("Se agrego un Bloque de piedra al inventario.");
            System.out.println("Bloques actuales: " + bloques);
            System.out.println("Energia actual: " + energia);

            if (bloques % 3 == 0) {
                diamantes++;
                inventario.add("Diamante");
                System.out.println("Encontraste un diamante especial.");
            }
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

    public void verInventario() {
        System.out.println("");
        System.out.println("=== Inventario del Jugador ===");

        if (inventario.size() == 0) {
            System.out.println("El inventario esta vacio.");
        } else {
            for (int i = 0; i < inventario.size(); i++) {
                System.out.println((i + 1) + ". " + inventario.get(i));
            }
        }
    }
}
```

## Explicación sugerida

La lección inicia explicando que el jugador necesita un inventario para guardar objetos recolectados.

Primero se importa `ArrayList` en `Jugador.java`:

```java
import java.util.ArrayList;
```

Luego se crea el atributo:

```java
private ArrayList<String> inventario;
```

Después se inicializa el inventario dentro del constructor:

```java
this.inventario = new ArrayList<>();
```

Luego se agregan objetos iniciales con `add()`:

```java
inventario.add("Pico de madera");
inventario.add("Mapa inicial");
```

Después se mejora el método `mostrarFicha` usando `inventario.size()` para mostrar cuántos objetos tiene el jugador.

También se modifica `minarBloque` para agregar objetos al inventario cada vez que el jugador mina.

Se usa:

```java
inventario.add("Bloque de piedra");
```

Además, se agrega una regla donde cada cierto número de bloques el jugador puede encontrar un diamante especial.

Finalmente, se crea el método `verInventario`, que recorre el `ArrayList` usando un bucle `for` y muestra cada objeto con `inventario.get(i)`.

En `Main.java`, se agrega una nueva opción al menú:

```txt
5. Ver inventario
6. Salir
```

Y se llama al método:

```java
jugador.verInventario();
```

## Práctica para el estudiante

Agregar un nuevo objeto inicial al inventario.

Ejemplo:

```java
inventario.add("Manzana");
```

También se puede cambiar el objeto agregado al minar.

Ejemplo:

```java
inventario.add("Bloque de carbon");
```

Luego ejecutar el programa y revisar cómo cambia el inventario.

## Conexión con la siguiente lección

En la siguiente lección se integrará todo el proyecto final y se revisarán errores comunes para cerrar la aventura de bloques.
