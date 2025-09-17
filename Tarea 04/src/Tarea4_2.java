/**
 * 2. Muestra el directorio de trabajo y la propiedad user.dir
 * después de cambiar el valor de la propiedad user.dir a la carpeta home del usuario
 */
public class Tarea4_2 {
    public static void main(String[] args) {
        // Modificar valores de user.dir
        String valor = System.setProperty("user.dir","/home");

        // Propiedades user.dir
        String propiedad = System.getProperty("user.dir");
        System.out.println(propiedad);
    }
}
