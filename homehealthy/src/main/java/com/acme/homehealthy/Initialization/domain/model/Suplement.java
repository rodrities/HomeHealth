package com.acme.homehealthy.Initialization.domain.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "suplements")
public class Suplement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;


    public Long getId() {
        return id;
    }

    public Suplement setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Suplement setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Suplement setDescription(String description) {
        this.description = description;
        return this;
    }
}
