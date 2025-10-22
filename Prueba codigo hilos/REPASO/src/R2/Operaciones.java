package R2;

/**
 * Las operaciones que realizan los hilos del programa
 */
public class Operaciones extends Thread{
    int numeroHilo;
    String oper1 = "Cogiendo el objeto...";
    String oper2 = "Pintando el objeto...";
    String oper3 = "Embalar el objeto...";

    public Operaciones(int numeroHilo){
        this.numeroHilo = numeroHilo;
    }

    /**
     * Lo que ejecuta cada hilo
     */
    @Override
    public void run() {
        try {
            if (numeroHilo == 1) {
                System.out.println(oper1);
                Thread.sleep(1000);
                lanzarNuevoHilo(numeroHilo);
            } else if (numeroHilo == 2) {
                System.out.println(oper2);
                Thread.sleep(1000);
                lanzarNuevoHilo(numeroHilo);
            } else if (numeroHilo == 3) {
                System.out.println(oper3);
                Thread.sleep(1000);
                lanzarNuevoHilo(numeroHilo);
            }
        } catch (Exception e) {
            System.out.println("Excepción en el run:"+e.getMessage());
        }
    }

    /**
     * Crea un nuevo hilo
     */
    public static void lanzarNuevoHilo(int numeroHilo){
        if (numeroHilo < 3) {
            numeroHilo++;
            //System.out.println("Numero del hilo:" + numeroHilo); // DEBUG
            new Operaciones(numeroHilo).start();
        }else{
            System.out.println("Finalizado");
        }
    }

}
