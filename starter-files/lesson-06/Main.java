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

        System.out.println("");
        System.out.println("=== Decision de Aventura ===");

        if (vida <= 0) {
            System.out.println("El jugador no tiene vida. La aventura ha terminado.");
        } else if (puedeExplorar && tienePico) {
            System.out.println("El jugador puede explorar la cueva y seguir minando.");
        } else if (energiaDespuesDeMinar > 0) {
            System.out.println("El jugador tiene poca energia. Es mejor descansar antes de explorar.");
        } else {
            System.out.println("El jugador no tiene energia. Debe descansar urgentemente.");
        }

        System.out.println("");
        System.out.println("=== Rango del Jugador ===");

        if (puntajeTotal >= 150) {
            System.out.println("Rango: Explorador experto");
        } else if (puntajeTotal >= 80) {
            System.out.println("Rango: Explorador aprendiz");
        } else {
            System.out.println("Rango: Explorador principiante");
        }

        System.out.println("");
        System.out.println("=== Minado con for ===");

        int energiaActual = energiaDespuesDeMinar;
        int bloquesActuales = bloques;
        int bloquesPorMinar = 3;
        int costoEnergiaPorBloque = 10;

        for (int turno = 1; turno <= bloquesPorMinar; turno++) {
            if (energiaActual >= costoEnergiaPorBloque) {
                bloquesActuales++;
                energiaActual -= costoEnergiaPorBloque;
                System.out.println("Turno " + turno + ": bloque minado.");
                System.out.println("Bloques actuales: " + bloquesActuales);
                System.out.println("Energia actual: " + energiaActual);
            } else {
                System.out.println("Turno " + turno + ": no hay energia suficiente para minar.");
            }
        }

        System.out.println("");
        System.out.println("=== Descanso con while ===");

        while (energiaActual < energia) {
            energiaActual += 10;

            if (energiaActual > energia) {
                energiaActual = energia;
            }

            System.out.println("Descansando... Energia actual: " + energiaActual);
        }

        System.out.println("");
        System.out.println("=== Estado despues de los bucles ===");
        System.out.println("Bloques finales: " + bloquesActuales);
        System.out.println("Energia final: " + energiaActual);
    }
}
