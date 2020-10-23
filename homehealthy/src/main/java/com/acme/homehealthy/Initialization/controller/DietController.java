package com.acme.homehealthy.Initialization.controller;

import com.acme.homehealthy.Initialization.domain.model.Customer;
import com.acme.homehealthy.Initialization.domain.model.Diet;
import com.acme.homehealthy.Initialization.domain.service.CustomerService;
import com.acme.homehealthy.Initialization.domain.service.DietService;
import com.acme.homehealthy.Initialization.resource.CustomerResource;
import com.acme.homehealthy.Initialization.resource.DietResource;
import com.acme.homehealthy.Initialization.resource.SaveCustomerResource;
import com.acme.homehealthy.Initialization.resource.SaveDietResource;

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

    @GetMapping("/Diet/{dietId}")
    public DietResource getDietname(@Valid @PathVariable (value = "dietId") Long dietId){

        return convertToResource(dietService.getDietById(dietId));
    }


    @PostMapping("/diets")
    public DietResource createDiet(@Valid @RequestBody SaveDietResource resource){
        Diet diet = convertToEntity(resource);
        return convertToResource(dietService.createDiet(diet));
    }

    @PutMapping("/diets/{dietId}")
    public DietResource updateDiet( @Valid @PathVariable (value = "dietId") Long dietId,
                                            @Valid @RequestBody SaveDietResource resource){
        Diet diet = convertToEntity(resource);
        return convertToResource(dietService.updateDiet(dietId,diet));
    }

    @DeleteMapping("/diets/{name}")
    public ResponseEntity<?> deleteDiet(@Valid @PathVariable (value = "name") String name){
        return  dietService.deleteDiet(name);
    }





    ////////////////////////
    private Diet convertToEntity(SaveDietResource resource){
        return mapper.map(resource, Diet.class);
    }

    private DietResource convertToResource(Diet diet){
        return mapper.map(diet, DietResource.class);
    }
}
