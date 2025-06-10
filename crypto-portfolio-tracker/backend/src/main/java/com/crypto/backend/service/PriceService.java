package com.crypto.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.*;

@Service
public class PriceService {

    private final RestTemplate restTemplate = new RestTemplate();

    public Map<String, Double> fetchPrices(List<String> coinSymbols) {
        // Convert symbols to CoinGecko IDs (very basic mapping for now)
        Map<String, String> symbolToId = Map.of(
                "BTC", "bitcoin",
                "ETH", "ethereum",
                "SOL", "solana"
        );

        List<String> ids = coinSymbols.stream()
                .map(sym -> symbolToId.getOrDefault(sym.toUpperCase(), ""))
                .filter(id -> !id.isEmpty())
                .toList();

        String idsParam = String.join(",", ids);
        String url = "https://api.coingecko.com/api/v3/simple/price?ids=" + idsParam + "&vs_currencies=usd";

        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);

        Map<String, Object> prices = response.getBody();
        Map<String, Double> result = new HashMap<>();

        if (prices != null) {
            for (String symbol : coinSymbols) {
                String id = symbolToId.get(symbol.toUpperCase());
                if (id != null && prices.containsKey(id)) {
                    Map<?, ?> data = (Map<?, ?>) prices.get(id);
                    Double price = ((Number) data.get("usd")).doubleValue();
                    result.put(symbol.toUpperCase(), price);
                }
            }
        }

        return result;
    }
}
