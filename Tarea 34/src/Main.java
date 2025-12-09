import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


/**
 * Crea un programa que pida dos URLs distintas al usuario (por ejemplo, https://www.google.com y https://www.bing.com) y las compare.
 * Requisitos:
 *     Para cada web, debe obtener:
 *         Tiempo de respuesta: (Milisegundos que tarda en completarse la petición)
 *         Tamaño: Número de bytes o caracteres del cuerpo de la respuesta.
 *     Salida por consola: Debe imprimir lo siguiente:
 *         "La web más rápida ha sido: [URL] con [X] ms."
 *         "La web con más contenido ha sido: [URL] con [X] caracteres."
 */
public class Main {
    public static void main(String[] args) {

        HttpClient cliente = HttpClient.newHttpClient();
        HttpClient cliente2 = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.google.com"))
                .GET()
                .build();

        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(URI.create("https://www.bing.com"))
                .GET()
                .build();


        try{
            long inicio1 = System.currentTimeMillis();
            HttpResponse<String> response = cliente.send(request,HttpResponse.BodyHandlers.ofString());
            long fin1 = System.currentTimeMillis();

            long inicio2 = System.currentTimeMillis();
            HttpResponse<String> response2 = cliente2.send(request2,HttpResponse.BodyHandlers.ofString());
            long fin2 = System.currentTimeMillis();

            // Tiempo
            long tiempoMs1 = fin1 - inicio1;
            long tiempoMs2 = fin2 - inicio2;

            // Recoge el número de bytes de cada respuesta
            byte[]respuesta1 = response.body().getBytes();
            byte[]respuesta2 = response2.body().getBytes();

            // Almacena el valor total de bytes de cada respuesta
            int valorRespuesta1 = respuesta1.length;
            int valorRespuesta2 = respuesta2.length;

            // Validaciones
            if(valorRespuesta1 > valorRespuesta2){
                System.out.println("La web con mas contenido a sido: "+ response+ " con un valor de "+ valorRespuesta1 + " bytes");
            }else{
                System.out.println("La web con mas contenido a sido: "+ response2+ " con un valor de "+ valorRespuesta2 + " bytes");
            }

            if (tiempoMs1 > tiempoMs2){
                System.out.println("La web más rápida a sido: "+ response+ " con: " + tiempoMs1 + " milisegundos");
            }else{
                System.out.println("La web más rápida a sido: "+ response2+ " con: " + tiempoMs2 + " milisegundos");
            }


        }catch(Exception e){
            System.out.println("Error con el envío o al recibir:"+ e.getMessage());
        }

    }
}