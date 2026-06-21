# Lección 02 - Variables y datos del jugador

## Objetivo de la lección

Explicar qué son las variables en Java y usarlas para guardar información inicial del jugador de la aventura.

Al finalizar la lección, el estudiante debe poder crear variables de tipo `String`, `int` y `boolean`, y mostrarlas en consola usando `System.out.println`.

## Conceptos clave

- Variable.
- Tipo de dato.
- `String`.
- `int`.
- `boolean`.
- Asignación con `=`.
- Concatenación con `+`.
- `System.out.println`.

## Código inicial

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Aventura de Bloques ===");
        System.out.println("Bienvenido, explorador.");
        System.out.println("En este curso aprenderas Java creando una aventura de bloques.");
        System.out.println("Tu mision sera minar, explorar y guardar objetos en un inventario.");
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

## Explicación sugerida

La lección inicia explicando que una variable es como una caja donde se guarda información.

Luego se conecta el concepto con la aventura de bloques: el jugador necesita tener nombre, vida, energía, recursos y herramientas.

Después se presentan tres tipos de datos:

- `String` para guardar texto.
- `int` para guardar números enteros.
- `boolean` para guardar valores de verdadero o falso.

Se crea la variable `nombreJugador` usando `String`.

Luego se crean las variables `vida`, `energia` y `bloques` usando `int`.

Después se crea la variable `tienePico` usando `boolean`.

Finalmente, se muestran las variables en consola usando `System.out.println` y el operador `+` para unir texto con valores.

## Práctica para el estudiante

Modificar los datos iniciales del jugador.

Ejemplo:

```java
String nombreJugador = "Luna";
int vida = 100;
int energia = 95;
int bloques = 5;
boolean tienePico = true;
```

Luego ejecutar el programa y observar cómo cambia la ficha del jugador en consola.

## Conexión con la siguiente lección

En la siguiente lección se aprenderá a usar operadores para calcular puntaje, modificar recursos y crear expresiones relacionadas con la aventura.
