package com.acme.blogging.resource;

import com.sun.istack.NotNull;

import java.util.Date;

public class SaveSubscriptionDetailsResource {
    @NotNull
    private Float discount;
    @NotNull
    private Long duration;
    @NotNull
    private Date endSubscription;
    @NotNull
    private Long cost;
    @NotNull
    private Long costTotal;

    public Float getDiscount() {
        return discount;
    }

    public SaveSubscriptionDetailsResource setDiscount(Float discount) {
        this.discount = discount;
        return this;
    }

    public Long getDuration() {
        return duration;
    }

    public SaveSubscriptionDetailsResource setDuration(Long duration) {
        this.duration = duration;
        return this;
    }

    public Date getEndSubscription() {
        return endSubscription;
    }

    public SaveSubscriptionDetailsResource setEndSubscription(Date endSubscription) {
        this.endSubscription = endSubscription;
        return this;
    }

    public Long getCost() {
        return cost;
    }

    public SaveSubscriptionDetailsResource setCost(Long cost) {
        this.cost = cost;
        return this;
    }

    public Long getCostTotal() {
        return costTotal;
    }

    public SaveSubscriptionDetailsResource setCostTotal(Long costTotal) {
        this.costTotal = costTotal;
        return this;
    }
}
