package com.acme.homehealthy.AvailableSchedule.resource;

public class availabilityResource {


    private Long id;
    private String name;
    private String description;
    private boolean state;


    public Long getId() {
        return id;
    }

    public availabilityResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public availabilityResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public availabilityResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public boolean getstate() {
        return state;
    }

    public availabilityResource setstate(boolean state) {
        this.state = state;
        return this;
    }

}
