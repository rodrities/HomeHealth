package com.acme.homehealthy.Initialization.service;

import com.acme.homehealthy.Initialization.domain.model.Suplement;
import com.acme.homehealthy.Initialization.domain.repository.SuplementRepository;
import com.acme.homehealthy.Initialization.domain.service.SuplementService;
import com.acme.homehealthy.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SuplementServiceImpl implements SuplementService {

    @Autowired
    private SuplementRepository suplementRepository;

    @Override
    public Suplement getSuplementById(long id){
        return suplementRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Suplement","Id",id));

    }

    @Override
    public Suplement CreateSuplement(Suplement suplement) {
        Suplement existingname = suplementRepository.findSuplementByName(suplement.getName()).orElse(null);
        if(existingname != null){
            throw new ResourceNotFoundException("This name is begin used by another suplement");
        }

        return suplementRepository.save(suplement);
    }

    @Override
    public Suplement UpdateSuplement(Long Id, Suplement suplement) {
        Suplement existingSuplement = suplementRepository.findById(Id).orElseThrow(()->new ResourceNotFoundException("Suplement","Id",Id));

        return suplementRepository.save(
                existingSuplement.setId(suplement.getId()).
                        setName(suplement.getName()).
                        setDescription(suplement.getDescription())
        );
    }

    @Override
    public ResponseEntity<Object> DeleteSuplement(String name) {
        Suplement suplement = suplementRepository.findSuplementByName(name).orElseThrow(()->new ResourceNotFoundException("Suplement","name",name));
        suplementRepository.delete(suplement);
        return ResponseEntity.ok().build();
    }

}
