/**
 * Permite hacer una cuenta de todas las vocales que registre cada hilo
 */
public class Contador {

    // Variables
    public static int contador = 0;

    /**
     * Metodo que amplía el contador de vocales
     */
    public static synchronized void contador(){
        contador+=1;
    }
}
