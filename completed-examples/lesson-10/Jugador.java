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
