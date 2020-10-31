package com.acme.homehealthy.Meeting.domain.service;

import com.acme.homehealthy.Meeting.domain.model.Rutine;
import org.springframework.http.ResponseEntity;

public interface RutineService {
    Rutine getRutineById(Long id);

    Rutine createRutine(Rutine rutine);

    Rutine updateRutine(Long id, Rutine rutine);

    ResponseEntity<?> deleteRutine(String name);
}
