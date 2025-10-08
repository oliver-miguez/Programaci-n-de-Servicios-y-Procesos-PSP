public class Caja {
    public static double capital = 1000.0;

    public synchronized static  void  ingresar(){
        capital += 10;
    }
    public synchronized static void extraer(){
        capital -= 10;
    }

}
