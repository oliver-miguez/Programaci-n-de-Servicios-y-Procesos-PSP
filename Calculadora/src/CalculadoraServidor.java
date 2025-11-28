import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

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
            String ajuste = "";

            // Ajusta el String recibido a un formato específico
            ajuste = datosRecibidos.replaceAll("]","");
            ajuste = ajuste.replace("[","");
            ajuste = ajuste.replaceAll(" ", "");
            ajuste = ajuste.replaceAll(" ",""); // Evitar posibles errores con el envío de datos

            // Recoge cada valor independiente recibido
            String[]ajusteSplit = ajuste.split(",");

            // Muestra los valores recibidos ajustados
            for(String ajust: ajusteSplit){
                System.out.println(ajust);
            }

            double num1 = Double.parseDouble(ajusteSplit[1]);
            double num2 = Double.parseDouble(ajusteSplit[2]);

            System.out.println("Numero 1 recibido: "+num1);
            System.out.println("Numero 2 recibido:"+num2);

            double resultado = 0;

            switch (ajusteSplit[0]){
                case "+":
                    resultado = num1 + num2;
                    break;
                case "-":
                    resultado = num1 - num2;
                    break;
                case "*":
                    resultado = num1 * num2;
                    break;
                case "/":
                    resultado = num1 / num2;
            }

            System.out.println("Resultado: "+ resultado);




            System.out.println("Cerrando Servidor");

            socket.close();
            servidor.close();

        } catch (IOException e) {
            System.out.println("Error con el servidor: "+e.getMessage());
        }
    }
}