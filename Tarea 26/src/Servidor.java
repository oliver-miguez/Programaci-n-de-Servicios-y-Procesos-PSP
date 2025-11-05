import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Modifica el puerto de conexión al 6666.
 * Programa una "conversación" donde el cliente envíe 3 mensajes "hardcodeados" (ej. "Mensaje 1...") y el servidor lea esos 3 mensajes.
 * Tras recibir los 3 mensajes, el servidor deberá responder con otros 3 mensajes "hardcodeados" (ej. "Respuesta 1...").
 */
public class Servidor {
    public static void main(String[] args) {
        try {
            InetSocketAddress dir = new InetSocketAddress(6666);
            ServerSocket servidor = new ServerSocket();

            servidor.bind(dir);

            System.out.println("Esperando a conectarse...");
            Socket socket = servidor.accept();
            System.out.println("Cliente Conectado");

            PrintWriter escritor = new PrintWriter(socket.getOutputStream(),true);
            escritor.println("Mensaje 1 enviado");
            escritor.println("Mensaje 2 enviado");
            escritor.println("Mensaje 3 enviado");

            BufferedReader lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String mensaje = lector.readLine();
            String mensaje2 = lector.readLine();
            String mensaje3 = lector.readLine();

            System.out.println("Cliente dice: "+ mensaje+ ", "+ mensaje2+ ", "+ mensaje3);

            socket.close();
            servidor.close();

        } catch (IOException e) {
            System.out.println("Error con el servidor: "+e.getMessage());
        }
    }
}