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
            System.out.println("5.Cerrando");

            System.out.println("Elige el tipo de operación a realizar: ");
            op = sc.nextInt(); // Recoge la opción elegida

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
                    operador = "Salir";
            }

            // Números para realizar las operaciones
            double num1 = 0.0;
            double num2 = 0.0;

            if(op != 5){

                System.out.println("Introduce el valor del primer número:");
                while (!sc.hasNextDouble()) { // Evita que el valor introducido sea distinto a un Double
                    System.out.println("Valor no válido. Introduce un número válido:");
                    sc.next(); // limpiar el valor incorrecto
                }
                num1 = sc.nextDouble(); // Guarda el valor introducido por consola

                System.out.println("Introduce el valor del segundo número:");
                while (!sc.hasNextDouble()) {
                    System.out.println("Valor no válido. Introduce un número válido:");
                    sc.next();
                }
                num2 = sc.nextDouble();

                // Array de Strings a enviar
                String[] datosEnviar = new String[3];
                datosEnviar[0] = operador;
                datosEnviar[1] = Double.toString(num1);
                datosEnviar[2] = Double.toString(num2);

                // Envia un String con todos los datos
                PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true);
                escritor.println(Arrays.toString(datosEnviar));
            }else{
                // Evita error de que no detecta un numero de enviar
                // Con esto le enviamos unos datos, que no van a ser utilizados, para arreglarlo

                num1 = 0.0;
                num2 = 0.0;

                // Array de Strings a enviar
                String[] datosEnviar = new String[3];
                datosEnviar[0] = ""; // No envia ningun operador
                datosEnviar[1] = Double.toString(num1);
                datosEnviar[2] = Double.toString(num2);

                // Envia un String con todos los datos
                PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true);
                escritor.println(Arrays.toString(datosEnviar));


                System.out.println("Cerrando cliente");
            }


        } catch (UnknownHostException e) {
            System.out.println("Error, Host no válido o erróneo: "+e.getMessage());
        } catch (SocketException e) {
            System.out.println("Error, Socket no válido o erróneo: "+e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al enviar los datos introducidos por el cliente: "+e.getMessage());
        }
    }


}
