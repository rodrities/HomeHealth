package com.acme.homehealthy.AvailableSchedule.controller;


import com.acme.homehealthy.AvailableSchedule.domain.model.availability;
import com.acme.homehealthy.AvailableSchedule.domain.service.availabilityService;
import com.acme.homehealthy.AvailableSchedule.resource.availabilityResource;
import com.acme.homehealthy.AvailableSchedule.resource.SaveavailabilityResource;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "availability", description = "Availability API")
@RestController
@RequestMapping("api/")
public class availabilityController {
    @Autowired
    private availabilityService availabilityService;

    @Autowired
    private ModelMapper mapper;




    @GetMapping("/availability/{availabilityId}")
    public availabilityResource getavailabilityname(@Valid @PathVariable (value = "availabilityId") Long availabilityId){

        return convertToResource(availabilityService.getavailabilityById(availabilityId));
    }




    @PostMapping("/availabilitys")
    public availabilityResource createavailability(@Valid @RequestBody SaveavailabilityResource resource){
        availability availability = convertToEntity(resource);
        return convertToResource(availabilityService.createavailability(availability));
    }




    @PutMapping("/availabilitys/{availabilityId}")
    public availabilityResource updateavailability( @Valid @PathVariable (value = "availabilityId") Long availabilityId,
                                    @Valid @RequestBody SaveavailabilityResource resource){
        availability availability = convertToEntity(resource);
        return convertToResource(availabilityService.updateavailability(availabilityId,availability));
    }




    @DeleteMapping("/availabilitys/{id}")
    public ResponseEntity<?> deleteavailability(@Valid @PathVariable (value = "id") long id){
        return  availabilityService.deleteavailability(id);
    }

    private availability convertToEntity(SaveavailabilityResource resource){
        return mapper.map(resource, availability.class);
    }

    private availabilityResource convertToResource(availability availability){
        return mapper.map(availability, availabilityResource.class);
    }
}
