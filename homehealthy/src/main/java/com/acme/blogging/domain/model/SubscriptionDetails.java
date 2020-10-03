package com.acme.blogging.domain.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "subscription_details")
public class SubscriptionDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subscription_id")
    private Subscription subscription;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public SubscriptionDetails setId(Long id) {
        this.id = id;
        return this;
    }

    public Float getDiscount() {
        return discount;
    }

    public SubscriptionDetails setDiscount(Float discount) {
        this.discount = discount;
        return this;
    }

    public Long getDuration() {
        return duration;
    }

    public SubscriptionDetails setDuration(Long duration) {
        this.duration = duration;
        return this;
    }

    public Date getEndSubscription() {
        return endSubscription;
    }

    public SubscriptionDetails setEndSubscription(Date endSubscription) {
        this.endSubscription = endSubscription;
        return this;
    }

    public Long getCost() {
        return cost;
    }

    public SubscriptionDetails setCost(Long cost) {
        this.cost = cost;
        return this;
    }

    public Long getCostTotal() {
        return costTotal;
    }

    public SubscriptionDetails setCostTotal(Long costTotal) {
        this.costTotal = costTotal;
        return this;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public SubscriptionDetails setSubscription(Subscription subscription) {
        this.subscription = subscription;
        return this;
    }

    public User getUser() {
        return user;
    }

    public SubscriptionDetails setUser(User user) {
        this.user = user;
        return this;
    }
}
