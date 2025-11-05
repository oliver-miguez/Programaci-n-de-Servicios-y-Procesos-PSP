import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        InetSocketAddress dir = new InetSocketAddress(6666);

        try {
            Socket socket = new Socket();
            socket.connect(dir);

            System.out.println("Conectando al servidor");

            PrintWriter escritor = new PrintWriter(socket.getOutputStream(),true);
            escritor.println("Mensaje 1 enviado");
            escritor.println("Mensaje 2 enviado");
            escritor.println("Mensaje 3 enviado");


            BufferedReader lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String mensaje = lector.readLine();
            String mensaje2 = lector.readLine();
            String mensaje3 = lector.readLine();

            System.out.println("Servidor dice: "+ mensaje+ ", "+ mensaje2+ ", "+ mensaje3);

            socket.close();

        } catch (Exception e) {
            System.out.println("Error con el cliente");
        }
    }
}
