package com.acme.homehealthy.service;

import com.acme.homehealthy.domain.model.Session;
import com.acme.homehealthy.domain.repository.SessionRepository;
import com.acme.homehealthy.domain.repository.UserRepository;
import com.acme.homehealthy.domain.service.SessionService;
import com.acme.homehealthy.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<Session> getAllSessionsByUserId(Long userId, Pageable pageable) {
        return sessionRepository.findByUserId(userId, pageable);
    }

    @Override
    public Session getSessionByIdAndUserId(Long userId, Long sessionId) {
        return sessionRepository.findByIdAndUserId(sessionId, userId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Session no found with Id " + sessionId +
                                " and UserId " + userId));
    }

    @Override
    public Session createSession(Long userId, Session session) {
        return userRepository.findById(userId).map(user -> {
            session.setUser(user);
            return sessionRepository.save(session);
        })
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User", "Id", userId));
    }

    @Override
    public Session updateSession(Long userId, Long sessionId, Session sessionDetails) {
        if (!userRepository.existsById(userId))
            throw new ResourceNotFoundException("User", "Id", userId);
        return sessionRepository.findById(sessionId).map(comment -> {
            comment.setLink(sessionDetails.getLink());
            return sessionRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Session", "Id", sessionId));
    }

    @Override
    public ResponseEntity<?> deleteSession(Long userId, Long sessionId) {
        return sessionRepository.findByIdAndUserId(sessionId, userId).map(comment -> {
            sessionRepository.delete(comment);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Session not found with Id " + sessionId + " and UserId " + userId));
    }
}