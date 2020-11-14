package com.acme.homehealthy.Initialization.resource;

public class ProfileResource {
    private long id;
    private String description;

    public long getId() { return id; }
    public ProfileResource setId(long id) { this.id = id; return this; }

    public String getDescription() { return description; }
    public ProfileResource setDescription(String description) { this.description = description; return this; }
}
