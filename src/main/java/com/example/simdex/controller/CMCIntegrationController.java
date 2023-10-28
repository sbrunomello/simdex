package com.example.simdex.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.json.Json;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonReader;


import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class CMCIntegrationController {
    private static final String apiKey = "82235c5e-cb17-4409-ab84-da9124848bae";

    @GetMapping("/price")
    public  ResponseEntity<String> getPrice()  {
        String cryptoSymbol = "BTC";

        String apiUrl = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest";
        String apiKeyParam = "CMC_PRO_API_KEY=" + apiKey;
        String symbolParam = "symbol=" + cryptoSymbol;


        try {
            String url = apiUrl + "?" + apiKeyParam + "&" + symbolParam;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String responseBody = response.body();
                JsonReader jsonReader = Json.createReader(new StringReader(responseBody));
                JsonObject jsonObject = jsonReader.readObject();
                JsonObject cryptoData = jsonObject.getJsonObject("data").getJsonObject(cryptoSymbol);
                JsonNumber price = cryptoData.getJsonObject("quote").getJsonObject("USD").getJsonNumber("price");


                return ResponseEntity.ok("name: " + cryptoData.getString("name") + " | " + "price: " + price);
            } else {
                System.out.println("Erro na chamada da API: Código " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok("responseBody");
    }
}
