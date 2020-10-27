package com.acme.homehealthy.Initialization.controller;

import com.acme.homehealthy.Initialization.domain.model.Suplement;
import com.acme.homehealthy.Initialization.domain.service.SuplementService;
import com.acme.homehealthy.Initialization.resource.SuplementResource;
import com.acme.homehealthy.Initialization.resource.SaveSuplementResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Suplement", description = "Initialization API")
@RestController
@RequestMapping("api/")
public class SuplementController {

    @Autowired
    private SuplementService suplementService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/suplements/{suplementId}")
    public SuplementResource getSuplementByName(@Valid @PathVariable(value = "suplementId") Long suplementId) {
        return convertToResource(suplementService.getSuplementById(suplementId));

    }

    @PostMapping("/suplements")
    public SuplementResource createSuplement(@Valid @RequestBody SaveSuplementResource resource) {
        Suplement suplement = convertToEntity(resource);
        return convertToResource(suplementService.CreateSuplement(suplement));
    }

    @PutMapping("/suplements/{suplementId}")
    public SuplementResource updateSuplement(@Valid @PathVariable(value = "suplementId") Long suplementId,
                                               @Valid @RequestBody SaveSuplementResource resource) {
        Suplement suplement = convertToEntity(resource);
        return convertToResource(suplementService.UpdateSuplement(suplementId, suplement));
    }

    @DeleteMapping("/suplements/{name}")
    public ResponseEntity<?> deleteSuplement(@Valid @PathVariable(value = "name") String name) {
        return suplementService.DeleteSuplement(name);
    }


    private Suplement convertToEntity(SaveSuplementResource resource) {
        return mapper.map(resource, Suplement.class);
    }

    private SuplementResource convertToResource(Suplement suplement) {
        return mapper.map(suplement, SuplementResource.class);
    }


}

