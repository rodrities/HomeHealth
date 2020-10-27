package com.acme.homehealthy.Initialization.resource;

public class SuplementResource {

    private Long id;
    private String name;
    private String description;

    public Long getId() {
        return id;
    }

    public SuplementResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SuplementResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SuplementResource setDescription(String description) {
        this.description = description;
        return this;
    }
}
