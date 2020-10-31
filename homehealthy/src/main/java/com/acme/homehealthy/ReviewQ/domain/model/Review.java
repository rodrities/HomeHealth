package com.acme.homehealthy.ReviewQ.domain.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name="Reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;


    private String detailrevision;

    public Long getId() {
        return id;
    }

    public Review setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Review setName(String name) {
        this.name = name;
        return this;
    }


    public String getdetailrevision() {
        return detailrevision;
    }

    public Review setdetailrevision(String detailrevision) {
        this.detailrevision = detailrevision;
        return this;
    }


    public String getDescription() {
        return description;
    }

    public Review setDescription(String description) {
        this.description = description;
        return this;
    }

}
