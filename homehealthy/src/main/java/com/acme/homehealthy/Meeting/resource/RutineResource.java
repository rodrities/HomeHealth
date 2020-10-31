package com.acme.homehealthy.Meeting.resource;

public class RutineResource {
    public Long getId() {
        return id;
    }

    public RutineResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RutineResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RutineResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getDuration() {
        return duration;
    }

    public RutineResource setDuration(String duration) {
        this.duration = duration;
        return this;
    }

    private Long id;
    private String name;
    private String description;
    private String duration;
}
