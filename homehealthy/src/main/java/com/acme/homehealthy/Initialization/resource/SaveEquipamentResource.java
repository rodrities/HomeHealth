package com.acme.homehealthy.Initialization.resource;

import com.sun.istack.NotNull;

import javax.validation.constraints.Size;

public class SaveEquipamentResource {
    @NotNull
    @Size(max = 20)
    private String name;
    @NotNull
    @Size(max = 50)
    private String description;

    public String getName() {
        return name;
    }

    public SaveEquipamentResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SaveEquipamentResource setDescription(String description) {
        this.description = description;
        return this;
    }
}
