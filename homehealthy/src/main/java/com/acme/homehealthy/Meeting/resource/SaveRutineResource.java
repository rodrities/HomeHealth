package com.acme.homehealthy.Meeting.resource;

import com.sun.istack.NotNull;

import javax.validation.constraints.Size;

public class SaveRutineResource {
    public String getName() {
        return name;
    }

    public SaveRutineResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SaveRutineResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getDuration() {
        return duration;
    }

    public SaveRutineResource setDuration(String duration) {
        this.duration = duration;
        return this;
    }

    @NotNull
    @Size(max = 20)
    private String name;
    @NotNull
    @Size(max=70)
    private String description;
    @Size(max = 30)
    private String duration;
}
