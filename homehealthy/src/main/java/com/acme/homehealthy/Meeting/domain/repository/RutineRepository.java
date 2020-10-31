package com.acme.homehealthy.Meeting.domain.repository;

import com.acme.homehealthy.Meeting.domain.model.Rutine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RutineRepository extends JpaRepository<Rutine,Long> {
    Optional<Rutine> findRoutineByName(String name);
}