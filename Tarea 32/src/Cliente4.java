/**
 * Crea una aplicación cliente servidor utilizando DatagramSockets donde el cliente envía una lista de palabras al servidor.
 * El servidor recibe las palabras, encuentra la más larga de las enviadas y le devuelve la palabra y la longitud de la misma al cliente.
 */
import java.io.IOException;
import java.net.*;


public class Cliente4 {
    public static void main(String[] args) {
        try{
            String[]mensajesEnviar = {"SinTv","y sincerveza","Homer",""};
            for(String mensaje : mensajesEnviar) {
                DatagramSocket socket = new DatagramSocket();
                InetAddress ipDestino = InetAddress.getByName("localhost");
                byte[] bufferEnvio = mensaje.getBytes();

                DatagramPacket paquete = new DatagramPacket(
                        bufferEnvio, bufferEnvio.length, ipDestino, 9001
                );

                socket.send(paquete);
                socket.close();

            }

            DatagramSocket socket2 = new DatagramSocket(9003);
            byte[] bufferRecepcion = new byte[1024];
            while (true) {
                DatagramPacket paquete = new DatagramPacket(
                        bufferRecepcion, bufferRecepcion.length
                );
                socket2.receive(paquete);
                String msg = new String(paquete.getData(), 0, paquete.getLength());

                System.out.println(msg);
                if (msg.isEmpty()) {
                    break;
                }
            }


        } catch (SocketException e) {
            System.out.println("Error en el DatagramSocket del cliente");
        } catch (UnknownHostException e) {
            System.out.println("Error con el host del cliente");
        } catch (IOException e) {
            System.out.println("Erro al enviar el paquete (Cliente) ");
        }
    }
}