package com.acme.homehealthy.MemberShip.domain.model;

import com.acme.homehealthy.Initialization.domain.model.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "order_subscriptions")
public class OrderSubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Plan plan;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Customer customer;

    @NotNull
    private Long amounthOfMonth;

    @NotNull
    private Long totalPrice;

    public Long getId() {
        return id;
    }

    public OrderSubscription setId(Long id) {
        this.id = id;
        return this;
    }

    public Plan getPlan() {
        return plan;
    }

    public OrderSubscription setPlan(Plan plan) {
        this.plan = plan;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public OrderSubscription setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Long getAmounthOfMonth() {
        return amounthOfMonth;
    }

    public OrderSubscription setAmounthOfMonth(Long amounthOfMonth) {
        this.amounthOfMonth = amounthOfMonth;
        return this;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public OrderSubscription setTotalPrice() {
        this.totalPrice = plan.getPrice() * amounthOfMonth;
        return this;
    }

}
