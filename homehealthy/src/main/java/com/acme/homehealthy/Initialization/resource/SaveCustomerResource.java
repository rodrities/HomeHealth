<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/homehealthy/resource/SaveEmployeeResource.java
package com.acme.homehealthy.resource;

import com.sun.istack.NotNull;

import java.util.Date;

public class SaveEmployeeResource {
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String name;
    @NotNull
    private String lastname;
    private Date birthday;
    @NotNull
    private String email;
    private Long phone;

    private String address;
    private Boolean active;

    public String getUsername() {
        return username;
    }

    public SaveEmployeeResource setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SaveEmployeeResource setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public SaveEmployeeResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public SaveEmployeeResource setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public SaveEmployeeResource setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SaveEmployeeResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public Long getPhone() {
        return phone;
    }

    public SaveEmployeeResource setPhone(Long phone) {
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public SaveEmployeeResource setAddress(String address) {
        this.address = address;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public SaveEmployeeResource setActive(Boolean active) {
        this.active = active;
        return this;
    }
}
=======
package com.acme.blogging.Initialization.resource;

import com.sun.istack.NotNull;

import javax.validation.constraints.Size;

public class SaveCustomerResource {

    @NotNull
    @Size(max = 20)
    private String username;
    @NotNull
    @Size(max = 20)
    private String password;
    @NotNull
    @Size(max = 20)
    private String name;
    @NotNull
    @Size(max = 20)
    private String lastname;
    @NotNull
    @Size(max = 50)
    private String email;
    @NotNull
    private Long phone;
    @NotNull
    @Size(max = 50)
    private String address;

    public String getUsername() {
        return username;
    }

    public SaveCustomerResource setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SaveCustomerResource setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public SaveCustomerResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public SaveCustomerResource setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SaveCustomerResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public Long getPhone() {
        return phone;
    }

    public SaveCustomerResource setPhone(Long phone) {
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public SaveCustomerResource setAddress(String address) {
        this.address = address;
        return this;
    }
}
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/Initialization/resource/SaveCustomerResource.java
