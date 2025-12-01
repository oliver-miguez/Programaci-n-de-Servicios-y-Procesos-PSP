import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculadoraServidor {

    public static void main(String[] args) {

        try (ServerSocket servidor = new ServerSocket()) {
            // socket
            InetSocketAddress dir = new InetSocketAddress(6666);
            servidor.bind(dir);
            System.out.println("Servidor iniciado. Esperando conexiones");

            // Bucle principal para mantener el servidor escuchando indefinidamente hasta que se cierre
            while (true) {
                // Bloquea y espera la conexión de un cliente
                Socket socketCliente = servidor.accept();
                System.out.println("\nCliente conectado desde: " + socketCliente.getInetAddress().getHostName());

                // Llama al metodo que gestiona la solicitud del cliente
                boolean debeCerrar = manejarCliente(socketCliente);

                // Si el metodo devuelve true (porque recibió "SALIR"), salimos del bucle principal
                if (debeCerrar) {
                    System.out.println("Comando 'SALIR' recibido. Cerrando el servidor.");
                    break;
                }
            }

        } catch (IOException e) {
            System.err.println("Error con el servidor principal: " + e.getMessage());
        }
    }


    /**
     * Gestiona la comunicación y el cálculo para un cliente.
     * @param socket El socket del cliente .
     * @return true si se recibió el comando "SALIR", false en caso contrario.
     */
    private static boolean manejarCliente(Socket socket) {
        String datosRecibidos = "";
        boolean cerrarServidor = false;

        // Utilizamos try-with-resources para asegurar que el socket y streams se cierren después de la comunicación
        try (
                Socket cliente = socket;
                BufferedReader lector = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                PrintWriter escritor = new PrintWriter(cliente.getOutputStream(), true);
        ) {

            datosRecibidos = lector.readLine();

            // Administra el programa para que se cierre
            if (datosRecibidos == null || datosRecibidos.trim().toUpperCase().equals("SALIR")) {
                System.out.println("Conexión finalizada");
                if (datosRecibidos != null && datosRecibidos.trim().toUpperCase().equals("SALIR")) {
                    escritor.println("Servidor cerrando...");
                    cerrarServidor = true; // Verificar que el servidor se cierra
                }
                return cerrarServidor;
            }

            String[] partes = datosRecibidos.trim().split("\\s+"); // Administra el mensaje enviado, dividiendo cada numero

            // Para poder recibir dos números como mínimo para realizar una operación
            if (partes.length < 3) {
                String errorMsg = "Error: Formato incompleto. Se esperaban al menos Operador y 2 números.";
                escritor.println(errorMsg);
                System.out.println(errorMsg);
                return false;
            }

            // Variables importantes
            String operador = partes[0];
            double resultado = 0.0;
            boolean primerNumero = true;

            for (int i = 1; i < partes.length; i++) {
                try {
                    double numActual = Double.parseDouble(partes[i]); // Recoge cada valor separado del string de datos recibido

                    if (primerNumero) {
                        resultado = numActual;
                        primerNumero = false;
                    } else {
                        switch (operador) {
                            case "+": resultado += numActual; break;
                            case "-": resultado -= numActual; break;
                            case "*": resultado *= numActual; break;
                            case "/":
                                if (numActual == 0) {
                                    resultado = Double.NaN; //  Not a Number, para evitar errores de división por 0 o cualquier otra cosa
                                    i = partes.length;
                                } else {
                                    resultado /= numActual;
                                }
                                break;
                            default:
                                resultado = Double.NaN; // En caso de no elegir una opción introducida en el menu de opciones
                                i = partes.length;
                        }
                    }
                } catch (NumberFormatException e) {
                    resultado = Double.NaN; // Not a Number, evitar errores con el formato
                    break;
                }
            }

            // Envia el resultado obtenido al cliente
            escritor.println(resultado);
            System.out.println("Operador: " + operador + ", Resultado enviado: " + resultado);

            return false; // No cerrar el servidor, seguir escuchando

        } catch (IOException e) {
            System.err.println("Error de I/O en la comunicación con el cliente: " + e.getMessage());
            return false; // Error, pero el servidor principal sigue vivo
        }
    }
}