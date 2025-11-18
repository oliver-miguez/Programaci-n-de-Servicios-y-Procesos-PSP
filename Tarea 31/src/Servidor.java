import java.io.IOException;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(9001);
            byte[] bufferRecepcion = new byte[1024];

            while (true) {
                DatagramPacket paquete = new DatagramPacket(
                        bufferRecepcion, bufferRecepcion.length
                );
                socket.receive(paquete);
                String msg = new String(paquete.getData(), 0, paquete.getLength());

                System.out.println(msg);
                if (msg.isEmpty()) {
                    break;
                }
            }

            String[] mensajesEnviar = {"Pierde", "la", "cabeza", ""};
            for (String mensaje : mensajesEnviar) {

                DatagramSocket socket2 = new DatagramSocket();
                InetAddress ipDestino = InetAddress.getByName("localhost");
                byte[] bufferEnvio = mensaje.getBytes();

                DatagramPacket paquete = new DatagramPacket(
                        bufferEnvio, bufferEnvio.length, ipDestino, 9002
                );

                socket2.send(paquete);
                socket2.close();
            }

        } catch (SocketException e) {
            System.out.println("Error en el DatagramSocket del cliente");
        } catch (UnknownHostException e) {
            System.out.println("Error con el host del cliente");
        } catch (IOException e) {
            System.out.println("Erro al enviar el paquete (Cliente) ");
            throw new RuntimeException(e);
        }
    }
}
