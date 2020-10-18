package com.acme.homehealthy.domain.service;

import com.acme.homehealthy.domain.model.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface SessionService {

    Page<Session> getAllSessionsByUserId(Long userId, Pageable pageable);

    Session getSessionByIdAndUserId(Long userId, Long sessionId);

    Session createSession(Long userId, Session session);

    Session updateSession(Long userId, Long sessionId, Session sessionDetails);

    ResponseEntity<?> deleteSession(Long userId, Long sessionId);
}