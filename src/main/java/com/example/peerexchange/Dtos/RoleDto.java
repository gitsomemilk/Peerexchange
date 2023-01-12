package com.example.peerexchange.Dtos;

import com.example.peerexchange.Models.User;

import java.util.Collection;

public class RoleDto {

    private String rolename;
    private Collection<User> users;

    // getters and setters

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
