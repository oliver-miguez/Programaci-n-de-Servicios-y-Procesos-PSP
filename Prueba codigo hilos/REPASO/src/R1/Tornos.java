package R1;

/**
 * Clase del hilo Torno
 */
public class Tornos extends Thread{
    int contadorEspectadores = 0;
    /**
     * Lo que ejecuta cada hilo
     */
    @Override
    public void run(){
        for(int i = 0; i < 1000; i++){ // suma en cada hilo 1000 veces
            try {
                Thread.sleep(randomNumero()); // Cada usuario tiene un tiempo diferente para añadir la tarjeta
                System.out.println("Aumentando contador:"+contadorEspectadores);
                contadorEspectadores++; // aumenta el número de espectadores
            } catch (InterruptedException e) {
                System.out.println("Error en el catch del run:"+e.getMessage());
            }
        }
        Espectadores.sumarEspectadores(contadorEspectadores);
    }

    /**
     * Genera un número aleatorio para hacer un sleep
     * @return el valor aleatorio
     */
    public static long randomNumero(){
        long num = Math.round(Math.random()*100)+1;
        return num;
    }
}
