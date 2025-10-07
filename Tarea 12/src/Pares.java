/**
 * Lanza un hilo que suma los números pares del 1 al 1923
 */
public class Pares extends Thread{

    /**
     * Crea el hilo
     */
    public void run(){
        sumaPares(); // Ejecuta la suma
    }

    /**
     * Suma los números pares del 1 al 1923
     */
    public static void sumaPares(){
        int sumaPares = 0;
        for(int i = 0; i < 1923; i++){
            if(i % 2 == 0){
                sumaPares += i; // Recoge la suma de los pares
            }
        }
        System.out.println(sumaPares);
    }
}
