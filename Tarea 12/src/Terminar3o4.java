/**
 * Clase para mostrar los numeros que finalizan en 3 o 4
 */
public class Terminar3o4 extends Thread {
    /**
     * Crea el hilo
     */
    public void run(){
        termina3o4();
    }

    /**
     * Verifica si el número termina en 3 o 4
     */
    public static void termina3o4(){
        for(int i = 0; i < 1923; i++){
            int ultimoNumero = i % 10;
            if(ultimoNumero == 3 || ultimoNumero == 4){
                System.out.println(i);
            }
        }
    }
}
