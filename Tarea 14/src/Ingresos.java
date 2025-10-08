/**
 * Simula las 5000 ventas y añade 10 € al capital de la caja por cada venta
 */
public class Ingresos extends Thread{

    @Override
    public void run(){
        double suma = 0.0; // Recoge el valor de la suma de las 5000 ventas con el valor del capital de la caja
        for(int i = 0; i < 5000; i++){
            try {
                Caja.ingresar();
                Thread.sleep(1);
                System.out.println("Saldo actualizado tras las ventas de la caja:(Ingresos)" + Caja.capital);

            }catch (InterruptedException e){
                System.out.println("Proceso interrumpido(Ingreso): "+e.getMessage());
            }
        }


    }
}
