package com.acme.homehealthy.domain.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "subscriptions")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotNull
    public String name;

    @NotNull
    public Long cost;

    public Long getId() {
        return id;
    }

    public Subscription setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Subscription setName(String name) {
        this.name = name;
        return this;
    }

    public Long getCost() {
        return cost;
    }

    public Subscription setCost(Long cost) {
        this.cost = cost;
        return this;
    }
}