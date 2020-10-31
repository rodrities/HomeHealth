package com.acme.homehealthy.Meeting.service;

import com.acme.homehealthy.Meeting.domain.model.Diet;
import com.acme.homehealthy.Meeting.domain.repository.DietRepository;
import com.acme.homehealthy.Meeting.domain.service.DietService;
import com.acme.homehealthy.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DietServiceImpl implements  DietService {

    @Autowired
    private DietRepository dietRepository;

    @Override
    public Diet getDietById(Long id) {

        return dietRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Diet","Id",id));
    }



    @Override
    public Diet createDiet(Diet diet) {
        Diet existingDiet = dietRepository.findDietByname(diet.getName()).orElse(null);

        if(existingDiet != null){
            throw new ResourceNotFoundException("This diet name is begin used");
        }

        return dietRepository.save(diet);
    }
    @Override
    public Diet updateDiet(Long id, Diet diet) {


        //return dietRepository.save(existingDiet.setName(diet.getName()).setDuration(diet.getDuration()),existingDiet.setDescription(diet.getDescription()));

        Diet existingDiet = dietRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Diet","Id",id));

        return dietRepository.save(
              existingDiet.setName(diet.getName()).setDescription(diet.getDescription()).setDuration(diet.getDuration())

        );
    }
    @Override
    public ResponseEntity<?> deleteDiet(String name) {
        Diet diet = dietRepository.findDietByname(name).orElseThrow(()->new ResourceNotFoundException("Diet","name",name));
        dietRepository.delete(diet);
        return ResponseEntity.ok().build();
    }


}
