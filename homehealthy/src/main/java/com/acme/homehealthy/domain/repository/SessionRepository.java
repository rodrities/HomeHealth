package com.acme.homehealthy.domain.repository;

import com.acme.homehealthy.domain.model.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, Long> {

    Page<Session> findByUserId(Long userId, Pageable pageable);

    Optional<Session> findByIdAndUserId(Long id, Long userId);
}
