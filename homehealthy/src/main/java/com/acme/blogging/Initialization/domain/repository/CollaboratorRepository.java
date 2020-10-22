package com.acme.blogging.Initialization.domain.repository;

import com.acme.blogging.Initialization.domain.model.Collaborator;
import com.acme.blogging.Initialization.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CollaboratorRepository extends JpaRepository<Collaborator,Long> {
    Optional<Collaborator> findCollaboratorByEmail(String email);
    Optional<Collaborator> findCollaboratorByUsername(String username);
    Optional<Collaborator> findCollaboratorByUsernameAndEmail(String username, String password);
}
