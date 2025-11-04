import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Crea un programa que pida al usuario un nombre de dominio (ej: "google.com")
 * e imprima su dirección IP por pantalla.
 * Haz que el programa imprima también la dirección IP y el nombre de tu propia máquina.
 */
public class Main{
    public static void main(String[] args) {
        String dominio = "google.com";
        try {
            System.out.println(InetAddress.getByName(dominio));
            System.out.println(InetAddress.getByName(null));
        } catch (UnknownHostException e) {
            System.out.println("Error con el inetAddress");
        }
    }
}