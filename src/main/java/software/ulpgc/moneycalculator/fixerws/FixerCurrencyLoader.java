package software.ulpgc.moneycalculator.fixerws;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import software.ulpgc.moneycalculator.model.Currency;
import software.ulpgc.moneycalculator.io.CurrencyLoader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.util.*;

public class FixerCurrencyLoader implements CurrencyLoader {

    @Override
    public List<Currency> load() {
        try {
            String ratesJson = loadJson("https://api.exchangeratesapi.io/v1/latest?access_key=" + FixerAPI.key);
            String symbolsJson = loadJson("https://api.exchangeratesapi.io/v1/symbols?access_key=" + FixerAPI.key);
            return toList(ratesJson, symbolsJson);
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    private List<Currency> toList(String ratesJson, String symbolsJson) {
        List<Currency> list = new ArrayList<>();

        // Parse rates and symbols
        Map<String, JsonElement> rates = new Gson().fromJson(ratesJson, JsonObject.class).get("rates").getAsJsonObject().asMap();
        Map<String, JsonElement> symbols = new Gson().fromJson(symbolsJson, JsonObject.class).get("symbols").getAsJsonObject().asMap();

        // Combine data
        for (String symbol : rates.keySet()) {
            String name = symbols.containsKey(symbol) ? symbols.get(symbol).getAsString() : "Unknown Currency";
            double rate = rates.get(symbol).getAsDouble();
            list.add(new Currency(symbol, name, rate));
        }

        return list;
    }

    private String loadJson(String urlString) throws IOException {
        URL url = new URL(urlString);
        try (InputStream is = url.openStream()) {
            return new String(is.readAllBytes());
        }
    }
}

