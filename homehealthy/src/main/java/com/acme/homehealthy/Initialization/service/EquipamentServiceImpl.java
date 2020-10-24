package com.acme.homehealthy.Initialization.service;

import com.acme.homehealthy.Initialization.domain.model.Equipament;
import com.acme.homehealthy.Initialization.domain.repository.EquipamentRepository;
import com.acme.homehealthy.Initialization.domain.service.EquipamentService;
import com.acme.homehealthy.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipamentServiceImpl implements EquipamentService{

    @Autowired
    private EquipamentRepository equipamentRepository;

    @Override
    public Equipament getEquipamentById(long id){
        return equipamentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Equipament","Id",id));

    }

}
