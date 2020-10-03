package com.acme.blogging.domain.repository;

import com.acme.blogging.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
