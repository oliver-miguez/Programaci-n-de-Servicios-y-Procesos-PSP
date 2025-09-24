import java.io.*;

/**
 * Programación Multiprocesos
 * Ejercicio 6
 * @author Oliver Miguez Alonso
 */
public class Lanzador {
    public static void Lanzador(String datoEnviado){
        try {
            System.out.println("Proceso Lanzado");
            System.out.println("Espera a que termine de cargar ...");
            ProcessBuilder processBuilder = new ProcessBuilder("ping","-c","4",datoEnviado); // Ejecuta el proceso 4 veces: https://axarnet.es/blog/ping-ip-windows-macos-linux
            //processBuilder.inheritIO(); // Redirige la ruta donde se ejecutará a java (mostrándolo por consola)
            Process process = processBuilder.start(); // Inicia el comando
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream())); // Lee la salida del comando

            process.waitFor(); // Espera a que se ejecuten todos para evitar problemas

            int exitValue = process.exitValue(); // Obtiene el valor de salida del proceso
            //exitValue = 1; //Prueba para forzar error
            String line = ""; // Lee la salida del comando línea por línea
            while ((line = reader.readLine()) != null) { //si la línea no es nula
                if(exitValue == 0) { //Verifica que el valor de salida sea 0 (correcto)
                    System.out.println("[ok]" + line); // Si es 0 muestra ok
                }else{
                    System.out.println("[error] " + line); // Si no es 0 muestra error
                }
            }

        } catch (IOException e) {
            System.out.println("Error de entrada/salida: "+ e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("El hilo se ha interrumpido: "+ e.getMessage());
        } catch (IllegalThreadStateException e){
            System.out.println("El proceso no finalizo, no enviara código de finalización, error: "+ e.getMessage());
        }
    }
}