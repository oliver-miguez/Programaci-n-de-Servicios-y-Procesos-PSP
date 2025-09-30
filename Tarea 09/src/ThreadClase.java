
public class ThreadClase extends Thread {
    private final int n;
    public ThreadClase(int n){
        this.n = n;
    }
    @Override
    public void run(){
        //calcular fibonacci

        for(int i = 1; i < n;){

            System.out.println();

            /*
            suma = i + valor_anterior;
            valor_anterior = i;
            i = suma;
            System.out.println(suma);
            */
        }
    }
}
