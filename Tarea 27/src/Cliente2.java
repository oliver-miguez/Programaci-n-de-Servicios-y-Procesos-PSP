import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

/**
 * Modifica la práctica anterior para que la comunicación sea interactiva y continua, definiendo el siguiente protocolo:
 * Cliente y Servidor se conectan.
 * El Cliente entra en un bucle donde lee una línea de texto desde el teclado del usuario.
 * El Cliente envía esa línea al Servidor.
 * Si la línea enviada es "adios", el bucle del cliente termina y se cierra la conexión.
 * El Servidor entra en un bucle donde lee la línea del cliente.
 * Si la línea recibida es null o "adios", InetSocketAddress dir = new InetSocketAddress(6666); el bucle del servidor termina.
 * El Servidor envía la misma línea de vuelta al Cliente, prefijada con "ECO:".
 * El Cliente lee la respuesta "ECO:" del servidor y la imprime por pantalla.
 */
public class Cliente2 {
    public static void main(String[] args) {
        String textoLeer = "";
        InetSocketAddress dir = new InetSocketAddress(6666);
        Scanner sc = new Scanner(System.in);

        try {
            Socket socket = new Socket();
            socket.connect(dir);

            System.out.println("Conectando al servidor");

            while (!Objects.equals(textoLeer, "adios")) {

                System.out.println("Introduce texto para leer: ");
                textoLeer = sc.next();

                PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true);
                escritor.println(textoLeer);

                BufferedReader lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String mensaje = lector.readLine();
                System.out.println(mensaje);

            }

            socket.close();

        } catch (Exception e) {
            System.out.println("Error con el cliente");
        }
    }
}
