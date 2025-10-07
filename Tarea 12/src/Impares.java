/**
 * Lanza un hilo que suma los números impares del 1 al 1923
 */
public class Impares extends Thread{

    /**
     * Crea el hilo
     */
    public void run(){
        sumaImpares(); // Ejecuta la suma
    }

    /**
     * Suma los números pares del 1 al 1923
     */
    public static void sumaImpares(){
        int sumaImpares = 0;
        for(int i = 0; i < 1923; i++){
            if(i % 2 != 0){
                sumaImpares += i; // Recoge la suma de los impares
            }
        }
        System.out.println(sumaImpares);
    }
}
