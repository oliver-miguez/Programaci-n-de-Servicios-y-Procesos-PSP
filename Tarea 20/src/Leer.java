/**
 * Permite leer el mensaje del buzón cuando este tenga uno
 */
public class Leer extends Thread {

    Buzon buzon;

    public Leer(Buzon buzon){
        this.buzon = buzon;
    }

    /**
     * Metodo que ejecutará el hilo de lectura
     */
    @Override
    public void run(){
        buzon.leerMensaje();
    }

}
