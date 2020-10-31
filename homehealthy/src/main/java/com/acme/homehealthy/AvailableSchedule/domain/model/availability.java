package com.acme.homehealthy.AvailableSchedule.domain.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name="availabilitys")
public class availability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;


    private boolean state;

    public Long getId() {
        return id;
    }

    public availability setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public availability setName(String name) {
        this.name = name;
        return this;
    }


    public String getdetailrevision() {
        return detailrevision;
    }

    public availability setdetailrevision(String detailrevision) {
        this.detailrevision = detailrevision;
        return this;
    }


    public String getDescription() {
        return description;
    }

    public availability setDescription(String description) {
        this.description = description;
        return this;
    }

}
