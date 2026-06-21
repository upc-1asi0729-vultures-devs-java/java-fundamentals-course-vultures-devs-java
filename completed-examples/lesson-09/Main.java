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
