public class Vehiculo extends Thread{
    private Parking parking;
    private int nCoche;

    public Vehiculo(Parking parking, int nCoche) {
        this.parking = parking;
        setNCoche(nCoche);
    }

    public void setNCoche(int nCoche) {
        if (nCoche >0 ){
            this.nCoche = nCoche;
        }
        else this.nCoche = 1;
    }

    @Override
    public void run(){
        for (int i = 0; i<5; i++){
            parking.aparcar(nCoche);
            try {
                Thread.sleep(numeroAleatorio());
            } catch (InterruptedException e) {
                System.out.println("Hilo coche "+nCoche+" interrumpido: "+e.getMessage());
            }
            parking.salir(nCoche);
            try {
                Thread.sleep(numeroAleatorio());
            } catch (InterruptedException e) {
                System.out.println("Hilo coche "+nCoche+" interrumpido: "+e.getMessage());
            }
        }
    }
    private long numeroAleatorio(){
        long tiempo = Math.round(Math.random()*1000)+100;
        return tiempo;
    }
}
