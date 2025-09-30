import javax.swing.text.StyledEditorKit;

/**
 * Haz un programa que cree cuatro hilos y los ejecute de manera simultánea,
 * pero que no espere por la finalización de los mismos.
 * Cada hilo representará a un profesor cuyo "nivel de cabreo"
 * aumenta en 1 por cada tarea que descubre que ha sido copiada y pegada de una IA.
 *
 * Al crear cada hilo de profesor, se le debe pasar su nombre y su
 * "límite de paciencia" (el número máximo de trabajos a revisar).
 * La ejecución debe resultar en que las quejas de los cuatro hilos se mezclen en la consola.
 */

public class Tarea extends Thread{
    //Constructor
    private int paciencia = 0;
    public Tarea(String str, int paciencia){
        super(str);
        this.paciencia = paciencia;
    }

    @Override
    public void run(){
        for(int i = 1; i <= paciencia  ; i++){

            if (i == paciencia){
                System.out.println("["+ getName()+"]"+ "Nivel de cabreo:"+ i +"... ¡He llegado a mi límite!");
            }else{
                System.out.println("["+ getName()+"]"+ "Nivel de cabreo: "+ i);

            }
        }
    }
}
