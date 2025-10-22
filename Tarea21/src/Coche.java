import java.lang.reflect.Array;

/**
 * Hilo coche
 */
public class Coche extends Thread{

    int numCoche; // Número del vehículo, para identificar quien es quien
    Parking parking; // Referencia a la clase Parking

    public Coche(int numCoche, Parking parking){
        this.numCoche = numCoche;
        this.parking = parking;
    }

    /**
     * Lo que hace cada coche
     */
    @Override
    public void run(){
        try {
            parking.añadirVehiculo(numCoche);
            Thread.sleep(randomValor());
            parking.sacarVehiculo(numCoche);
        } catch (InterruptedException e) {
            System.out.println("Error en el run: "+ e.getMessage());
        }
    }

    /**
     * Genera un valor aleatorio para hacer los vehiculos, para estar x tiempo en el parking aparcados
     * @return el número generado
     */
    public static int randomValor(){
        int numero = (int) (Math.random() * 2000) + 3000;
        return numero;
    }

}
