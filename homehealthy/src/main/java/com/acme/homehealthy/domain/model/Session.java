package com.acme.homehealthy.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sessions")
public class Session extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name ="start_at")
    private Date startAt;

    @NotNull
    @Column(name = "end_at")
    private Date endAt;

    @NotNull
    private String link;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    public Long getId() {
        return id;
    }

    public Session setId(Long id) {
        this.id = id;
        return this;
    }

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
}
