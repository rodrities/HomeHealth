package com.acme.homehealthy.domain.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sessions")
public class Session extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="start_at")
    private Date startAt;

    @Column(name = "end_at")
    private Date endAt;
    private String link;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    public Date getStartAt() {
        return startAt;
    }

    public Session setStartAt(Date startAt) {
        this.startAt = startAt;
        return this;
    }

    public Date getEndAt() {
        return endAt;
    }

    public Session setEndAt(Date endAt) {
        this.endAt = endAt;
        return this;
    }

    public String getLink() {
        return link;
    }

    public Session setLink(String link) {
        this.link = link;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Session setUser(User user) {
        this.user = user;
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
