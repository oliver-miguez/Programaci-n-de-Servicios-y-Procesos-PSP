/**
 * Hilo que permite escribir un mensaje solo cuando el buzón este vacío
 */
public class Escribir extends Thread {

    String mensaje; // Mensaje que se escribe en el buzón
    Buzon buzon;

    // Constructor
    public Escribir(String mensaje, Buzon buzon){
        this.mensaje = mensaje;
        this.buzon = buzon;
    }

    /**
     * Metodo que escribe el texto solo si el buzón está vacío
     */
    @Override
    public void run(){
        buzon.enviarMensaje(mensaje); // Escribe un mensaje al buzón
    }

}
