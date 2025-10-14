/**
 * Crea una aplicación en Java que simule el funcionamiento de un buzón de correo (compartido) entre varios hilos lectores y escritores.
 * El buzón solo puede almacenar un mensaje a la vez. Tened en cuenta que:
 * Un hilo escritor solo puede escribir en el buzón si este está vacío.
 * Un hilo lector solo puede leer del buzón si este contiene un mensaje.
 * Si un escritor intenta escribir cuando el buzón está lleno, debe esperar hasta que el buzón sea leído (y esté vacío).
 * Si un lector intenta leer cuando el buzón está vacío, debe esperar hasta que haya un mensaje disponible.

 * Implementa las clases necesarias para que varios hilos lectores y escritores interactúen de manera concurrente con el buzón.
 * Asegúrate de utilizar mecanismos de sincronización para evitar condiciones de carrera. Para simular la operación,
 * cada escritor debe enviar un mensaje de texto al buzón, y los lectores deben leer ese mensaje. Una vez que un mensaje es leído,
 * el buzón se vacía y queda disponible para un nuevo mensaje.
 */
public class Main {
    /**
     * Metodo principal del programa
     * @param args no usamos
     */
    public static void main(String[] args) {

    }
}