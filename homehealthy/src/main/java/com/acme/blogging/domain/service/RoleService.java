package com.acme.blogging.domain.service;

import com.acme.blogging.domain.model.Role;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.awt.print.Pageable;

public interface RoleService {
    Page<Role> getAllRoles(Pageable pageable);
    Role getRoleById(Long roleId);
    Role createRole(Role roleDetails);
    Role updateRole(Long id, Role roleDetails);
    ResponseEntity<?> deleteRole(Long roleId);
}