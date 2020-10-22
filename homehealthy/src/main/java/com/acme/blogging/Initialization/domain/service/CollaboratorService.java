package com.acme.blogging.Initialization.domain.service;

import com.acme.blogging.Initialization.domain.model.Collaborator;
import org.springframework.http.ResponseEntity;

public interface CollaboratorService {
    Collaborator getCollaboratorById(Long id);
    Collaborator createCollaborator(Collaborator collaborator);
    Collaborator updateCollaborator(Long id, Collaborator collaborator);
    Collaborator getCollaboratorByUsernameAndPassword(String username, String password);
    ResponseEntity<?> deleteCollaborator(String username);
}
