
public class Hilo extends Thread {
    public Hilo(String str){
        super(str);
    }
    @Override
    public void run(){
        for(int i = 1; i < 9; i++){
            System.out.println("["+ getName()+"] Iteración: "+ i);
            try{
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
