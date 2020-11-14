package com.acme.homehealthy.Meeting.controller;

import com.acme.homehealthy.Meeting.domain.model.Diet;
import com.acme.homehealthy.Meeting.domain.repository.DietRepository;
import com.acme.homehealthy.Meeting.domain.service.DietService;
import com.acme.homehealthy.Meeting.resource.DietResource;
import com.acme.homehealthy.Meeting.resource.SaveDietResource;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Diet", description = "Initialization API")
@RestController
@RequestMapping("api/")
public class DietController {
    @Autowired
    private DietService dietService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/diets/{dietId}")
    public DietResource getDietname(@Valid @PathVariable (value = "dietId") Long dietId){

        return convertToResource(dietService.getDietById(dietId));
    }


    @PostMapping("/diets/sessions/{id}")
    public DietResource createDiet(@Valid @RequestBody SaveDietResource resource,
                                    @Valid @PathVariable (value = "id") Long id){
        Diet diet = convertToEntity(resource);
        return convertToResource(dietService.createDiet(diet,id));
    }

    @PutMapping("/diets/{dietId}/{sessionId}")
    public DietResource updateDiet( @Valid @PathVariable (value = "dietId") Long dietId,
                                    @Valid @RequestBody SaveDietResource resource,
                                    @Valid @PathVariable (value = "sessionId") Long sessionId){
        Diet diet = convertToEntity(resource);
        return convertToResource(dietService.updateDiet(dietId,diet, sessionId));
    }

    @DeleteMapping("/diets/{name}")
    public ResponseEntity<?> deleteDiet(@Valid @PathVariable (value = "name") String name){
        return  dietService.deleteDiet(name);
    }

    @GetMapping("/diets/sessions/{id}")
    public DietResource getDietBySessionId(Long id){
        return convertToResource(dietService.getDietBySessionId(id));
    }

    ////////////////////////
    private Diet convertToEntity(SaveDietResource resource){
        return mapper.map(resource, Diet.class);
    }

    private DietResource convertToResource(Diet diet){
        return mapper.map(diet, DietResource.class);
    }
}
