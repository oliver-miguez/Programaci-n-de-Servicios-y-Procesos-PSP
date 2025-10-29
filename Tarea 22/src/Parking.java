import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class Parking {
    private int[] plazas;
    private Semaphore nPlazas;

    public Parking(int nPlazas) {
        this.plazas = new int[nPlazas];
        this.nPlazas = new Semaphore(nPlazas);
    }

    private int plazaLibre(){
        return buscarCoche(0); // Los coches no pueden tener el número 0 por lo que esto devuelve la primera plaza libre o -1 si no hay
    }

    private int buscarCoche(int coche) {
        for (int i = 0;i<plazas.length;i++){
            if (plazas[i] == coche){
                return i; // Devuelve la posición del coche que se busca
            }
        }
        return -1; // Si no encuentra al coche en el parking devuelve -1
    }

    public void aparcar(int coche){
        System.out.println("Coche "+coche+" en espera");
        try {
            nPlazas.acquire();
            int plaza = plazaLibre();
            plazas[plaza] = coche;
            System.out.println("Entrada: Coche "+coche+" aparcando en "+plaza+"\n"+Arrays.toString(plazas));

        } catch (InterruptedException e) {
            System.out.println("Interrumpido al aparcar: "+e.getMessage());
        }


    }

    public void salir(int coche){
        int plaza = buscarCoche(coche);
        if (plaza != -1){ // Se asegura de que el coche que intenta salir está en primer lugar aparcado
            plazas[plaza] = 0;
            System.out.println("Salida: Coche "+coche+" saliendo de "+plaza+"\n"+Arrays.toString(plazas));
            nPlazas.release();
        }

    }



    public int[] getPlazas(){
        return plazas;
    }
}