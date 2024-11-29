package com.example.price_tracker_by_tanim.controller;

import com.example.price_tracker_by_tanim.model.FuelPrice;
import com.example.price_tracker_by_tanim.service.FuelPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fuel-prices")
public class FuelPriceController {

    @Autowired
    private FuelPriceService fuelPriceService;

    // Get all fuel prices
    @GetMapping
    public List<FuelPrice> getAllFuelPrices() {
        return fuelPriceService.getAllFuelPrices();
    }

    // Get prices for a specific fuel type
    @GetMapping("/type/{fuelType}")
    public List<FuelPrice> getPricesByFuelType(@PathVariable String fuelType) {
        return fuelPriceService.getPricesByFuelType(fuelType);
    }

    // Get fuel price for a specific fuel type and date
    @GetMapping("/type/{fuelType}/date/{date}")
    public Optional<FuelPrice> getPriceByFuelTypeAndDate(@PathVariable String fuelType, @PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        return fuelPriceService.getPriceByFuelTypeAndDate(fuelType, localDate);
    }

    // Add a new fuel price
    @PostMapping
    public FuelPrice addFuelPrice(@RequestBody FuelPrice fuelPrice) {
        return fuelPriceService.saveFuelPrice(fuelPrice);
    }

    // Update an existing fuel price
    @PutMapping("/{id}")
    public FuelPrice updateFuelPrice(@PathVariable Long id, @RequestBody FuelPrice fuelPrice) {
        fuelPrice.setId(id);
        return fuelPriceService.updateFuelPrice(fuelPrice);
    }

    // Delete a fuel price by ID
    @DeleteMapping("/{id}")
    public void deleteFuelPrice(@PathVariable Long id) {
        fuelPriceService.deleteFuelPrice(id);
    }
}
