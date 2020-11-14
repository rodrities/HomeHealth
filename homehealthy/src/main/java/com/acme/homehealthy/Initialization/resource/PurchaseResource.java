package com.acme.homehealthy.Initialization.resource;

public class PurchaseResource {
    private long id;
    private String type;
    private String details;

    public long getId() { return id; }
    public PurchaseResource setId(long id) { this.id = id; return this;}

    public String getType() { return type; }
    public PurchaseResource setType(String type) { this.type = type; return this;}

    public String getDetails() { return details; }
    public PurchaseResource setDetails(String details) { this.details = details; return this;}
}
