<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/homehealthy/resource/EmployeeResource.java
package com.acme.homehealthy.resource;

import java.util.Date;

public class EmployeeResource {
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

    public Long getId() {
        return id;
    }

    public EmployeeResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public EmployeeResource setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public EmployeeResource setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public EmployeeResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public EmployeeResource setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public EmployeeResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public Long getPhone() {
        return phone;
    }

    public EmployeeResource setPhone(Long phone) {
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public EmployeeResource setAddress(String address) {
        this.address = address;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public EmployeeResource setActive(Boolean active) {
        this.active = active;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public EmployeeResource setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }
}
=======
package com.acme.blogging.Initialization.resource;

public class CollaboratorResource {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String lastname;
    private String email;
    private Long phone;
    private String address;

    public Long getId() {
        return id;
    }

    public CollaboratorResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public CollaboratorResource setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public CollaboratorResource setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public CollaboratorResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public CollaboratorResource setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CollaboratorResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public Long getPhone() {
        return phone;
    }

    public CollaboratorResource setPhone(Long phone) {
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public CollaboratorResource setAddress(String address) {
        this.address = address;
        return this;
    }
}
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/Initialization/resource/CollaboratorResource.java
