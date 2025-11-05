/**
 * El número de procesadores disponibles para la JVM.
 */
public class Tarea02_2 {
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        System.out.println(rt.availableProcessors());
    }
}
