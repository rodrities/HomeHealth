package com.acme.homehealthy.ReviewQ.resource;

import com.sun.istack.NotNull;

import javax.validation.constraints.Size;

public class SaveReviewResource {

    public String getName() {
        return name;
    }

    public SaveReviewResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SaveReviewResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getdetailrevision() {
        return detailrevision;
    }

    public SaveReviewResource setdetailrevision(String detailrevision) {
        this.detailrevision = detailrevision;
        return this;
    }

    @NotNull
    @Size(max = 20)
    private String name;
    @NotNull
    @Size(max=70)
    private String description;
    @Size(max = 30)
    private String detailrevision;
}
