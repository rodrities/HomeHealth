<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/blogging/resource/SaveUserResource.java
package com.acme.blogging.resource;

import com.sun.istack.NotNull;

import java.util.Date;

public class SaveUserResource {

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
=======
<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/homehealthy/resource/SaveUserResource.java
package com.acme.homehealthy.resource;

import com.sun.istack.NotNull;

import java.util.Date;

public class SaveUserResource {

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

    public SaveUserResource setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SaveUserResource setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public SaveUserResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public SaveUserResource setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public SaveUserResource setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SaveUserResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public Long getPhone() {
        return phone;
    }

    public SaveUserResource setPhone(Long phone) {
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public SaveUserResource setAddress(String address) {
        this.address = address;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public SaveUserResource setActive(Boolean active) {
        this.active = active;
        return this;
    }
}
=======
package com.acme.blogging.Initialization.resource;

import com.sun.istack.NotNull;

import javax.validation.constraints.Size;

public class SaveCollaboratorResource {
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
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/resource/SaveUserResource.java

    public String getUsername() {
        return username;
    }

<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/blogging/resource/SaveUserResource.java
    public SaveUserResource setUsername(String username) {
=======
    public SaveCollaboratorResource setUsername(String username) {
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/resource/SaveUserResource.java
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/blogging/resource/SaveUserResource.java
    public SaveUserResource setPassword(String password) {
=======
    public SaveCollaboratorResource setPassword(String password) {
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/resource/SaveUserResource.java
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/blogging/resource/SaveUserResource.java
    public SaveUserResource setName(String name) {
=======
    public SaveCollaboratorResource setName(String name) {
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/resource/SaveUserResource.java
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/blogging/resource/SaveUserResource.java
    public SaveUserResource setLastname(String lastname) {
=======
    public SaveCollaboratorResource setLastname(String lastname) {
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/resource/SaveUserResource.java
        this.lastname = lastname;
        return this;
    }

<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/blogging/resource/SaveUserResource.java
    public Date getBirthday() {
        return birthday;
    }

    public SaveUserResource setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

=======
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/resource/SaveUserResource.java
    public String getEmail() {
        return email;
    }

<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/blogging/resource/SaveUserResource.java
    public SaveUserResource setEmail(String email) {
=======
    public SaveCollaboratorResource setEmail(String email) {
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/resource/SaveUserResource.java
        this.email = email;
        return this;
    }

    public Long getPhone() {
        return phone;
    }

<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/blogging/resource/SaveUserResource.java
    public SaveUserResource setPhone(Long phone) {
=======
    public SaveCollaboratorResource setPhone(Long phone) {
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/resource/SaveUserResource.java
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return address;
    }

<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/blogging/resource/SaveUserResource.java
    public SaveUserResource setAddress(String address) {
        this.address = address;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public SaveUserResource setActive(Boolean active) {
        this.active = active;
        return this;
    }
}
=======
    public SaveCollaboratorResource setAddress(String address) {
        this.address = address;
        return this;
    }
}
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/Initialization/resource/SaveCollaboratorResource.java
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/resource/SaveUserResource.java
