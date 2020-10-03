package com.acme.blogging.resource;

import com.sun.istack.NotNull;

import javax.validation.constraints.Size;

public class SaveRoleResource {

    @NotNull
    @Size(max = 20)
    public String name;

    public String getName() {
        return name;
    }

    public SaveRoleResource setName(String name) {
        this.name = name;
        return this;
    }
}
