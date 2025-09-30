/**
 * Crea un hilo que realice el cálculo de los primeros N números de la sucesión de Fibonacci.
 * La sucesión de Fibonacci comienza con los números 1 y 1, y el siguiente elemento es la suma
 * de los dos elementos anteriores. Así, la sucesión de Fibonacci sería 1, 1, 2, 3, 5, 8, 13, 21, 34, 55…
 * El parámetro N será indicado cuando se llame al constructor de la clase Thread correspondiente.
 */
public class Main {
    public static void main(String[] args) {
        new ThreadClase(10).start();
    }
}