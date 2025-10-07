
/**
 * Funcionalidades que ejecutan los hilos
 */
public class Hilos extends Thread {
    public Hilos(String str){
        super(str);
    }

    /**
     * Lanza el proceso
     */
    @Override
    public void run(){
        try {
            iteracion();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Muestra 10 veces la iteración y su nombre
     */
    public void iteracion() throws InterruptedException {
        for(int i = 0; i < 11; i++){
            System.out.println("Vuelta "+ i + " nombre: " + getName());
            Thread.sleep(tiempoAleatorio());
        }
    }

    /**
     * Devuelve un valor aleatorio
     */
    public static int tiempoAleatorio(){
        return (int) ((Math.random() * 10) + 1)*1000;
    }
}
