package com.acme.homehealthy.Initialization.service;

import com.acme.homehealthy.Initialization.domain.model.Profile;
import com.acme.homehealthy.Initialization.domain.model.Purchase;
import com.acme.homehealthy.Initialization.domain.repository.PurchaseRepository;
import com.acme.homehealthy.Initialization.domain.service.PurchaseService;
import com.acme.homehealthy.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;
    @Override
    public Purchase getPurchaseById(long id){
        return purchaseRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Purchase","Id",id));
    }
    @Override
    public Purchase createPurchase(Purchase purchase){
        Purchase existingPurchase = purchaseRepository.findPurchaseById(purchase.getId()).orElse(null);
        if(existingPurchase != null){
            throw new ResourceNotFoundException("This purchase already exists");
        }
        return purchaseRepository.save(purchase);
        }

    @Override
    public Purchase updatePurchase(Long id, Purchase purchase) {
        Purchase existingPurchase = purchaseRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Purchase","Id",id));
        return purchaseRepository.save(existingPurchase.setType(purchase.getType()).setDetails(purchase.getDetails()));
    }

    @Override
    public ResponseEntity<?> deletePurchase(String purchaseType){
        Purchase purchase = purchaseRepository.findPurchaseByType(purchaseType).orElseThrow(()->new ResourceNotFoundException("Purchase", "Type", purchaseType));
        purchaseRepository.delete(purchase);
        return ResponseEntity.ok().build();
    }
}
