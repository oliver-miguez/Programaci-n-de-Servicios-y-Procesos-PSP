/**
 * Lanza los hilos
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Ingresos ingresos = new Ingresos();
        ingresos.start();
        ingresos.join();

        new Extracciones().start();
    }
}