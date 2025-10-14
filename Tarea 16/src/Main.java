public class Main {
    public static void main(String[] args) {
        new Hilo().start();
        new Hilo().start();
        new Hilo().start();
        new Hilo().start();
        new Hilo().start();

        System.out.println(Valor.valor);

        // El valor que se muestra es incorrecto porque al ejecutar los 5 procesos a la vez provoca una desincronización con el contador de la clase Valor
        // Para arreglarlo deberémos crear un método en la clase Valor utilizando syncronize para sincronizarlos
    }
}