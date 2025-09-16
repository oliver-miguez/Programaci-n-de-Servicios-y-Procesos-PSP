import java.io.IOException;

/**
Crea un programa en Java que permita al usuario, desde la línea de comandos, abrir un archivo existente o crear uno nuevo
 utilizando un editor de texto sencillo disponible en el sistema (por ejemplo: gnome-text-editor, gedit, notepad, etc.).
El usuario deberá introducir por teclado el nombre del archivo o su ruta completa (incluyendo la extensión).
Si el archivo no existe, el editor deberá permitir su creación.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        //comando que abre el bloc de notas de windows
        String comando = "notepad";
        //Crea un objeto tipo ProcessBuilder con el valor del comando anterior
        ProcessBuilder pb = new ProcessBuilder(comando);
        //A través de un objeto Process activamos el comando del ProcessBuilder
        Process p  = pb.start();
    }
}