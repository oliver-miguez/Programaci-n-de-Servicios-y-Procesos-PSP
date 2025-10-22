package R2;

/**
 * Main del segundo ejercicio de Repaso R2
 */
public class Main {
    /**
     * Metodo principal del programa
     * @param args no usamos
     */
    public static void main(String[] args) {
        // Crea un Hilo que crea todos los hilos de las operaciones
        Operaciones operacion1 = new Operaciones(1);

        // Los ejecuta
        operacion1.start();

    }
}
