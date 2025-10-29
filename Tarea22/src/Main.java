public class Main {
    public static void main(String[] args) {
        Parking p = new Parking(4);

        for (int i = 1;i<6;i++){
            new Vehiculo(p,i).start();
        }
    }
}