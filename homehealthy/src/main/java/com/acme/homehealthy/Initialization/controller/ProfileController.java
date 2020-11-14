package com.acme.homehealthy.Initialization.controller;

import com.acme.homehealthy.Initialization.domain.model.Profile;
import com.acme.homehealthy.Initialization.domain.service.ProfileService;
import com.acme.homehealthy.Initialization.resource.ProfileResource;
import com.acme.homehealthy.Initialization.resource.SaveProfileResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Tag(name = "Profile", description = "Initialization API")
@RestController
@RequestMapping("api/")
public class ProfileController {
    @Autowired
    private ProfileService profileService;
    @Autowired
    private ModelMapper mapper;
    @GetMapping("/profile/{profileId}")
    public ProfileResource getProfileByDescription(@Valid @PathVariable(value = "profileId") Long profileId){
        return convertToResource(profileService.getProfileById(profileId));
    }
    @PostMapping("/profiles")
    public ProfileResource createProfile(@Valid @RequestBody SaveProfileResource resource){
        Profile profile = convertToEntity(resource);
        return convertToResource(profileService.createProfile(profile));
    }
    @PutMapping("/profiles/{profileId}")
    public ProfileResource updateProfile(@Valid @PathVariable(value = "profileId") Long profileId,
                                         @RequestBody SaveProfileResource resource){
        Profile profile = convertToEntity(resource);
        return convertToResource(profileService.updateProfile(profileId ,profile));
    }
    @DeleteMapping("profiles/{description}")
    public ResponseEntity<?> deleteProfile(@Valid @PathVariable (value = "description") String description){
        return  profileService.deleteProfile(description);
    }


    private Profile convertToEntity(SaveProfileResource resource){return mapper.map(resource, Profile.class); }
    private ProfileResource convertToResource(Profile profile){
        return mapper.map(profile, ProfileResource.class);
    }
}
