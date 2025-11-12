import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class Cliente2{
    public static void main(String[] args) {
        String textoEnviar = "";

        // Conecta el Cliente con el servidor
        InetSocketAddress dir = new InetSocketAddress(6666);
        Scanner sc = new Scanner(System.in);

        try {
            // Se conecta con el servidor a su puerto
            Socket socket = new Socket();
            socket.connect(dir);

            System.out.println("Conectando al servidor");
            
            // "Mientras el mensaje enviado no sea "adios"
            while (!Objects.equals(textoEnviar, "adios")) {

                // Almacena el mensaje
                System.out.println("Introduce texto para leer: ");
                textoEnviar = sc.next();

                // Lo envía
                PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true);
                escritor.println(textoEnviar);

                // Recibe el mensaje "ECO"
                BufferedReader lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String mensaje = lector.readLine();
                System.out.println(mensaje);

            }

            // Se desconecta del servidor
            socket.close();

        } catch (Exception e) {
            System.out.println("Error con el cliente");
        }
    }
}
