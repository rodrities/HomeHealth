package com.acme.homehealthy.Initialization.domain.repository;

import com.acme.homehealthy.Initialization.domain.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    Optional<Purchase> findPurchaseByType(String type);
    Optional<Purchase> findPurchaseById(long id);
}
