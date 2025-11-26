import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculadoraServidor {
    public static void main(String[] args) {
        String datosRecibidos = "";
        try {
            // Socket
            InetSocketAddress dir = new InetSocketAddress(6666);
            ServerSocket servidor = new ServerSocket();
            servidor.bind(dir);

            // Conexión con el cliente
            System.out.println("Esperando a conectarse...");
            Socket socket = servidor.accept();
            System.out.println("Cliente Conectado");

            // Lee los datos enviados por el cliente
            BufferedReader lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            datosRecibidos = lector.readLine();
            System.out.println(datosRecibidos);

            System.out.println("Cerrando Servidor");

            socket.close();
            servidor.close();

        } catch (IOException e) {
            System.out.println("Error con el servidor: "+e.getMessage());
        }
    }
}