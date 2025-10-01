/**
 * Simular un efecto dominó utilizando hilos. La caída de la
 * primera ficha (el primer hilo) debe provocar la caída de la siguiente, y así
 * sucesivamente, creando una reacción en cadena. La misión es programar esta
 * secuencia de ejecución concurrente y sincronizada.
 * @author Oliver Miguez Alonso
 */
public class Main {
    public static void main(String[] args) {
        new Domino(1).start();

    }
}