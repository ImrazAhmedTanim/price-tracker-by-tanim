package com.example.price_tracker_by_tanim.repository;

import com.example.price_tracker_by_tanim.model.FuelPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FuelPriceRepository extends JpaRepository<FuelPrice, Long> {

    // Find all prices for a specific fuel type
    List<FuelPrice> findByFuelType(String fuelType);

    // Find all prices for a specific fuel type and country
    List<FuelPrice> findByFuelTypeAndCountry(String fuelType, String country);

    // Find the price for a specific fuel type and date
    FuelPrice findByFuelTypeAndDate(String fuelType, LocalDate date);

    // Find all prices for a specific country
    List<FuelPrice> findByCountry(String country);
}

