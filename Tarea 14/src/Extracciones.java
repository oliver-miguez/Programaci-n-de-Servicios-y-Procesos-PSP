/**
 * Simula 3000 pagos a proveedores restando 10 € al capital de la caja por cada proveedor
 */
public class Extracciones extends Thread {

    @Override
    public void run(){
        double suma = 0.0;
        for(int i = 0; i < 3000; i++){
            try {
                Caja.extraer();
                Thread.sleep(1);
                System.out.println("Saldo actualizado de la caja(Extracciones): "+ Caja.capital);

            }catch (InterruptedException e){
                System.out.println("Error proceso interrumpido(Extracciones): "+ e.getMessage());
            }
        }


    }
}
