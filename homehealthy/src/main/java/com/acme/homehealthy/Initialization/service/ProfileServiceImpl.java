package com.acme.homehealthy.Initialization.service;

import com.acme.homehealthy.Initialization.domain.model.Profile;
import com.acme.homehealthy.Initialization.domain.repository.ProfileRepository;
import com.acme.homehealthy.Initialization.domain.service.ProfileService;
import com.acme.homehealthy.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public Profile getProfileById(long id) {
        return profileRepository.findProfileById(id).orElseThrow(() -> new ResourceNotFoundException("Profile", "Id", id));
    }
    @Override
    public Profile createProfile(Profile profile){
        Profile existingProfile = profileRepository.findProfileById(profile.getId()).orElse(null);
        if(existingProfile != null){
            throw new ResourceNotFoundException("This profile doesnt exists");
        }
        return profileRepository.save(profile);
    }

    @Override
    public Profile updateProfile(Long id, Profile profile) {
        Profile existingProfile = profileRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Profile", "Id", id));
        return profileRepository.save(existingProfile.setDescription(profile.getDescription()));
    }

    @Override
    public ResponseEntity<?> deleteProfile(String description){
        Profile profile = profileRepository.findProfileByDescription(description).orElseThrow(()->new ResourceNotFoundException("Profile", "Description", description));
        profileRepository.delete(profile);
        return ResponseEntity.ok().build();

    }
}
