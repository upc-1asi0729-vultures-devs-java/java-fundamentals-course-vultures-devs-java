public class Main {
    public static void main(String[] args) {
        String nombreJugador = "Alex";
        int vida = 100;
        int energia = 80;
        int bloques = 5;
        int diamantes = 2;
        boolean tienePico = true;

        mostrarBienvenida();
        mostrarFicha(nombreJugador, vida, energia, bloques, diamantes, tienePico);

        int puntajeTotal = calcularPuntaje(bloques, diamantes);

        System.out.println("");
        System.out.println("=== Puntaje de Aventura ===");
        System.out.println("Puntaje total: " + puntajeTotal);

        mostrarRango(puntajeTotal);

        System.out.println("");
        System.out.println("=== Acciones del Jugador ===");

        bloques = minarBloques(bloques, 3);
        energia = consumirEnergia(energia, 30);
        energia = descansar(energia, 80);

        System.out.println("");
        System.out.println("=== Estado Final ===");
        mostrarFicha(nombreJugador, vida, energia, bloques, diamantes, tienePico);
    }

    public static void mostrarBienvenida() {
        System.out.println("=== Aventura de Bloques ===");
        System.out.println("Bienvenido, explorador.");
        System.out.println("En este curso aprenderas Java creando una aventura de bloques.");
        System.out.println("Tu mision sera minar, explorar y guardar objetos en un inventario.");
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

    public static int minarBloques(int bloquesActuales, int cantidad) {
        System.out.println("");
        System.out.println("Minando bloques...");

        for (int turno = 1; turno <= cantidad; turno++) {
            bloquesActuales++;
            System.out.println("Turno " + turno + ": bloque minado.");
            System.out.println("Bloques actuales: " + bloquesActuales);
        }

        return bloquesActuales;
    }

    public static int consumirEnergia(int energiaActual, int costo) {
        energiaActual -= costo;

        if (energiaActual < 0) {
            energiaActual = 0;
        }

        System.out.println("");
        System.out.println("Energia despues de la accion: " + energiaActual);

        return energiaActual;
    }

    public static int descansar(int energiaActual, int energiaMaxima) {
        System.out.println("");
        System.out.println("Descansando para recuperar energia...");

        while (energiaActual < energiaMaxima) {
            energiaActual += 10;

            if (energiaActual > energiaMaxima) {
                energiaActual = energiaMaxima;
            }

            System.out.println("Energia actual: " + energiaActual);
        }

        return energiaActual;
    }
}
