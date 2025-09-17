import java.io.IOException;

/**
 * Crea un programa en Java que ejecute dir o ls en función del sistema operativo. Utiliza la clase System. Luego, que haga lo siguiente:
 * 1. Muestra el directorio de trabajo y la propiedad user.dir por defecto.
 * 2. Muestra el directorio de trabajo y la propiedad user.dir
 * después de cambiar el valor de la propiedad user.dir a la carpeta home del usuario
 * 3. Muestra el directorio de trabajo y la propiedad user.dir
 * después de después de cambiar el directorio de trabajo al directorio temporal (c:/temp o /tmp).
 * OJO. El proceso aunque se ejecute no mostrará el listado de directorios
 */
public class Tarea4_1 {
    public static void main(String[] args) throws IOException {
        String comando = "ls";
        ProcessBuilder pb = new ProcessBuilder(comando); // Ejecuta el comando
        pb.inheritIO(); // Muestra el directorio de trabajo
        Process p  = pb.start();


        // Propiedades user.dir
        String propiedad = System.getProperty("user.dir");
        System.out.println(propiedad);


    }
}