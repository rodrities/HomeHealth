package com.acme.homehealthy.ReviewQ.resource;

public class ReviewResource {
    public Long getId() {
        return id;
    }

    public ReviewResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ReviewResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ReviewResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getDuration() {
        return duration;
    }

    public ReviewResource setDuration(String duration) {
        this.duration = duration;
        return this;
    }

    private Long id;
    private String name;
    private String description;
    private String duration;
}
