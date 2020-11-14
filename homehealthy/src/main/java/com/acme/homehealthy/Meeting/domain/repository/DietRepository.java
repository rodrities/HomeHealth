package com.acme.homehealthy.Meeting.domain.repository;



import com.acme.homehealthy.Meeting.domain.model.Diet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DietRepository extends JpaRepository<Diet,Long> {
    Optional<Diet>findDietByname(String name);
    Optional<Diet>findDietBySession_Id(Long id);
}

