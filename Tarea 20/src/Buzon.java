public class Buzon{
    String mensaje_buzon = ""; // Crea un string para almacenar el mensaje

    /**
     * Añade un mensaje al buzón
     */
    public synchronized void enviarMensaje(String mensaje){
        while(!mensaje_buzon.isEmpty()){ // Mientras el buzón este lleno
            try {
                wait(); // Pausa al hilo hasta que un lector lea el mensaje
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // Si el contenedor está vacío
        mensaje_buzon = mensaje; // Creamos el nuevo mensaje
        System.out.println("Mensaje que se escribirá en el buzón: ("+mensaje_buzon+")");
        System.out.println("Mensaje escrito correctamente");
        notifyAll(); // Llama a los lectores para leer el nuevo mensaje
    }

    /**
     * Permite leer el mensaje del buzón
     */
    public synchronized  void leerMensaje(){
        while(mensaje_buzon.isEmpty()){ // Mientras el buzón este vacío
            try {
                wait(); // Bloquea el hilo para que un hilo escritor escriba un mensaje
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // Si el buzón está lleno
        System.out.println("Mensaje para leer ("+mensaje_buzon+")");
        mensaje_buzon = ""; // Reinicia el mensaje
        notifyAll(); // Activa a los escritores para escribir un nuevo mensaje
    }



}
