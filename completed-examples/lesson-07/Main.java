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
