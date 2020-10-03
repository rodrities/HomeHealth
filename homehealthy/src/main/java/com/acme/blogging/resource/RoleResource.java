package com.acme.blogging.resource;

public class RoleResource {
    public Long id;
    public String name;

    public Long getId() {
        return id;
    }

    public RoleResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RoleResource setName(String name) {
        this.name = name;
        return this;
    }
}
