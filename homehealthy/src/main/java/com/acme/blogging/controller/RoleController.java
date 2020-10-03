package com.acme.blogging.controller;

import com.acme.blogging.domain.model.Role;
import com.acme.blogging.domain.service.RoleService;
import com.acme.blogging.resource.RoleResource;
import com.acme.blogging.resource.SaveRoleResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class RoleController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private RoleService roleService;

    @GetMapping("/role/{roleId}")
    public RoleResource getRoleById(@PathVariable (value = "roleId") Long roleId){
        return convertToResource(roleService.getRoleById(roleId));
    }

    @PostMapping("/roles")
    public RoleResource createRole(@Valid @RequestBody SaveRoleResource roleResource){
        Role role = convertToEntity(roleResource);
        return convertToResource(roleService.createRole(role));
    }

    @PutMapping("/roles/{roleID}")
    public RoleResource PutRole(@PathVariable (value =  "roleId") Long roleId, @Valid @RequestBody SaveRoleResource roleResource){
        Role role = convertToEntity(roleResource);
        return convertToResource(roleService.updateRole(roleId,role));
    }

    private Role convertToEntity(SaveRoleResource resource){
        return mapper.map(resource, Role.class);
    }

    private RoleResource convertToResource(Role entity){
        return mapper.map(entity, RoleResource.class);
    }

}
