package com.acme.homehealthy.resource;

import com.sun.istack.NotNull;

import javax.validation.constraints.Size;

public class SaveSubscriptionResource {
    @NotNull
    @Size(max = 20)
    public String name;

    @NotNull
    public Long cost;

    public String getName() {
        return name;
    }

    public SaveSubscriptionResource setName(String name) {
        this.name = name;
        return this;
    }

    public Long getCost() {
        return cost;
    }

    public SaveSubscriptionResource setCost(Long cost) {
        this.cost = cost;
        return this;
    }
}