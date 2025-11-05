/**
 * Clase principal, PARKING Y COCHES ejercicio
 * TAREA 21
 */
public class Main1 {
    /**
     * Metodo principal del programa
     * @param args no usamos
     */
    public static void main(String[] args) {

        Parking parking = new Parking();

        Coche coche1 = new Coche(1,parking);
        Coche coche2 = new Coche(2,parking);
        Coche coche3 = new Coche(3,parking);
        Coche coche4 = new Coche(4,parking);
        Coche coche5 = new Coche(5,parking);

        coche1.start();
        coche2.start();
        coche3.start();
        coche4.start();
        coche5.start();

    }
}