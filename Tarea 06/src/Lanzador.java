import java.io.IOException;

/**
 * Programación Multiprocesos
 * Ejercicio 6
 * @author Oliver Miguez Alonso
 */
public class Lanzador {
    public static void Lanzador(String datoEnviado){
        try {
            System.out.println("Proceso Lanzado");
            ProcessBuilder pb = new ProcessBuilder("ping","-c","4",datoEnviado); // Ejecuta el proceso 4 veces: https://axarnet.es/blog/ping-ip-windows-macos-linux
            pb.inheritIO(); // Redirige la ruta donde se ejecutará a java (mostrándolo por consola)
            Process p = pb.start(); // Inicia el comando
            p.waitFor(); // Espera a que se ejecuten todos para evitar problemas

        } catch (IOException e) {
            System.out.println("Error de entrada/salida: "+ e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("El hilo se ha interrumpido: "+ e.getMessage());
        }
    }
}