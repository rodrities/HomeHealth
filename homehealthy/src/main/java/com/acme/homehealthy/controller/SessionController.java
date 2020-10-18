package com.acme.homehealthy.controller;

import com.acme.homehealthy.domain.model.Session;
import com.acme.homehealthy.domain.service.SessionService;
import com.acme.homehealthy.resource.SessionResource;
import com.acme.homehealthy.resource.SaveSessionResource;
/*import io.swagger.v3.oas.annotations.parameters.RequestBody;*/
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Users", description = "Users API")
@RestController
@RequestMapping("/api")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/users/{userId}/sessions")
    public Page<SessionResource> getAllSessionsByUserId(
            @PathVariable(value = "userId") Long userId,
            Pageable pageable) {
        Page<Session> commentPage = sessionService.getAllSessionsByUserId(userId, pageable);
        List<SessionResource> resources = commentPage.getContent().stream()
                .map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/users/{userId}/sessions/{sessionId}")
    public SessionResource getSessionByIdAndUser(
            @PathVariable(name = "userId") Long userId,
            @PathVariable(name = "sessionId") Long sessionId) {
        return convertToResource(sessionService.getSessionByIdAndUserId(userId, sessionId));
    }

    @PostMapping("/users/{userId}/sessions")
    public SessionResource createSession(
            @PathVariable(value = "userId") Long userId,
            @RequestBody SaveSessionResource resource) {
        return convertToResource(sessionService.createSession(userId,
                convertToEntity(resource)));
    }

    @PutMapping("/users/{userId}/sessions/{sessionId}")
    public SessionResource updateSession(
            @PathVariable(value = "userId") Long userId,
            @PathVariable(value = "sessionId") Long sessionId,
            @RequestBody SaveSessionResource resource) {
        return convertToResource(sessionService.updateSession(userId, sessionId,
                convertToEntity(resource)));
    }

    @DeleteMapping("/users/{userId}/sessions/{sessionId}")
    public ResponseEntity<?> deleteSession(
            @PathVariable(value = "userId") Long userId,
            @PathVariable(value = "sessionId") Long sessionId) {
        return sessionService.deleteSession(userId, sessionId);
    }

    private Session convertToEntity(SaveSessionResource resource) {
        return mapper.map(resource, Session.class);
    }

    private SessionResource convertToResource(Session entity) {
        return mapper.map(entity, SessionResource.class);
    }

}