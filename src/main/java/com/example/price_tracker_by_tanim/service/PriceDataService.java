package com.example.price_tracker_by_tanim.service;

import com.example.price_tracker_by_tanim.model.PriceData;
import com.example.price_tracker_by_tanim.repository.PriceDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PriceDataService {

    @Autowired
    private PriceDataRepository priceDataRepository;

    public Optional<PriceData> getPriceData(String country, LocalDate date) {
        return priceDataRepository.findByCountryAndDate(country, date);
    }

    public PriceData savePriceData(PriceData priceData) {
        return priceDataRepository.save(priceData);
    }
}
