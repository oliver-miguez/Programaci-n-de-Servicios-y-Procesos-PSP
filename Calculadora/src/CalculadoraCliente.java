import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.net.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraCliente {
    public static void main(String[] args) {

        // Host para la conexión con el servidor
        InetSocketAddress dir = new InetSocketAddress(6666);

        try {

            // Socket
            Socket socket = new Socket();
            socket.connect(dir);
            System.out.println("Conectando al servidor");

            // Scanner, para recoger la información introducida por consola
            Scanner sc = new Scanner(System.in);
            int op = 0;

            // Menu de opciones
            System.out.println("Menu de Opciones");
            System.out.println("1.Suma");
            System.out.println("2.Resta");
            System.out.println("3.Multiplicación");
            System.out.println("4.Division");
            System.out.println("5.SALIR");

            System.out.println("Elige el tipo de operación a realizar: ");

            // Manejo de errores para la opción de menú
            while (!sc.hasNextInt()) {
                System.out.println("Opción no válida. Introduce un número del 1 al 5:");
                sc.next();
            }
            op = sc.nextInt(); // Recoge la opción elegida

            sc.nextLine();

            // Actualizar un valor operador, según la opción elegida
            String operador = "";
            switch (op) {
                case 1:
                    operador = "+";
                    break;
                case 2:
                    operador = "-";
                    break;
                case 3:
                    operador = "*";
                    break;
                case 4:
                    operador = "/";
                    break;
                case 5:
                    operador = "SALIR";
            }

            // Acciones que realiza la calculadora
            if(op != 5){
                String numeroString = "";
                System.out.println("Introduce los números separados por un espacio, ejemplo(1 23 4 123):");
                // Lee toda la línea como una sola cadena
                numeroString = sc.nextLine().trim();

                String mensajeCompleto = operador + " "+ numeroString;
                System.out.println("Enviando al servidor: "+mensajeCompleto);

                // Envia un String con todos los datos
                PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true);
                escritor.println(mensajeCompleto);
            }else{
                // Para el caso de la opción "SALIR"

                // Envia un String con todos los datos
                PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true);
                escritor.println(operador); // Enviamos SALIR

            }


            socket.close();
            sc.close();


        } catch (UnknownHostException e) {
            System.out.println("Error, Host no válido o erróneo: "+e.getMessage());
        } catch (SocketException e) {
            System.out.println("Error, Socket no válido o erróneo: "+e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al enviar los datos introducidos por el cliente: "+e.getMessage());
        }
    }


}
