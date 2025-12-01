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

            // Si el cliente cierra, los datos pueden ser "SALIR" o null
            if (datosRecibidos == null || datosRecibidos.trim().toUpperCase().equals("SALIR")) {
                System.out.println("Cliente ha solicitado el cierre.");
                socket.close();
                servidor.close();
                return;
            }


            // El String recibido"
            // Dividimos por el espacio.
            String[] partes = datosRecibidos.trim().split("\\s+"); // Limpia espacios extremos y divide la cadena por uno o más espacios en blanco.

            if (partes.length < 3) {
                // Necesitamos al menos el operador (parte[0]) y dos números (parte[1] y parte[2])
                System.out.println("Error: Formato de datos incompleto. Se esperaban al menos 3 partes (Operador y 2 números).");
                socket.close();
                servidor.close();
                return;
            }

            String operador = partes[0];
            double resultado = 0.0;
            boolean primerNumero = true;

            // Recorremos las partes restantes (los números)
            for (int i = 1; i < partes.length; i++) {
                try {
                    double numActual = Double.parseDouble(partes[i]);

                    if (primerNumero) {
                        // El primer número inicia el resultado
                        resultado = numActual;
                        primerNumero = false;
                    } else {
                        // Aplicamos el operador al resultado y al número actual
                        switch (operador) {
                            case "+":
                                resultado += numActual;
                                break;
                            case "-":
                                resultado -= numActual;
                                break;
                            case "*":
                                resultado *= numActual;
                                break;
                            case "/":
                                if (numActual == 0) {
                                    System.out.println("Error: División por cero detectada.");
                                    resultado = Double.NaN; // Not a Number, como no es un número asigna el valor infinito
                                    i = partes.length; // Salir del bucle
                                } else {
                                    resultado /= numActual;
                                }
                                break;
                            default:
                                System.out.println("Error: Operador no reconocido.");
                                resultado = Double.NaN;
                                i = partes.length; // Salir del bucle
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Uno de los valores no es un número válido: " + partes[i]);
                    resultado = Double.NaN;
                    break; // Salir del bucle
                }
            }

            System.out.println("Operador: " + operador);
            System.out.println("Números procesados: " + (partes.length - 1));
            System.out.println("Resultado: " + resultado);


            socket.close();
            servidor.close();
        } catch (IOException e) {
            System.out.println("Error con el servidor: "+e.getMessage());
        }
    }
}