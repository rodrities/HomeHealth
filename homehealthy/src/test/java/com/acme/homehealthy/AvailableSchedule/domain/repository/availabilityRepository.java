package com.acme.homehealthy.AvailableSchedule.domain.repository;

import com.acme.homehealthy.AvailableSchedule.domain.model.availability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface availabilityRepository extends JpaRepository<availability, Integer> {
    Optional<availability> findavailabilitybyid(long id);


}