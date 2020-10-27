package com.acme.homehealthy.Initialization.controller;


import com.acme.homehealthy.Initialization.domain.model.Equipament;
import com.acme.homehealthy.Initialization.domain.service.EquipamentService;
import com.acme.homehealthy.Initialization.resource.EquipamentResource;
import com.acme.homehealthy.Initialization.resource.SaveEquipamentResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Equipament", description = "Initialization API")
@RestController
@RequestMapping("api/")
public class EquipamentController {

    @Autowired
    private EquipamentService equipamentService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/equipaments/{equipamentId}")
    public EquipamentResource getEquipamentByName(@Valid @PathVariable(value = "equipamentId") Long equipamentId) {
        return convertToResource(equipamentService.getEquipamentById(equipamentId));

    }

    @PostMapping("/equipaments")
    public EquipamentResource createEquipament(@Valid @RequestBody SaveEquipamentResource resource) {
        Equipament equipament = convertToEntity(resource);
        return convertToResource(equipamentService.CreateEquipament(equipament));
    }

    @PutMapping("/equipaments/{equipamentId}")
    public EquipamentResource updateEquipament(@Valid @PathVariable(value = "equipamentId") Long equipamentId,
                                           @Valid @RequestBody SaveEquipamentResource resource) {
        Equipament equipament = convertToEntity(resource);
        return convertToResource(equipamentService.UpdateEquipament(equipamentId, equipament));
    }

    @DeleteMapping("/equipaments/{name}")
    public ResponseEntity<?> deleteEquipament(@Valid @PathVariable(value = "name") String name) {
        return equipamentService.DeleteEquipament(name);
    }


    private Equipament convertToEntity(SaveEquipamentResource resource) {
        return mapper.map(resource, Equipament.class);
    }

    private EquipamentResource convertToResource(Equipament equipament) {
        return mapper.map(equipament, EquipamentResource.class);
    }


}
