import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.net.Socket;
/**
 *
 * Crea un programa que pida al usuario una dirección IP (o localhost).
 * El programa deberá intentar conectarse creando un socket a los siguientes puertos "famosos": 21 (FTP), 22 (SSH), 80 (HTTP) y 443 (HTTPS) o al puerto que le indique el usuario.
 * Debe imprimir por pantalla un resumen, indicando qué puertos están abiertos y cuáles cerrados o el que haya indicado el usuario.
 * El programa estará en un bucle realizando el paso 1 y 2 hasta que el usuario indique "salir".
 * 172.217.168.174
 * 10.0.9.12
 */
public class Main {
    public static void main(String[] args) {
        int op = 1;
        int puerto = 0;

        while(op != 0){
        Scanner sc = new Scanner(System.in);
        System.out.println("1. 8080");
        System.out.println("2. 80");
        System.out.println("3. 21");
        System.out.println("4. 22");
        System.out.println("5. 443");
        System.out.println("0. Salir");
        System.out.println("Introduce una opción de puerto");
        op = sc.nextInt();

            switch (op){
                case 1 -> puerto = 8080;
                case 2 -> puerto = 80;
                case 3 -> puerto = 21;
                case 4 -> puerto = 22;
                case 5 -> puerto = 443;
                default -> {
                    System.out.println("Opción no válida");
                    continue;
                }
            }
            
            System.out.println("Introduce una dirección IP o localHost");
            String host = sc.next();
            
            try{
                Socket socket = new Socket(host,puerto);
                if(socket.isConnected()){
                    System.out.println("El puerto: "+ puerto+ ", está conectado correctamente");
                }
            } catch (UnknownHostException e) {
                System.out.println("Host no existente o desconocido: "+e.getMessage());
            } catch (IOException e) {
                System.out.println("Puerto: "+ puerto+ ", está cerrado, "+e.getMessage());
            }
            System.out.println("Introduce nueva opción");
            op = sc.nextInt();
        }

        System.out.println("Cerrando");
       
    }
}