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

    private static final String API_KEY = Config.getApiKey();
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";

    static {
        System.out.println("API Key: " + API_KEY);
    }

    public void convert(String fromCurrency, String toCurrency, double amount) {
        String urlString = API_URL + API_KEY + "/pair/" + fromCurrency + "/" + toCurrency;

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
                double conversionRate = json.get("conversion_rate").getAsDouble();
                double convertedAmount = amount * conversionRate;

                DecimalFormat df = new DecimalFormat("#.##");
                System.out.println("Valor convertido de " + amount + " " + fromCurrency + " para " + toCurrency + ": " + df.format(convertedAmount));
            } else {
                System.out.println("Erro na conexão com a API. Código de status: " + response.statusCode());
                System.out.println("Mensagem de erro: " + response.body());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
