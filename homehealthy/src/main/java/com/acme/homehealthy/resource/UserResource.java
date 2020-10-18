package com.acme.homehealthy.resource;

import com.acme.homehealthy.domain.model.AuditModel;
import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class UserResource extends AuditModel {

    private Long id;
    private String username;
    private String password;
    private String name;
    private String lastname;
    private String email;
    private Long phone;
    private String address;
    private Boolean active;
    private Date birthday;

    public String getAddress() {
        return address;
    }

    public UserResource setAddress(String address) {
        this.address = address;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public UserResource setActive(Boolean active) {
        this.active = active;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public UserResource setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public Long getId() {
        return id;
    }

    public UserResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserResource setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserResource setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public UserResource setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public Long getPhone() {
        return phone;
    }

    public UserResource setPhone(Long phone) {
        this.phone = phone;
        return this;
    }

}
