package com.acme.homehealthy.Meeting.resource;

public class DietResource {
    public Long getId() {
        return id;
    }

    public DietResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public DietResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public DietResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getDuration() {
        return duration;
    }

    public DietResource setDuration(String duration) {
        this.duration = duration;
        return this;
    }

    private Long id;
    private String name;
    private String description;
    private String duration;
}
