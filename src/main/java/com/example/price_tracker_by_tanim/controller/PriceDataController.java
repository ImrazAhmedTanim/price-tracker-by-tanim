package com.example.price_tracker_by_tanim.controller;

import com.example.price_tracker_by_tanim.model.PriceData;
import com.example.price_tracker_by_tanim.service.PriceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/api/prices")
public class PriceDataController {

    @Autowired
    private PriceDataService priceDataService;

    // GET endpoint to retrieve price data by country and date
    @GetMapping("/{country}/{date}")
    public Optional<PriceData> getPriceData(
            @PathVariable String country,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return priceDataService.getPriceData(country, date);
    }

    // POST endpoint to save new price data
    @PostMapping
    public PriceData savePriceData(@RequestBody PriceData priceData) {
        return priceDataService.savePriceData(priceData);
    }
}
