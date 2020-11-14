package com.acme.homehealthy.Initialization.domain.repository;

import com.acme.homehealthy.Initialization.domain.model.Profile;
import com.acme.homehealthy.Initialization.domain.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findProfileById(long id);
    Optional<Profile> findProfileByDescription(String description);

}
