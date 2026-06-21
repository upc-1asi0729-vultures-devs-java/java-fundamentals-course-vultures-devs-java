# Lección 10 - Proyecto final y errores comunes

## Objetivo de la lección

Integrar el proyecto final **Aventura de Bloques en Java**, agregar la acción de explorar cueva, probar el programa completo y revisar errores comunes de Java.

Al finalizar la lección, el estudiante debe tener una aplicación final por consola con menú interactivo, clase `Jugador`, inventario con `ArrayList` y acciones principales de aventura.

## Conceptos clave

- Integración del proyecto final.
- Menú interactivo.
- Clase `Jugador`.
- Objeto `jugador`.
- Métodos de instancia.
- `Scanner`.
- `ArrayList`.
- Condicionales.
- Bucles.
- Validación básica.
- Errores comunes de Java.

## Archivos de la lección

En esta lección se trabajan dos archivos:

```txt
Main.java
Jugador.java
```

`Main.java` controla el flujo principal del programa y el menú.

`Jugador.java` contiene los datos, acciones, inventario, puntaje y reglas del jugador.

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

## Código inicial - Jugador.java

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

        while (opcion != 6 && jugador.puedeContinuar()) {
            mostrarMenu();

            System.out.print("Elige una opcion: ");
            opcion = scanner.nextInt();

            if (opcion == 1) {
                jugador.mostrarEstado();
            } else if (opcion == 2) {
                jugador.minarBloque();
            } else if (opcion == 3) {
                jugador.explorarCueva();
            } else if (opcion == 4) {
                jugador.descansar();
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

        if (!jugador.puedeContinuar()) {
            System.out.println("");
            System.out.println("Tu jugador se quedo sin vida. Fin de la aventura.");
        }

        scanner.close();
    }

    public static void mostrarBienvenida() {
        System.out.println("=== Aventura de Bloques ===");
        System.out.println("Bienvenido, explorador.");
        System.out.println("En esta aventura podras minar, explorar, descansar y guardar objetos en tu inventario.");
        System.out.println("");
    }

    public static void mostrarMenu() {
        System.out.println("");
        System.out.println("=== Menu Principal ===");
        System.out.println("1. Ver estado del jugador");
        System.out.println("2. Minar bloque");
        System.out.println("3. Explorar cueva");
        System.out.println("4. Descansar");
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
        this.energia = 100;
        this.energiaMaxima = 100;
        this.bloques = 0;
        this.diamantes = 0;
        this.tienePico = true;
        this.inventario = new ArrayList<>();

        inventario.add("Pico de madera");
        inventario.add("Pan");
    }

    public void mostrarEstado() {
        System.out.println("");
        System.out.println("=== Estado del Jugador ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Vida: " + vida);
        System.out.println("Energia: " + energia);
        System.out.println("Bloques recolectados: " + bloques);
        System.out.println("Diamantes recolectados: " + diamantes);
        System.out.println("Tiene pico: " + tienePico);
        System.out.println("Objetos en inventario: " + inventario.size());
        System.out.println("Puntaje: " + calcularPuntaje());
        System.out.println("Rango: " + obtenerRango());
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

            if (bloques % 4 == 0) {
                diamantes++;
                inventario.add("Diamante");
                System.out.println("Encontraste un diamante especial.");
            }
        } else if (!tienePico) {
            System.out.println("No puedes minar porque no tienes pico.");
        } else {
            System.out.println("No tienes energia suficiente para minar. Descansa antes de continuar.");
        }
    }

    public void explorarCueva() {
        System.out.println("");

        if (energia >= 20 && vida > 0) {
            energia -= 20;
            vida -= 10;

            if (vida < 0) {
                vida = 0;
            }

            System.out.println("Exploraste una cueva misteriosa.");
            System.out.println("Gastaste 20 puntos de energia.");
            System.out.println("Perdiste 10 puntos de vida por el camino dificil.");

            if (energia % 2 == 0) {
                inventario.add("Cristal de cueva");
                System.out.println("Encontraste un Cristal de cueva y lo guardaste en tu inventario.");
            }

            System.out.println("Vida actual: " + vida);
            System.out.println("Energia actual: " + energia);
        } else if (vida <= 0) {
            System.out.println("No puedes explorar porque no tienes vida.");
        } else {
            System.out.println("No tienes energia suficiente para explorar. Necesitas al menos 20 puntos.");
        }
    }

    public void descansar() {
        System.out.println("");

        if (energia >= energiaMaxima && vida >= 100) {
            System.out.println("Tu vida y energia ya estan completas.");
        } else {
            energia += 25;
            vida += 5;

            if (energia > energiaMaxima) {
                energia = energiaMaxima;
            }

            if (vida > 100) {
                vida = 100;
            }

            System.out.println("Descansaste y recuperaste energia y vida.");
            System.out.println("Vida actual: " + vida);
            System.out.println("Energia actual: " + energia);
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

    public int calcularPuntaje() {
        int puntosPorBloque = 10;
        int puntosPorDiamante = 50;
        int puntosPorObjeto = 5;

        int puntajeBloques = bloques * puntosPorBloque;
        int puntajeDiamantes = diamantes * puntosPorDiamante;
        int puntajeInventario = inventario.size() * puntosPorObjeto;

        return puntajeBloques + puntajeDiamantes + puntajeInventario;
    }

    public String obtenerRango() {
        int puntajeTotal = calcularPuntaje();

        if (puntajeTotal >= 250) {
            return "Explorador maestro";
        } else if (puntajeTotal >= 120) {
            return "Explorador experto";
        } else if (puntajeTotal >= 50) {
            return "Explorador aprendiz";
        } else {
            return "Explorador principiante";
        }
    }

    public boolean puedeContinuar() {
        return vida > 0;
    }
}
```

## Errores comunes revisados

### 1. Olvidar el punto y coma

Incorrecto:

```java
System.out.println("Hola")
```

Correcto:

```java
System.out.println("Hola");
```

### 2. Escribir mal el nombre del archivo

Si la clase se llama:

```java
public class Jugador
```

El archivo debe llamarse:

```txt
Jugador.java
```

### 3. Olvidar importar Scanner

Si se usa `Scanner`, debe existir:

```java
import java.util.Scanner;
```

### 4. Olvidar importar ArrayList

Si se usa `ArrayList`, debe existir:

```java
import java.util.ArrayList;
```

### 5. Confundir asignación con comparación

Asignar valor:

```java
opcion = 1;
```

Comparar valores:

```java
opcion == 1
```

### 6. Olvidar llaves

Las llaves `{ }` indican dónde empieza y dónde termina un bloque de código.

### 7. Confundir mayúsculas y minúsculas

Java diferencia:

```java
String
```

de:

```java
string
```

También diferencia:

```java
Main
```

de:

```java
main
```

## Práctica final para el estudiante

Agregar una nueva acción al menú.

Ejemplo:

```txt
7. Comer pan
```

La acción puede recuperar vida si el jugador tiene pan en el inventario.

También se pueden agregar nuevos objetos, nuevos rangos o nuevas reglas para encontrar diamantes.

## Cierre del curso

Con esta lección se completa el proyecto **Aventura de Bloques en Java**.

El estudiante aplicó:

- Variables.
- Operadores.
- Condicionales.
- Bucles.
- Métodos.
- `Scanner`.
- Clases.
- Objetos.
- Constructores.
- `ArrayList`.

El proyecto final puede seguir mejorándose agregando nuevas acciones, objetos, enemigos, reglas o eventos.
