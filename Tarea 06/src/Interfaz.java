import java.util.Scanner;

/**
 * Pregunta al usuario el host/ip que se desea hacer Ping
 * @author Oliver Miguez Alonso
 */
public class Interfaz {
    /**
     * Metodo principal
     * @param args no usamos
     */
    public static void main(String[] args) {
        menu();
    }


    /**
     * Menu de opciones
     */
    public static void menu(){

        boolean verificador = true;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("1.Introducir Host/Ip");
            System.out.println("2.Salir");
            int op = sc.nextInt();

            switch (op){
                case 1:
                    System.out.println("Introduce una IP o un Host"); // Puedes utilizar google.com para probarlo
                    String datos = sc.next();
                    Lanzar(datos);

                    break;
                case 2:
                    System.out.println("Cerrando");
                    verificador = false;
                    break;
            }

        }while ( verificador);
    }

    public static void Lanzar(String datos){
        Lanzador.Lanzador(datos);
    }
}
