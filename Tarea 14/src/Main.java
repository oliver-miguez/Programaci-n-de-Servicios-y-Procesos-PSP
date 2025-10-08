/**
 * Lanza los hilos
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Capital actual: "+ Caja.capital);
        Ingresos ingresos = new Ingresos();
        ingresos.start();
        Extracciones extracciones = new Extracciones();

        try{
            ingresos.join();
            extracciones.join();
        }catch (InterruptedException e){
            System.out.println("Procesos interrumpidos: "+e.getMessage());
        }
        System.out.println("Capital final: "+ Caja.capital); // Ojo tarda un poco en aparecer !

    }
}