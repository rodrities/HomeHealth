package com.acme.homehealthy.Initialization.domain.service;

import com.acme.homehealthy.Initialization.domain.model.Equipament;
import org.springframework.http.ResponseEntity;

public interface EquipamentService {

    Equipament getEquipamentById(long Id);
    Equipament CreateEquipament(Equipament equipament);
    Equipament UpdateEquipament(Long Id,Equipament equipament);
    ResponseEntity<Object> DeleteEquipament(String name);

}
