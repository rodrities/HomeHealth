package com.acme.homehealthy.Initialization.domain.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "equipaments")
public class Equipament {
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

    public Equipament setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Equipament setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Equipament setDescription(String description) {
        this.description = description;
        return this;
    }

}
