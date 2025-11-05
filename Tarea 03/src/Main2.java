import java.io.IOException;
import java.util.Scanner;

/**
Crea un programa en Java que permita al usuario, desde la línea de comandos, abrir un archivo existente o crear uno nuevo
 utilizando un editor de texto sencillo disponible en el sistema (por ejemplo: gnome-text-editor, gedit, notepad, etc.).
El usuario deberá introducir por teclado el nombre del archivo o su ruta completa (incluyendo la extensión).
Si el archivo no existe, el editor deberá permitir su creación.
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        //crea un objeto escáner para preguntar por pantalla
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre del archivo a abrir o crear: ");
        String argumento1 = sc.nextLine();//nombre del archivo por abrir(si existe) si no existe lo crea

        //comando que abre el bloc de notas de windows
        String comando = "notepad.exe";
        //Crea un objeto tipo ProcessBuilder con el valor del comando anterior y el nombre del archivo a abrir o crear
        ProcessBuilder pb = new ProcessBuilder(comando, argumento1);
        //A través de un objeto Process activamos el comando del ProcessBuilder que abre el archivo o lo crea
        Process p  = pb.start();

    }
}