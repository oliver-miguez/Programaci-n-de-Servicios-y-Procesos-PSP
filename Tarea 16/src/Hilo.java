package src;

public class Hilo extends Thread{

    @Override
    public void run(){
        for(int i = 1; i < 50; i++){
            try {
                Valor.valor += 1;
                Thread.sleep(10);
            }catch (InterruptedException e){
                System.out.println("Proceso Interrumpido: "+ e.getMessage());
            }
            System.out.println(Valor.valor);
        }
    }
}
