# Lección 01 - ¿Qué es Java y qué vamos a crear?

## Objetivo de la lección

Explicar qué es Java, qué es una aplicación de consola y crear el primer programa del curso usando `System.out.println`.

Al finalizar la lección, el estudiante debe poder ejecutar un programa Java simple que muestre mensajes en consola.

## Conceptos clave

- Java.
- Aplicación de consola.
- Archivo `Main.java`.
- Método `main`.
- Instrucción `System.out.println`.
- Llaves `{ }`.
- Punto y coma `;`.

## Código inicial

```java
public class Main {
    public static void main(String[] args) {
        // En esta lección escribiremos nuestro primer mensaje en Java.
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
    }
}
```

## Explicación sugerida

La lección inicia explicando que Java es un lenguaje de programación que permite escribir instrucciones para que la computadora las ejecute.

Luego se presenta la consola como una pantalla de texto donde el programa puede mostrar mensajes.

Después se abre myCompiler y se muestra el archivo `Main.java`.

Se explica que `public class Main` representa la clase principal del programa y que el método `main` es el punto donde Java empieza a ejecutar las instrucciones.

Luego se escribe la instrucción `System.out.println`, indicando que sirve para mostrar texto en consola.

También se explica que el texto va entre comillas y que las instrucciones en Java suelen terminar con punto y coma.

## Práctica para el estudiante

Modificar el mensaje de bienvenida para incluir un nombre de explorador.

Ejemplo:

```java
System.out.println("Bienvenido, Alex el constructor.");
```

Agregar también una misión inventada.

Ejemplo:

```java
System.out.println("Tu primera mision sera encontrar un diamante.");
```

## Conexión con la siguiente lección

En la siguiente lección se aprenderá a guardar información del jugador usando variables, como nombre, vida, energía y cantidad de bloques.
