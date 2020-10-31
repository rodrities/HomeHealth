package com.acme.homehealthy.Meeting.domain.service;



import com.acme.homehealthy.Meeting.domain.model.Diet;
import org.springframework.http.ResponseEntity;

public interface DietService {
    Diet getDietById(Long id);

    Diet createDiet(Diet diet);

    Diet updateDiet(Long id, Diet diet);

    ResponseEntity<?> deleteDiet(String name);
}
