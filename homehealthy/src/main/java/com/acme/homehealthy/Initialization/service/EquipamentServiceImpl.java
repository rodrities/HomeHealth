package com.acme.homehealthy.Initialization.service;

import com.acme.homehealthy.Initialization.domain.model.Equipament;
import com.acme.homehealthy.Initialization.domain.repository.EquipamentRepository;
import com.acme.homehealthy.Initialization.domain.service.EquipamentService;
import com.acme.homehealthy.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EquipamentServiceImpl implements EquipamentService{

    @Autowired
    private EquipamentRepository equipamentRepository;

    @Override
    public Equipament getEquipamentById(long id){
        return equipamentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Equipament","Id",id));

    }

    @Override
    public Equipament CreateEquipament(Equipament equipament) {
        Equipament existingname = equipamentRepository.findEquipamentByName(equipament.getName()).orElse(null);
        if(existingname != null){
            throw new ResourceNotFoundException("This name is begin used by another equipament");
        }

        return equipamentRepository.save(equipament);
    }

    @Override
    public Equipament UpdateEquipament(Long Id, Equipament equipament) {
        Equipament existingEquipament = equipamentRepository.findById(Id).orElseThrow(()->new ResourceNotFoundException("Equipament","Id",Id));

        return equipamentRepository.save(
                existingEquipament.setId(equipament.getId()).
                        setName(equipament.getName()).
                        setDescription(equipament.getDescription())
        );
    }

    @Override
    public ResponseEntity<Object> DeleteEquipament(String name) {
        Equipament equipament = equipamentRepository.findEquipamentByName(name).orElseThrow(()->new ResourceNotFoundException("Equipament","name",name));
        equipamentRepository.delete(equipament);
        return ResponseEntity.ok().build();
    }

}
