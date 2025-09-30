public class Main {
    public static void main(String[] args) {
        //Crea 4 hilos, uno para cada profesor
        new Tarea("Damian",6).start();
        new Tarea("Diego",3).start();
        new Tarea("Manuel",6).start();
        new Tarea("Araujo",5).start();
    }
}
