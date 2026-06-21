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
    }
}
