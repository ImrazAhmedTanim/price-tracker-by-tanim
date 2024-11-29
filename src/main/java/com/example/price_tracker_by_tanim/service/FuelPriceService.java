package com.example.price_tracker_by_tanim.service;

import com.example.price_tracker_by_tanim.model.FuelPrice;
import com.example.price_tracker_by_tanim.repository.FuelPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FuelPriceService {

    @Autowired
    private FuelPriceRepository fuelPriceRepository;

    // Get all fuel prices
    public List<FuelPrice> getAllFuelPrices() {
        return fuelPriceRepository.findAll();
    }

    // Get prices for a specific fuel type
    public List<FuelPrice> getPricesByFuelType(String fuelType) {
        return fuelPriceRepository.findByFuelType(fuelType);
    }

    // Get fuel price for a specific fuel type and date
    public Optional<FuelPrice> getPriceByFuelTypeAndDate(String fuelType, LocalDate date) {
        return Optional.ofNullable(fuelPriceRepository.findByFuelTypeAndDate(fuelType, date));
    }

    // Save a fuel price
    public FuelPrice saveFuelPrice(FuelPrice fuelPrice) {
        return fuelPriceRepository.save(fuelPrice);
    }

    // Update a fuel price
    public FuelPrice updateFuelPrice(FuelPrice fuelPrice) {
        return fuelPriceRepository.save(fuelPrice);
    }

    // Delete a fuel price by ID
    public void deleteFuelPrice(Long id) {
        fuelPriceRepository.deleteById(id);
    }
}
