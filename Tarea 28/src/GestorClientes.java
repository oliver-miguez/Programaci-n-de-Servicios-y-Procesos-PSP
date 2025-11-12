import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Para administrar muchos clientes
 */
public class GestorClientes extends  Thread{
    // Para recibir el mensaje y enviarlo
    private Socket socket;
    //Mensaje recibido del cliente
    String mensajeRecibido = "";

    // Constructor
    public GestorClientes(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        try(
        // Permite leer y escribir el mensaje
        BufferedReader lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter escritor = new PrintWriter(socket.getOutputStream(),true);
        ) {
            // LÓGICA DE LA GESTIÓN DE CLIENTES
            do{
                // Lee el mensaje recibido del cliente
                mensajeRecibido = lector.readLine();
                // Lo reenvía de nuevo al cliente con un " ECO "
                escritor.println("ECO: "+ mensajeRecibido);
            } while(!mensajeRecibido.equals("adios")); // Mientras el mensaje no sea adios

            // Cuando el mensaje recibido es "adios" se cierra
            System.out.println("Cerrando");

        } catch (IOException e) {
            System.out.println("Error 1º try de cliente: "+ e.getMessage());
        }finally {
            // Finalmente, tras introducir "adios" como mensaje cierra la conexión y el cliente se desconecta
            try {
                socket.close();
                System.out.println("Cliente Desconectado");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
