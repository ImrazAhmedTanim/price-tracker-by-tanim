package com.example.price_tracker_by_tanim.repository;

import com.example.price_tracker_by_tanim.model.PriceData;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.Optional;

public interface PriceDataRepository extends JpaRepository<PriceData, Long> {
    Optional<PriceData> findByCountryAndDate(String country, LocalDate date);
}

