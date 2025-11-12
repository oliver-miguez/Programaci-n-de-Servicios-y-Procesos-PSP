import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Solo acepta o rechaza las conexiones de los clientes
 */
public class Servidor28 {

    public static void main(String[] args) {

        try {
            // Nuevo servidor
            InetSocketAddress dir = new InetSocketAddress(6666);
            ServerSocket servidor = new ServerSocket();
            servidor.bind(dir);

            while(true){

                // Acepta la conexión del cliente
                Socket cliente  = servidor.accept();
                System.out.println("Cliente conectado");

                //Crea un hilo y le pasa el cliente que fue aceptado
                GestorClientes hilo = new GestorClientes(cliente);
                hilo.start();

            }

        } catch (IOException e) {
            System.out.println("Error con el servidor: "+e.getMessage());
        }
    }
}