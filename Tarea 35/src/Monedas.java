import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import org.json.JSONArray;
import org.json.JSONObject;

public class Monedas {

    public static void main(String[] args) {

        try {
            // Ejemplo: moneda introducida por el usuario.
            String userInput = "Ethereum";

            // Buscamos el ID de esa moneda
            String coinId = getCoinId(userInput);

            if (coinId == null) {
                System.out.println("La moneda '" + userInput + "' no existe.");
                return;
            }else{
                System.out.println("La moneda:"+ userInput+ " tiene de id: "+ coinId);
            }



            // Hacemos la solicitud con el ID encontrado
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.coinlore.net/api/ticker/?id=" + coinId))
                    .GET()
                    .build();

            HttpClient client = HttpClient.newHttpClient();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            // Mostramos el resultado
            System.out.println("\n Información de la moneda:");
            System.out.println(response.body());

        } catch (Exception e) {
            System.out.println("Error al enviar o recibir datos: "+e.getMessage());
        }
    }


    /**
     * Metodo para obtener el ID de una criptomoneda
     *     - Busca por símbolo (BTC) o por nombre (Bitcoin)
     *     - Devuelve su ID si existe
     *     - Si no existe, devuelve null
     */
    public static String getCoinId(String userInput) throws Exception {

        // Petición a la API que devuelve todas las criptos
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.coinlore.net/api/tickers/"))
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        // Convertimos el JSON recibido en objetos legibles
        JSONObject json = new JSONObject(response.body());
        JSONArray data = json.getJSONArray("data");

        // Pasamos la entrada del usuario a minúsculas para comparar bien
        userInput = userInput.toLowerCase();

        // Buscamos en la lista cada criptomoneda
        for (int i = 0; i < data.length(); i++) {

            JSONObject coin = data.getJSONObject(i);

            String symbol = coin.getString("symbol").toLowerCase();
            String name = coin.getString("name").toLowerCase();

            // Sí coincide el símbolo (BTC) o el nombre (Bitcoin)
            if (symbol.equals(userInput) || name.equals(userInput)) {
                return coin.getString("id"); // Id obtenido
            }
        }

        // Si termina el bucle sin encontrar nada, no existe
        return null;
    }
}
