package com.acme.homehealthy.Initialization.controller;

import com.acme.homehealthy.Initialization.domain.model.Purchase;
import com.acme.homehealthy.Initialization.domain.service.PurchaseService;
import com.acme.homehealthy.Initialization.resource.PurchaseResource;
import com.acme.homehealthy.Initialization.resource.SavePurchaseResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Purchase", description = "Initialization API")
@RestController
@RequestMapping("api/")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;
    @Autowired
    private ModelMapper mapper;

    @GetMapping("/purchase/{purchaseId}")
    public PurchaseResource getPurchaseByType(@Valid @PathVariable(value = "purchaseId") Long purchaseId) {
        return convertToResource(purchaseService.getPurchaseById(purchaseId));
    }

    @PostMapping("/purchases")
    public PurchaseResource createPurchase(@Valid @RequestBody SavePurchaseResource resource){
        Purchase purchase = convertToEntity(resource);
        return convertToResource(purchaseService.createPurchase(purchase));
    }
    @PutMapping("/purchases/{purchaseId}")
    public PurchaseResource updatePurchase(@Valid @PathVariable(value = "purchaseId") long purchaseId,
                                           @RequestBody SavePurchaseResource resource){
        Purchase purchase = convertToEntity(resource);
        return convertToResource(purchaseService.updatePurchase(purchaseId, purchase));
    }

    @DeleteMapping("purchases/{type}")
    public ResponseEntity<?> deletePurchase(@Valid @PathVariable (value = "purchaseType") String purchaseType){
        return  purchaseService.deletePurchase(purchaseType);
    }


    private Purchase convertToEntity(SavePurchaseResource resource) {
        return mapper.map(resource, Purchase.class);
    }

    private PurchaseResource convertToResource(Purchase purchase) {
        return mapper.map(purchase, PurchaseResource.class);
    }

}
