/**
 * Realiza un programa en java que ejecute tres hilos de forma concurrente.
 * Uno de ellos debe sumar los números pares del 1 al 1923, otro los impares,
 * y otro, los que terminen en tres o en cuatro.
 */
public class Main {
    public static void main(String[] args) {
        new Pares().start();
        new Impares().start();
        new Terminar3o4().start();
    }
}