import java.util.Arrays;

public class Parking {

    static int[]parking = new int[5]; // Crea el parking


    /**
     * Si tiene un hueco libre el parking, añade un nuevo vehículo
     * @param numVehiculo número del hilo de cada uno de los vehículos independientes
     */
    public synchronized  void añadirVehiculo(int numVehiculo){
            while (plazaLibre() == -1){
                try{
                    wait(); // Espera hasta que tenga una plaza libre
                } catch (InterruptedException e) {
                    System.out.println("Error en añadirVehiculo: "+ e.getMessage());
                }
            }

            parking[plazaLibre()] = numVehiculo; // Asigna a la posición vacía el número del coche
            System.out.println("Vehiculo "+ numVehiculo+ " aparco en el parking");
            System.out.println(Arrays.toString(parking));
            notifyAll(); // Llama al resto de hilos
    }

    /**
     * Saca un vehículo del parking liberando su posición restableciendo el valor de esa posición a 0
     * @param numVehiculo número del hilo vehículo
     */
    public synchronized void sacarVehiculo(int numVehiculo){
        //TODO ACABAR SACAR EL VEHICULO DEL PARKING
    }


    /**
     * Consigue el índice de las posiciones libres del parking
     * @return si está lleno -1, si está vacío i
     */
    public static int plazaLibre(){
        for(int i = 0; i < parking.length; i++){
            if(parking[i] == 0){
                return i; // si está vacía una posición devuelve su indice
            }
        }
        return -1; // si es está lleno
    }

}
