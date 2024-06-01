package controller;

import com.google.gson.*;
import model.CurrencyDto;
import model.CurrencyModel;
import service.ApiService;
import service.ApiServiceImpl;
import validators.Validators;

import java.net.http.HttpResponse;

public class CurrencyController {
    private ApiService apiService;
    private String apiKey = "Tu API Key";
    private String url;

    private CurrencyModel getApiData() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        try {
            this.url = "https://v6.exchangerate-api.com/v6/" + this.apiKey + "/latest/USD";
            apiService = new ApiServiceImpl(this.url);

            HttpResponse<String> response = apiService.getData();

            // Parseo a JSON
            JsonParser parser = new JsonParser();
            JsonElement tree = parser.parse(response.body());
            JsonObject object = tree.getAsJsonObject();

            // Filtrar el objeto que contiene la información de la moneda
            JsonObject conversionRates = object.getAsJsonObject("conversion_rates");

            CurrencyDto currencyDto = gson.fromJson(conversionRates, CurrencyDto.class);
            CurrencyModel currencyModel = new CurrencyModel(currencyDto);
            return currencyModel;
        } catch (Exception e) {
            System.out.println("Error en la búsqueda");
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Double convertCurrency(String baseCurrency, String targetCurrency, Double amount) {
        if (!Validators.isDoublePositive(String.valueOf(amount))
                || !Validators.isDoubleOutOfRange(String.valueOf(amount), 0, 1000000000000000.0)) {
            throw new IllegalArgumentException("La cantidad ingresada no es válida");
        }
        CurrencyModel currencyModel = getApiData();
        float baseCurrencyValue = currencyModel.getCurrenciesValue(baseCurrency);
        float targetCurrencyValue = currencyModel.getCurrenciesValue(targetCurrency);
        return (amount / baseCurrencyValue) * targetCurrencyValue;
    }
}
