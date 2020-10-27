package com.acme.homehealthy.Initialization.domain.service;

import com.acme.homehealthy.Initialization.domain.model.Suplement;
import org.springframework.http.ResponseEntity;

public interface SuplementService {

    Suplement getSuplementById(long Id);
    Suplement CreateSuplement(Suplement suplement);
    Suplement UpdateSuplement(Long Id,Suplement suplement);
    ResponseEntity<?> DeleteSuplement(String name);
}
