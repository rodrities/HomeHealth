package com.acme.homehealthy.Initialization.domain.service;



import com.acme.homehealthy.Initialization.domain.model.Diet;
import org.springframework.http.ResponseEntity;

public interface DietService {
    Diet getDietById(Long id);

    Diet createDiet(Diet diet);

    Diet updateDiet(Long id, Diet diet);

    ResponseEntity<?> deleteDiet(String name);
}
