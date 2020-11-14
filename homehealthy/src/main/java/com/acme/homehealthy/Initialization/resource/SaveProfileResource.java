package com.acme.homehealthy.Initialization.resource;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SaveProfileResource {
    @NotNull
    @Size(max = 70)
    private String description;

    public String getDescription() { return description; }
    public SaveProfileResource setDescription(String description) { this.description = description; return this; }
}
