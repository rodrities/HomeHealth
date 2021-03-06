<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/blogging/domain/model/User.java
package com.acme.blogging.domain.model;
=======
<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/homehealthy/domain/model/User.java
package com.acme.homehealthy.domain.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class User extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String name;

    @NotNull
    private String lastname;

    @NotNull
    @Column(unique = true)
    private String email;

    private Long phone;

    private String address;
    private Boolean active;
    private Date birthday;

    public String getAddress() {
        return address;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public User setActive(Boolean active) {
        this.active = active;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public User setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public User setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }


    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public Long getPhone() {
        return phone;
    }

    public User setPhone(Long phone) {
        this.phone = phone;
        return this;
    }


}
=======
package com.acme.blogging.Initialization.domain.model;
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/domain/model/User.java

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/blogging/domain/model/User.java
@Table(name = "users")
public class User extends AuditModel {

=======
@Table(name = "customers")
public class Customer {
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/domain/model/User.java
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String name;

    @NotNull
    private String lastname;

    @NotNull
    @Column(unique = true)
    private String email;

    private Long phone;

    private String address;
    private Boolean active;
    private Date birthday;

    public String getAddress() {
        return address;
    }

<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/blogging/domain/model/User.java
    public User setAddress(String address) {
=======
    public Customer setAddress(String address) {
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/domain/model/User.java
        this.address = address;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/blogging/domain/model/User.java
    public User setActive(Boolean active) {
=======
    public Customer setActive(Boolean active) {
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/domain/model/User.java
        this.active = active;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/blogging/domain/model/User.java
    public User setBirthday(Date birthday) {
=======
    public Customer setBirthday(Date birthday) {
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/domain/model/User.java
        this.birthday = birthday;
        return this;
    }

    public Long getId() {
        return id;
    }

<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/blogging/domain/model/User.java
    public User setId(Long id) {
=======
    public Customer setId(Long id) {
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/domain/model/User.java
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/blogging/domain/model/User.java
    public User setUsername(String username) {
=======
    public Customer setUsername(String username) {
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/domain/model/User.java
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/blogging/domain/model/User.java
    public User setPassword(String password) {
=======
    public Customer setPassword(String password) {
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/domain/model/User.java
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/blogging/domain/model/User.java
    public User setName(String name) {
=======
    public Customer setName(String name) {
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/domain/model/User.java
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/blogging/domain/model/User.java
    public User setLastname(String lastname) {
=======
    public Customer setLastname(String lastname) {
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/domain/model/User.java
        this.lastname = lastname;
        return this;
    }

<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/blogging/domain/model/User.java

=======
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/domain/model/User.java
    public String getEmail() {
        return email;
    }

<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/blogging/domain/model/User.java
    public User setEmail(String email) {
=======
    public Customer setEmail(String email) {
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/domain/model/User.java
        this.email = email;
        return this;
    }

    public Long getPhone() {
        return phone;
    }

<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/blogging/domain/model/User.java
    public User setPhone(Long phone) {
        this.phone = phone;
        return this;
    }


}
=======
    public Customer setPhone(Long phone) {
        this.phone = phone;
        return this;
    }
}
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/Initialization/domain/model/Customer.java
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/domain/model/User.java
