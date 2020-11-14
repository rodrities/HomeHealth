package com.acme.homehealthy.Initialization.resource;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SavePurchaseResource {
    @NotNull
    @Size(max = 20)
    private String type;
    @NotNull
    @Size(max = 30)
    private String details;

    public String getType() { return type; }
    public SavePurchaseResource setType(String type) { this.type = type; return this;}

    public String getDetails() { return details; }
    public SavePurchaseResource setDetails(String details) { this.details = details; return this;}

}
