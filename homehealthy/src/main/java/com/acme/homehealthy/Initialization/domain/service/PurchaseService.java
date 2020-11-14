package com.acme.homehealthy.Initialization.domain.service;

import com.acme.homehealthy.Initialization.domain.model.Purchase;
import org.springframework.http.ResponseEntity;

public interface PurchaseService {
    Purchase getPurchaseById(long Id);
    Purchase createPurchase(Purchase purchase);
    Purchase updatePurchase(Long id, Purchase purchase);
    ResponseEntity<?> deletePurchase(String type);
}