
/**
 * Crea el efecto dominó utilizando hilos
 */
public class Domino extends Thread {
    int numero;
    Domino nuevo_hilo;
    public Domino(int n){
        this.numero = n;


    }

    @Override
    public void run(){
        nuevo_hilo = new Domino(numero + 1);
        int numero_domino = 6;

        if (numero<5){
            nuevo_hilo.start();
        }

        for(int i = 0 ; i < numero_domino; i++){
            System.out.println("[Hilo - "+ numero +"] Iteración "+ i );
            int tiempo = numero();
            try {
                Thread.sleep(tiempo);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            nuevo_hilo.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Hilo - " + numero + " finalizado");



    }

    /**
     * Genera un número del 100 al 600 para el tiempo de espera de cada hilo lanzado
     * @return el tiempo de espera de cada hilo
     */
    public static int numero() {
        int n = 500;
        int numero = (int) (Math.random() * n) + 100;
        return numero;
    }

}

