public class Hilo extends Thread {
    String textoIntroducido;
    int totalVocales;
    char vocal;
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
