package com.acme.homehealthy.Initialization.domain.repository;

import com.acme.homehealthy.Initialization.domain.model.Suplement;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SuplementRepository extends JpaRepository<Suplement,Long> {

    Optional<Suplement> findSuplementByName(String name);
}
