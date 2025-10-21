package R1;

public class Espectadores {

    public static int totalEspectadores = 0; // Almacenamiento global de espectadores

    public synchronized static void sumarEspectadores(int valorEspectadores){
        // Le damos "valorEspectadores" el valor de la suma del total de espectadores recibidos de "Tornos"
        totalEspectadores += valorEspectadores;
    }


}
