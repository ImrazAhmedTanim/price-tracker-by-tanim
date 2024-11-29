package com.example.price_tracker_by_tanim.service;

import com.example.price_tracker_by_tanim.model.GoldPrice;
import com.example.price_tracker_by_tanim.repository.GoldPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class GoldPriceService {

    @Autowired
    private GoldPriceRepository goldPriceRepository;

    // Get all gold prices
    public List<GoldPrice> getAllGoldPrices() {
        return goldPriceRepository.findAll();
    }

    // Get gold price for a specific date
    public Optional<GoldPrice> getPriceByDate(LocalDate date) {
        return Optional.ofNullable(goldPriceRepository.findByDate(date));
    }

    // Get gold prices for a specific country
    public List<GoldPrice> getPricesByCountry(String country) {
        return goldPriceRepository.findByCountry(country);
    }

    // Save a gold price
    public GoldPrice saveGoldPrice(GoldPrice goldPrice) {
        return goldPriceRepository.save(goldPrice);
    }

    // Update a gold price
    public GoldPrice updateGoldPrice(GoldPrice goldPrice) {
        return goldPriceRepository.save(goldPrice);
    }

    // Delete a gold price by ID
    public void deleteGoldPrice(Long id) {
        goldPriceRepository.deleteById(id);
    }
}
