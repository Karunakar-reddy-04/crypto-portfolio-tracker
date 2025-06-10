package com.crypto.backend.controller;

import com.crypto.backend.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/prices")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @PostMapping
    public Map<String, Double> getPrices(@RequestBody List<String> symbols) {
        return priceService.fetchPrices(symbols);
    }
}
