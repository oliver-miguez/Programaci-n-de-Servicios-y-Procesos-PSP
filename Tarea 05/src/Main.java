import java.io.IOException;
import java.util.Scanner;

/**
 * 1. Pide por consola al usuario un comando y sus parámetros a ejecutar (si fuese necesario) (Por ejemplo, ls, gnome-text-editor, open...)
 * 2. Lanza el proceso y obtén el código de finalización del mismo.
 * 3. Muestra el nombre del programa y el código de finalización del mismo.
 *
 * El programa finaliza cuando un usuario introduce “salir” y devolverá un código de salida = 0.
 * Prueba a introducir comandos y/o parámetros inexistentes y observa el código de finalización.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione un comando");
        System.out.println("1. ls");
        System.out.println("2. gnome-text-editor");
        System.out.println("3. open");
        System.out.println("4. Comando Inexistente");
        System.out.println("5. salir");
        System.out.println("Introduce una opción:");
        int op = sc.nextInt();


        switch (op){
            case 1:
                seleccionLs();
                break;
            case 2:
                seleccionGnomeTextEditor();
                break;
            case 3:
                seleccionOpen();
                break;
            case 4:
                comandoInexistente();
                break;
            case 5:
                System.out.println("cerrando");
                break;
            default:
                System.out.println("Opción no disponible");
        }
    } //end main

    /**
     * Ejecuta el comando ls
     */
    public static void seleccionLs(){
        String comando = "ls";
        try {
            ProcessBuilder pb = new ProcessBuilder(comando);
            Process p = pb.start();
            int codigoSalida = p.exitValue();
            System.out.println("Proceso iniciado ");
            System.out.println("Código de finalización:"+ codigoSalida);
            System.out.println("Comando: "+ pb.command()+" código de finalización: "+ codigoSalida);

        } catch (IOException e) {
            System.out.println("Error de entrada/salída en método selecciónLs"+ e.getMessage());
        }

    }

    /**
     * Ejecuta el comando gnome-text-editor
     * OJO SOLO FUNCIONA EN LINUX
     */
    public static void  seleccionGnomeTextEditor(){
        System.out.println("Proceso iniciado ");

        String comando = "gnome-text-editor";
        String argumento1 = "Prueba.txt";
        try {
            ProcessBuilder pb = new ProcessBuilder(comando,argumento1);
            Process p = pb.start();
            int codigoSalida = p.waitFor();
            System.out.println("Código de finalización:"+ codigoSalida);
            System.out.println("Comando: "+ pb.command()+" código de finalización: "+ codigoSalida);

        } catch (IOException e) {
            System.out.println("Error de entrada/salída en método selecciónLs"+ e.getMessage());
        }catch (IllegalThreadStateException e){
            System.out.println("El proceso no finalizo, no enviara código de finalización, error: "+ e.getMessage());
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

    public static void seleccionOpen(){
        String comando = "open";
        String argumento1 = "src";
        try {
            ProcessBuilder pb = new ProcessBuilder(comando,argumento1);
            Process p = pb.start();
            int codigoFinalizacion = p.waitFor();
            System.out.println("Código de finalización: "+ codigoFinalizacion);
            System.out.println("Comando: "+ pb.command()+ "Código Finalización: "+ codigoFinalizacion);

        } catch (IOException e) {
            System.out.println("Error de entrada/salída: "+ e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Prueba un comando inexistente para comprobar el exitValue
     * No muestra ningún código debido a que este no existe
     */
    public static void comandoInexistente(){
        String comando = "wertyuiop";
        try {
            ProcessBuilder pb = new ProcessBuilder(comando);
            Process p = pb.start();
            int codigoFinalizacion = p.waitFor();
            System.out.println("Código de finalización: "+ codigoFinalizacion);
            System.out.println("Comando: "+ pb.command()+ "Código Finalización: "+ codigoFinalizacion);

        } catch (IOException e) {
            System.out.println("Error de entrada/salída: "+ e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Proceso interrumpido: "+ e.getMessage());
        }
    }

}