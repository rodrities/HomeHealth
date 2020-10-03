package com.acme.blogging.resource;

public class SubscriptionResource {

    public Long id;
    public String name;
    public Long cost;

    public Long getId() {
        return id;
    }

    public SubscriptionResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SubscriptionResource setName(String name) {
        this.name = name;
        return this;
    }

    public Long getCost() {
        return cost;
    }

    public SubscriptionResource setCost(Long cost) {
        this.cost = cost;
        return this;
    }
}
