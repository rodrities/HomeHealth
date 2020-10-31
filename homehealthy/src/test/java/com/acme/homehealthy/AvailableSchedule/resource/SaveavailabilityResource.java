package com.acme.homehealthy.AvailableSchedule.resource;

import com.sun.istack.NotNull;

import javax.validation.constraints.Size;

public class SaveavailabilityResource {
    
    @NotNull
    @Size(max = 20)
    private String name;
    @NotNull
    @Size(max=70)
    private String description;
    @Size(max = 2)
    private boolean state;
    
    public String getName() {
        return name;
    }

    public SaveavailabilityResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SaveavailabilityResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public boolean getstate() {
        return state;
    }

    public SaveavailabilityResource setstate(boolean state) {
        this.state = state;
        return this;
    }

 
}
