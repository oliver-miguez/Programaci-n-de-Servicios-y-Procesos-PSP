/**
 * Haz un programa en Java que cree cuatro hilos y los ejecute. Cada hilo debe:
 * Escribir diez veces el número de iteración y su nombre.
 * Después de escribir su nombre, bloquearse durante un tiempo aleatorio de entre 1 y 10 segundos.
 * Volver a estar disponible para su ejecución después del tiempo de espera.
 * Prueba también lo siguiente:
 * Asigna diferentes prioridades a los hilos (por ejemplo, un hilo con prioridad mínima, dos con prioridad media y uno con prioridad máxima).
 * Analiza si los hilos con mayor prioridad tienden a ejecutarse más frecuentemente que los de menor prioridad, aunque el tiempo de espera aleatorio puede afectar el resultado.
 * Imprime en cada iteración:
 * Nombre del hilo: <nombre>, Iteración: <número>, Prioridad: <prioridad>
 * Compara los resultados y fíjate si la prioridad afecta la planificación de los hilos en Java.
 */
public class Main {
    public static void main(String[] args) {
        new Hilos("Pepe").start();
        new Hilos("Carlos").start();
        new Hilos("Juan").start();
        new Hilos("Arturo").start();

    }
}