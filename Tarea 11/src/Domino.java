
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
        }


        try {
            nuevo_hilo.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Hilo - " + numero + " finalizado");

    }

}

