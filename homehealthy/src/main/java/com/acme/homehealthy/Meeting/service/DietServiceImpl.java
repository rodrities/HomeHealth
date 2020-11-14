package com.acme.homehealthy.Meeting.service;

import com.acme.homehealthy.Meeting.domain.model.Diet;
import com.acme.homehealthy.Meeting.domain.model.Session;
import com.acme.homehealthy.Meeting.domain.repository.DietRepository;
import com.acme.homehealthy.Meeting.domain.repository.SessionRepository;
import com.acme.homehealthy.Meeting.domain.service.DietService;
import com.acme.homehealthy.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DietServiceImpl implements  DietService {

    @Autowired
    private DietRepository dietRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public Diet getDietById(Long id) {
        return dietRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Diet","Id",id));
    }

    @Override
    public Diet createDiet(Diet diet, Long id) {
        Diet existingDiet = dietRepository.findDietByname(diet.getName()).orElse(null);
        Session existingSession = sessionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Session","Id",id));

        diet.setSession(existingSession);
        if(existingDiet != null){
            throw new ResourceNotFoundException("This diet name is begin used");
        }

        return dietRepository.save(diet);
    }
    @Override
    public Diet updateDiet(Long id, Diet diet, Long sessionId) {
        Diet existingDiet = dietRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Diet","Id",id));
        Session existingSession = sessionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Session","Id",id));


        return dietRepository.save(
              existingDiet.setName(diet.getName()).setDescription(diet.getDescription()).setDuration(diet.getDuration()).setSession(existingSession)
        );
    }

    @Override
    public Diet getDietBySessionId(Long id) {
        return dietRepository.findDietBySession_Id(id).orElseThrow(()-> new ResourceNotFoundException("Session","Id",id));
    }

    @Override
    public ResponseEntity<?> deleteDiet(String name) {
        Diet diet = dietRepository.findDietByname(name).orElseThrow(()->new ResourceNotFoundException("Diet","name",name));
        dietRepository.delete(diet);
        return ResponseEntity.ok().build();
    }


}
