public class Main {
    public static void main(String[] args) {
        // Lanza los 3 hilos
        Hilo hilo3 = new Hilo("Hilo3");
        hilo3.start();
        try {
            hilo3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Hilo hilo2 = new Hilo("Hilo2");
        hilo2.start();
        try {
            hilo2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Hilo hilo1 = new Hilo("Hilo1");
        hilo1.start();
        try {
            hilo1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Programa finalizado+");
    }
}