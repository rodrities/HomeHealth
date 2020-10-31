package com.acme.homehealthy.Meeting.controller;

import com.acme.homehealthy.Meeting.domain.model.Rutine;
import com.acme.homehealthy.Meeting.domain.service.RutineService;

import com.acme.homehealthy.Meeting.resource.RutineResource;
import com.acme.homehealthy.Meeting.resource.SaveRutineResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Routine", description = "Initialization API")
@RestController
@RequestMapping("api/")
public class RutineController {
    @Autowired
    private RutineService rutineService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/routines/{routineId}")
    public RutineResource getname(@Valid @PathVariable (value = "routineId") Long dietId){

        return convertToResource(rutineService.getRutineById(dietId));
    }


    @PostMapping("/routines")
    public RutineResource createRutine(@Valid @RequestBody SaveRutineResource resource){
        Rutine rutine = convertToEntity(resource);
        return convertToResource(rutineService.createRutine(rutine));
    }

    @PutMapping("/routines/{routineId}")
    public RutineResource updateRutine( @Valid @PathVariable (value = "routineId") Long rutineId,
                                    @Valid @RequestBody SaveRutineResource resource){
        Rutine rutine = convertToEntity(resource);
        return convertToResource(rutineService.updateRutine(rutineId,rutine));
    }

    @DeleteMapping("/routines/{name}")
    public ResponseEntity<?> deleteDiet(@Valid @PathVariable (value = "name") String name){
        return  rutineService.deleteRutine(name);
    }





    ////////////////////////
    private Rutine convertToEntity(SaveRutineResource resource){
        return mapper.map(resource, Rutine.class);
    }

    private RutineResource convertToResource(Rutine rutine){
        return mapper.map(rutine, RutineResource.class);
    }
}
