package com.acme.homehealthy.Meeting.domain.service;



import com.acme.homehealthy.Initialization.domain.model.Collaborator;
import com.acme.homehealthy.Meeting.domain.model.Diet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface DietService {
    Page<Diet> getAllDiets(Pageable pageable);

    Diet getDietById(Long id);

    Diet createDiet(Diet diet, Long id);

    Diet updateDiet(Long dietId, Diet diet, Long sessionId);

    Diet getDietBySessionId(Long id);

    ResponseEntity<?> deleteDiet(String name);
}
