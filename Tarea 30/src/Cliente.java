import java.io.IOException;
import java.net.*;
import java.sql.Array;
import java.util.Scanner;

/**
 * Partiendo de los códigos de ejemplo del aula virtual para DatagramSocket y DatagramPacket programa una conversación entre el cliente y el servidor donde cada uno envíe 3 mensajes cada uno. Puedes hacerlo desde código. Por ejemplo:
 * - "Mensaje 1: sin tv"
 * - "Mensaje 2: y sin cerveza"
 * - "Mensaje 3: Homer"
 * Lo mismo desde el servidor, que mandará estos 3 mensajes
 * - "Mensaje 1: Pierde"
 * - "Mensaje 2: La"
 * - "Mensaje 3: Cabeza"
 */
public class Cliente {
    public static void main(String[] args) {
        try{
            String[]mensajesEnviar = new String[3];
            Scanner sc = new Scanner(System.in);

            for(int i = 0; i <= 2 ; i++){
                System.out.println("Introduce un mensaje: ");
                String mensajeEscrito = sc.next();
                mensajesEnviar[i] = mensajeEscrito;
            }

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

            DatagramSocket socket2 = new DatagramSocket(9002);
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