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
