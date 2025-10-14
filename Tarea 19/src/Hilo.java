/**
 * Lo que ejecuta cada hilo
 */
public class Hilo extends Thread {

    // Variables
    String textoIntroducido;
    int totalVocales;
    char vocal;

    // Constructor
    public Hilo(String texto,char vocal){
        this.textoIntroducido = texto;
        this.vocal = vocal;
    }

    @Override
    public void run(){
        char[]textoChar = textoIntroducido.toCharArray();
        for (char voc : textoChar){
            if(vocal == voc){
                Contador.contador();
            }
        }
    }
}
