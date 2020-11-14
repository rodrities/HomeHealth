package com.acme.homehealthy.Initialization.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String description;
    public long getId() { return id; }
    public Profile setId(long id) { this.id = id; return this;}
    public String getDescription() { return description; }
    public Profile setDescription(String description) { this.description = description; return this;}
}
