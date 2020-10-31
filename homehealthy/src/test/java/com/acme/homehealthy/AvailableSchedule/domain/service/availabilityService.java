package com.acme.homehealthy.AvailableSchedule.domain.service;



import com.acme.homehealthy.AvailableSchedule.domain.model.availability;
import org.springframework.http.ResponseEntity;

public interface availabilityService {


    availability getavailabilityById (Long id);
    availability createavailability(availability availability);

    availability updateavailability(Long id, availability availability);

    ResponseEntity<?> deleteavailability(Long id);
    boolean stateavailability(availability availability);
}
