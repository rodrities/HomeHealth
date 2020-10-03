package com.acme.blogging.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import net.bytebuddy.implementation.bind.annotation.Empty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public abstract class AuditModel implements Serializable {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    private Date createAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_at",nullable = false)
    @LastModifiedDate
    private Date updateAt;

    public Date getCreateAt() {
        return createAt;
    }

    public AuditModel setCreateAt(Date createAt) {
        this.createAt = createAt;
        return this;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public AuditModel setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
        return this;
    }
}
