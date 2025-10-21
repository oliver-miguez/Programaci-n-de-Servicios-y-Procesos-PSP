package R1;

/**
 * Main del primer ejercicio de la tarea de repaso
 */
public class Main {
    /**
     * Metodo principal del programa
     * @param args no usamos
     */
    public static void main(String[] args) {
        // Crea 4 hilos "Tornos"
        Tornos torno1 = new Tornos();
        Tornos torno2 = new Tornos();
        Tornos torno3 = new Tornos();
        Tornos torno4 = new Tornos();

        // Ejecuta los hilos
        torno1.start();
        torno2.start();
        torno3.start();
        torno4.start();

        try {
            torno1.join();
            torno2.join();
            torno3.join();
            torno4.join();
        } catch (InterruptedException e) {
            System.out.println("Error en los join:"+e.getMessage());
        }
        //Muestra el valor final
        System.out.println("Valor final:"+Espectadores.totalEspectadores);

    }
}