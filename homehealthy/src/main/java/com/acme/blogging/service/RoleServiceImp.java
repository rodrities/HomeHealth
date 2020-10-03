package com.acme.blogging.service;

import com.acme.blogging.domain.model.Role;
import com.acme.blogging.domain.repository.RoleRepository;
import com.acme.blogging.domain.service.RoleService;
import com.acme.blogging.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;

@Service
public class RoleServiceImp implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Page<Role> getAllRoles(Pageable pageable) {
        return null;
    }

    @Override
    public Role getRoleById(Long roleId) {
        return roleRepository.findById(roleId).orElseThrow(()->new ResourceNotFoundException("Role","Id",roleId));
    }

    @Override
    public Role createRole(Role roleDetails) {
        return roleRepository.save(roleDetails);
    }

    @Override
    public Role updateRole(Long id, Role roleDetails) {
        Role role = roleRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Role","Id",id));
        return roleRepository.save(
                role.setName(roleDetails.getName()));
    }

    @Override
    public ResponseEntity<?> deleteRole(Long roleId) {
        Role role = roleRepository.findById(roleId).orElseThrow(()->new ResourceNotFoundException("Role","Id",roleId));
        roleRepository.delete(role);
        return ResponseEntity.ok().build();
    }
}
