import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor2 {
    public static void main(String[] args) {
        String mensaje = "";
        try {
            InetSocketAddress dir = new InetSocketAddress(6666);
            ServerSocket servidor = new ServerSocket();

            servidor.bind(dir);

            System.out.println("Esperando a conectarse...");
            Socket socket = servidor.accept();
            System.out.println("Cliente Conectado");
            BufferedReader lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter escritor = new PrintWriter(socket.getOutputStream(),true);

            do{
                mensaje = lector.readLine();
                escritor.println("ECO: "+ mensaje);
            } while(!mensaje.equals("adios"));

            System.out.println("Cerrando");

            socket.close();
            servidor.close();

        } catch (IOException e) {
            System.out.println("Error con el servidor: "+e.getMessage());
        }
    }
}