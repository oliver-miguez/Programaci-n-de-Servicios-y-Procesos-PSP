/**
 * La memoria total, la memoria libre y la memoria en uso expresados en MiB.
 */
public class Tarea02_1 {
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime(); //iniciar la clase RunTime

        //Utilizando metodos Runtime
        System.out.println("Memoria Libre: "+ rt.freeMemory());
        System.out.println("Memoria Total: "+ rt.totalMemory());
        System.out.println("Memoria En Uso: "+ rt.maxMemory());
    }
}