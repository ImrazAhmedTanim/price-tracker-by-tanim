package com.example.price_tracker_by_tanim.controller;

import com.example.price_tracker_by_tanim.model.GoldPrice;
import com.example.price_tracker_by_tanim.service.GoldPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/gold-prices")
public class GoldPriceController {

    @Autowired
    private GoldPriceService goldPriceService;

    // Get all gold prices
    @GetMapping
    public List<GoldPrice> getAllGoldPrices() {
        return goldPriceService.getAllGoldPrices();
    }

    // Get gold price for a specific date
    @GetMapping("/date/{date}")
    public Optional<GoldPrice> getPriceByDate(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        return goldPriceService.getPriceByDate(localDate);
    }

    // Get gold prices for a specific country
    @GetMapping("/country/{country}")
    public List<GoldPrice> getPricesByCountry(@PathVariable String country) {
        return goldPriceService.getPricesByCountry(country);
    }

    // Add a new gold price
    @PostMapping
    public GoldPrice addGoldPrice(@RequestBody GoldPrice goldPrice) {
        return goldPriceService.saveGoldPrice(goldPrice);
    }

    // Update an existing gold price
    @PutMapping("/{id}")
    public GoldPrice updateGoldPrice(@PathVariable Long id, @RequestBody GoldPrice goldPrice) {
        goldPrice.setId(id);
        return goldPriceService.updateGoldPrice(goldPrice);
    }

    // Delete a gold price by ID
    @DeleteMapping("/{id}")
    public void deleteGoldPrice(@PathVariable Long id) {
        goldPriceService.deleteGoldPrice(id);
    }
}
