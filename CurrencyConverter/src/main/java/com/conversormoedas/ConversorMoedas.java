package CurrencyConverter.src.main.java.com.conversormoedas;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;

public class ConversorMoedas {

    private static final String API_KEY = "e4a37c63c0e42d3c16bffb20";
    private static final String API_URL = "http://v6.exchangerate-api.com/v6/";

    public void converte(String deMoeda, String paraMoeda) {
        String urlString = API_URL + API_KEY + "/pair/" + deMoeda + "/" + paraMoeda;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlString))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                String responseBody = response.body();
                Gson gson = new Gson();
                JsonObject json = gson.fromJson(responseBody, JsonObject.class);
                double taxaConversao = json.get("conversion_rate").getAsDouble();
                double quantiaConvertida = quantia * taxaConversao;

                DecimalFormat df = DecimalFormat("#.##");
                System.out.println("Valor convertido de " + quantia + " " + deMoeda + " para " + paraMoeda + ": " + df.format(quantiaConvertida));
            } else {
                System.out.println("Erro na conexao com a API. Codigo de sttatus: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


}
