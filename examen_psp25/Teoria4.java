class Cafeteria {
    private boolean camareroOcupado = false;

    public void pedirCafe() throws InterruptedException {
        while (camareroOcupado) {
            System.out.println(Thread.currentThread().getName() + " está esperando su café.");
            wait();
        }
        camareroOcupado = true;
        System.out.println(Thread.currentThread().getName() + " está recibiendo su café.");
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + " ha recibido su café.");
        camareroOcupado = false;
        notifyAll();
    }
}

class Cliente extends Thread {
    private Cafeteria cafeteria;
    private String name;

    public Cliente(Cafeteria cafeteria, String name) {
        super(name);
        this.cafeteria = cafeteria;
    }

    public void run() {
        try {
            cafeteria.pedirCafe();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Ejercicio4 {
    public static void main(String[] args) {
        Cafeteria cafeteria = new Cafeteria();

        new Cliente(cafeteria, "Cliente 1").start();
        new Cliente(cafeteria, "Cliente 2").start();
        new Cliente(cafeteria, "Cliente 3").start();
        new Cliente(cafeteria, "Cliente 4").start();
        new Cliente(cafeteria, "Cliente 5").start();
    }
}