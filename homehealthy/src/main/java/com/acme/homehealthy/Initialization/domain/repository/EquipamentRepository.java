package com.acme.homehealthy.Initialization.domain.repository;

import com.acme.homehealthy.Initialization.domain.model.Equipament;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EquipamentRepository extends JpaRepository<Equipament,Long> {
    Optional<Equipament> findEquipamentByName(String name);
}
