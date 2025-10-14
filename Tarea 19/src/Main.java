import java.util.Scanner;

/**
 * Crear un programa en java que utilice 5 hilos que representan el número de vocales totales.
 * Para contar el número de vocales que hay en un determinado texto
 * (que puede ser introducido por teclado o estar en un fichero),
 * cada hilo se encargará de contar una vocal diferente,
 * actualizando todos los hilos una misma variable que indica el total de vocales del texto.
 * Los hilos se deben ejecutar concurrentemente.
 */
public class Main {
    /**
     * Metodo principal del programa
     * @param args no usamos
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un texto");
        String texto = sc.nextLine(); // Texto a calcula total de vocales

        // Crea y lanza los hilos

        Hilo h1 = new Hilo(texto,'a');
        Hilo h2 = new Hilo(texto,'e');
        Hilo h3 = new Hilo(texto,'i');
        Hilo h4 = new Hilo(texto,'o');
        Hilo h5 = new Hilo(texto,'u');

        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();

        // Para verificar que funcione
        try{
            h1.join();
            h2.join();
            h3.join();
            h4.join();
            h5.join();
        }catch (InterruptedException e){
            System.out.println("Hilo interrumpido");
        }
        System.out.println("Total de vocales que tiene la palabra: "+ Contador.contador);
    }
}