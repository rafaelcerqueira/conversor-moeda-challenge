package CurrencyConverter.src.main.java.com.conversormoedas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    public static String getApiKey() {
        String apiKey = null;
        try (BufferedReader br = new BufferedReader(new FileReader("api_key.txt"))) {
            apiKey = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return apiKey;
    }
}