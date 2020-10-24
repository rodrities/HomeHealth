package com.acme.homehealthy.Initialization.resource;

import com.sun.istack.NotNull;

public class EquipamentResource {

    private Long id;
    private String name;
    private String description;


    public Long getId() {
        return id;
    }

    public EquipamentResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public EquipamentResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public EquipamentResource setDescription(String description) {
        this.description = description;
        return this;
    }
}
