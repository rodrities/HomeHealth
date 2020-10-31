package com.acme.homehealthy.AvailableSchedule.service;

import com.acme.homehealthy.AvailableSchedule.domain.model.availability;
import com.acme.homehealthy.AvailableSchedule.domain.repository.availabilityRepository;
import com.acme.homehealthy.AvailableSchedule.domain.service.availabilityService;
import com.acme.homehealthy.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class availabilityServiceImpl implements  availabilityService {

    @Autowired
    private availabilityRepository availabilityRepository;

    @Override
    public availability getavailabilityById(Long id) {

        return availabilityRepository.findavailabilitybyid(id).orElseThrow(()->new ResourceNotFoundException("availability","Id",id));
    }


    /////// ----------------- CRUD ------------------------
    @Override
    public availability createavailability(availability availability) {
        availability existingavailability = availabilityRepository.findavailabilitybyid(availability.getId()).orElse(null);

        if(existingavailability != null){
            throw new ResourceNotFoundException("This availability id is not found");
        }

        return availabilityRepository.save(availability);
    }




    @Override
    public availability updateavailability(Long id, availability availability) {


        availability existingavailability = availabilityRepository.findavailabilitybyid(id).orElseThrow(()->new ResourceNotFoundException("availability","Id",id));

        return availabilityRepository.save(
                existingavailability.setName(availability.getName()).setDescription(availability.getDescription()).setstate(availability.getstate())

        );
    }


    @Override
    public ResponseEntity<?> deleteavailability(Long id) {
        availability availability = availabilityRepository.findavailabilitybyid(id).orElseThrow(()->new ResourceNotFoundException("availability","id",id));
        availabilityRepository.delete(availability);
        return ResponseEntity.ok().build();
    }


    public boolean stateavailability(availability availability) {
        if (availability != null) {
                     /* pending */
        }
        return false;
    }


}
