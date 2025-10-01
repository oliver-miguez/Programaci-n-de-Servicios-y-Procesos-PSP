/**
 * Nivel 2 (opcional):
 * Ahora, el reto es poder configurar la longitud de la cadena de dominós, que debe
 * cumplir lo siguiente:
 * ● Modifica el programa del Nivel 1 para que el número total de hilos (N) se
 * pueda especificar como un argumento en la línea de comandos.
 * ● Si no se proporciona un argumento o este no es un número válido, el
 * programa deberá usar un valor por defecto de N=5.
 * ● El código debe funcionar correctamente para cualquier número de hilos N ≥ 1.
 */

public class Domino2 extends Thread {
    int numero;
    int numMaxHilos;
    Domino2 nuevo_hilo;
    public Domino2(int n, int numMaxHilos){
        this.numero = n;
        this.numMaxHilos = numMaxHilos;


    }

    @Override
    public void run(){
        nuevo_hilo = new Domino2(numero + 1,numMaxHilos);
        int numero_domino = numMaxHilos + 1;

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
        return (int) (Math.random() * n) + 100;
    }

}

