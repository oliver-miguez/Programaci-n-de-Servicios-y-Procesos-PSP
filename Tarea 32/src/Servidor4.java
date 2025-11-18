import java.io.IOException;
import java.net.*;

public class Servidor4 {
    public static void main(String[] args) {
        String msgLargo = "";
        int largo = 0;
        try {
            DatagramSocket socket = new DatagramSocket(9001);
            byte[] bufferRecepcion = new byte[1024];

            while (true) {
                DatagramPacket paquete = new DatagramPacket(
                        bufferRecepcion, bufferRecepcion.length
                );
                socket.receive(paquete);
                String msg = new String(paquete.getData(), 0, paquete.getLength());



                if(msg.length() > largo ) {
                    largo = msg.length();
                    msgLargo = msg;
                }

                if (msg.isEmpty()) {
                    break;
                }
            }
            System.out.println(msgLargo+" "+largo);



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


                DatagramSocket socket2 = new DatagramSocket();
                InetAddress ipDestino = InetAddress.getByName("localhost");
                byte[] bufferEnvio = msgLargo.getBytes();

                DatagramPacket paquete = new DatagramPacket(
                        bufferEnvio, bufferEnvio.length, ipDestino, 9003
                );

                socket2.send(paquete);
                socket2.close();



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