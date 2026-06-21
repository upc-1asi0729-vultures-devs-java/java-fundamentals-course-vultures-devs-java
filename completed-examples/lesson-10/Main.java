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
