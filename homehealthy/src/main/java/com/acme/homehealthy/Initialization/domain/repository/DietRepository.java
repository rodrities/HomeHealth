package com.acme.homehealthy.Initialization.domain.repository;



import com.acme.homehealthy.Initialization.domain.model.Diet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DietRepository extends JpaRepository<Diet,Long> {
    Optional<Diet>findDietByname(String name);

}

