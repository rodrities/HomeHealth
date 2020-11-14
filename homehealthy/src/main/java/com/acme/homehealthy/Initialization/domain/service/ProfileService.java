package com.acme.homehealthy.Initialization.domain.service;

import com.acme.homehealthy.Initialization.domain.model.Profile;
import org.springframework.http.ResponseEntity;

public interface ProfileService {
    Profile getProfileById(long Id);
    Profile createProfile(Profile profile);
    Profile updateProfile(Long id, Profile profile);
    ResponseEntity<?> deleteProfile(String description);
}
