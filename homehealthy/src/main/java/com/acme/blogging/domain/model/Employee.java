<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/blogging/domain/model/Employee.java
package com.acme.blogging.domain.model;

=======
<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/homehealthy/domain/model/Employee.java
package com.acme.homehealthy.domain.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String lastname;

    @NotNull
    @Column(unique = true)
    private String email;

    private String address;
    private Boolean active;
    private Date birthday;

    public Long getId() {
        return id;
    }

    public Employee setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Employee setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Employee setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public Employee setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Employee setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Employee setAddress(String address) {
        this.address = address;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public Employee setActive(Boolean active) {
        this.active = active;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Employee setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }
}
=======
package com.acme.blogging.Initialization.domain.model;
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/domain/model/Employee.java

import com.sun.istack.NotNull;

import javax.persistence.*;
<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/blogging/domain/model/Employee.java
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee {
=======

@Entity
@Table(name = "collaborators")
public class Collaborator {
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/domain/model/Employee.java
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/blogging/domain/model/Employee.java
    private String name;

    @NotNull
=======
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/domain/model/Employee.java
    @Column(unique = true)
    private String username;

    @NotNull
    private String password;

    @NotNull
<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/blogging/domain/model/Employee.java
=======
    private String name;

    @NotNull
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/domain/model/Employee.java
    private String lastname;

    @NotNull
    @Column(unique = true)
    private String email;

<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/blogging/domain/model/Employee.java
    private String address;
    private Boolean active;
    private Date birthday;
=======
    private Long phone;
    private String address;

>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/domain/model/Employee.java

    public Long getId() {
        return id;
    }

<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/blogging/domain/model/Employee.java
    public Employee setId(Long id) {
=======
    public Collaborator setId(Long id) {
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/domain/model/Employee.java
        this.id = id;
        return this;
    }

<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/blogging/domain/model/Employee.java
    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

=======
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/domain/model/Employee.java
    public String getUsername() {
        return username;
    }

<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/blogging/domain/model/Employee.java
    public Employee setUsername(String username) {
=======
    public Collaborator setUsername(String username) {
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/domain/model/Employee.java
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/blogging/domain/model/Employee.java
    public Employee setPassword(String password) {
=======
    public Collaborator setPassword(String password) {
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/domain/model/Employee.java
        this.password = password;
        return this;
    }

<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/blogging/domain/model/Employee.java
=======
    public String getName() {
        return name;
    }

    public Collaborator setName(String name) {
        this.name = name;
        return this;
    }

>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/domain/model/Employee.java
    public String getLastname() {
        return lastname;
    }

<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/blogging/domain/model/Employee.java
    public Employee setLastname(String lastname) {
=======
    public Collaborator setLastname(String lastname) {
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/domain/model/Employee.java
        this.lastname = lastname;
        return this;
    }

    public String getEmail() {
        return email;
    }

<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/blogging/domain/model/Employee.java
    public Employee setEmail(String email) {
=======
    public Collaborator setEmail(String email) {
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/domain/model/Employee.java
        this.email = email;
        return this;
    }

<<<<<<< Updated upstream:homehealthy/src/main/java/com/acme/blogging/domain/model/Employee.java
    public String getAddress() {
        return address;
    }

    public Employee setAddress(String address) {
        this.address = address;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public Employee setActive(Boolean active) {
        this.active = active;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Employee setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }
}
=======
    public Long getPhone() {
        return phone;
    }

    public Collaborator setPhone(Long phone) {
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Collaborator setAddress(String address) {
        this.address = address;
        return this;
    }
}
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/Initialization/domain/model/Collaborator.java
>>>>>>> Stashed changes:homehealthy/src/main/java/com/acme/homehealthy/domain/model/Employee.java
