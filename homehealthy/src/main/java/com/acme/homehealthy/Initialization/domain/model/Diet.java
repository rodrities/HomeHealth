package com.acme.homehealthy.Initialization.domain.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name="diets")
public class Diet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;


    private String duration;

    public Long getId() {
        return id;
    }

    public Diet setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Diet setName(String name) {
        this.name = name;
        return this;
    }


    public String getDuration() {
        return duration;
    }

    public Diet setDuration(String duration) {
        this.duration = duration;
        return this;
    }


    public String getDescription() {
        return description;
    }

    public Diet setDescription(String description) {
        this.description = description;
        return this;
    }

}
