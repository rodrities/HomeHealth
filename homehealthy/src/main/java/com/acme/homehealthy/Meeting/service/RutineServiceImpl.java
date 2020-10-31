package com.acme.homehealthy.Meeting.service;

import com.acme.homehealthy.Meeting.domain.model.Rutine;
import com.acme.homehealthy.Meeting.domain.repository.RutineRepository;
import com.acme.homehealthy.Meeting.domain.service.RutineService;
import com.acme.homehealthy.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RutineServiceImpl implements RutineService {
    @Autowired
    private RutineRepository rutineRepository;

    @Override
    public Rutine getRutineById(Long id) {

        return rutineRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Rutine","Id",id));
    }



    @Override
    public Rutine createRutine(Rutine rutine) {
        Rutine existingRutine = rutineRepository.findRoutineByName(rutine.getName()).orElse(null);

        if(existingRutine != null){
            throw new ResourceNotFoundException("This rutine name is begin used");
        }

        return rutineRepository.save(rutine);
    }
    @Override
    public Rutine updateRutine(Long id, Rutine rutine) {


        //return dietRepository.save(existingDiet.setName(diet.getName()).setDuration(diet.getDuration()),existingDiet.setDescription(diet.getDescription()));

        Rutine existingRutine = rutineRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Rutine","Id",id));

        return rutineRepository.save(
                existingRutine.setName(rutine.getName()).setDescription(rutine.getDescription()).setDuration(rutine.getDuration())

        );
    }
    @Override
    public ResponseEntity<?> deleteRutine(String name) {
        Rutine rutine = rutineRepository.findRoutineByName(name).orElseThrow(()->new ResourceNotFoundException("Rutine","name",name));
        rutineRepository.delete(rutine);
        return ResponseEntity.ok().build();
    }
}
