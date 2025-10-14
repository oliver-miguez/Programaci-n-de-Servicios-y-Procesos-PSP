public class Contador {
    public static int contador = 0;
    public static synchronized void contador(){
        contador+=1;
    }
}
