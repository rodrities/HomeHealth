package com.acme.blogging.resource;

import java.util.Date;

public class SubscriptionDetailsResource {
    private Long id;
    private Float discount;
    private Long duration;
    private Date endSubscription;
    private Long cost;
    private Long costTotal;

    public Long getId() {
        return id;
    }

    public SubscriptionDetailsResource setId(Long id) {
        this.id = id;
        return this;
    }

    public Float getDiscount() {
        return discount;
    }

    public SubscriptionDetailsResource setDiscount(Float discount) {
        this.discount = discount;
        return this;
    }

    public Long getDuration() {
        return duration;
    }

    public SubscriptionDetailsResource setDuration(Long duration) {
        this.duration = duration;
        return this;
    }

    public Date getEndSubscription() {
        return endSubscription;
    }

    public SubscriptionDetailsResource setEndSubscription(Date endSubscription) {
        this.endSubscription = endSubscription;
        return this;
    }

    public Long getCost() {
        return cost;
    }

    public SubscriptionDetailsResource setCost(Long cost) {
        this.cost = cost;
        return this;
    }

    public Long getCostTotal() {
        return costTotal;
    }

    public SubscriptionDetailsResource setCostTotal(Long costTotal) {
        this.costTotal = costTotal;
        return this;
    }
}
