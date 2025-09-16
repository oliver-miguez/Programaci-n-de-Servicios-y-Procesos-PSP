package Tarea_02;

import java.util.Properties;

/**
 *El número de procesadores disponibles para la JVM.
 */
public class Tarea02_3 {
    public static void main(String[] args) {
        Properties st = System.getProperties();
        //System.out.println(st);

        //Con el toString dividimos todos los procesos con comas
        String propiedades = st.toString();
        //Almacenamos cada proceso separado por una coma
        String[]prop = propiedades.split(",");
        //Recorremos el array que tiene almacenado todos los procesos y los mostramos ordenados
        for(String p : prop){
            System.out.println(p);
        }
    }
}
