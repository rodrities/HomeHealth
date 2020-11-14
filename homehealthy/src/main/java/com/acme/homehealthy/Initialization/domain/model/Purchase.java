package com.acme.homehealthy.Initialization.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "purchases")
public class Purchase {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
@NotNull
private String type;
@NotNull
private String details;

        public long getId() {
                return id;
        }
        public Purchase setId(long id) { this.id = id; return this; }
        public String getDetails() {
                return details;
        }
        public Purchase setDetails(String details) { this.details = details; return this; }
        public String getType() {
                return type;
        }
        public Purchase setType(String type) { this.type = type; return this; }
}
