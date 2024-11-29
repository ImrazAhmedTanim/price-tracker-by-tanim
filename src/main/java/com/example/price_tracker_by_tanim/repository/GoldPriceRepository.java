package com.example.price_tracker_by_tanim.repository;

import com.example.price_tracker_by_tanim.model.GoldPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface GoldPriceRepository extends JpaRepository<GoldPrice, Long> {

    // Find the gold price for a specific date
    GoldPrice findByDate(LocalDate date);

    // Find all gold prices for a specific country
    List<GoldPrice> findByCountry(String country);

    // Find gold price for a specific date and country
    GoldPrice findByDateAndCountry(LocalDate date, String country);
}
