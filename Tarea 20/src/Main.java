/**
 * Crea una aplicación en Java que simule el funcionamiento de un buzón de correo (compartido) entre varios hilos lectores y escritores.
 * El buzón solo puede almacenar un mensaje a la vez. Tened en cuenta que:

 * Un hilo escritor solo puede escribir en el buzón si este está vacío.
 * Un hilo lector solo puede leer del buzón si este contiene un mensaje.
 * Si un escritor intenta escribir cuando el buzón está lleno, debe esperar hasta que el buzón sea leído (y esté vacío).
 * Si un lector intenta leer cuando el buzón está vacío, debe esperar hasta que haya un mensaje disponible.
 */
public class Main {
    /**
     * Metodo principal del programa
     * @param args no usamos
     */
    public static void main(String[] args) {
        Buzon buzon = new Buzon();
        // Crea los hilos
        new Escribir("Hola, este es un mensaje que se guardó en el buzón", buzon).start();
        try { Thread.sleep(1000); } catch (InterruptedException e) {} // Para ver mejor el flujo de los hilos

        new Leer(buzon).start();
        try { Thread.sleep(1000); } catch (InterruptedException e) {} // Para ver mejor el flujo de los hilos

        new Escribir("Hola, otra prueba de mensaje",buzon).start();
        try { Thread.sleep(1000); } catch (InterruptedException e) {} // Para ver mejor el flujo de los hilos

        new Leer(buzon).start();
        try { Thread.sleep(1000); } catch (InterruptedException e) {} // Para ver mejor el flujo de los hilos

    }
}