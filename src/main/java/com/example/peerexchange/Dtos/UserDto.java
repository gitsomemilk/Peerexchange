package com.example.peerexchange.Dtos;

import com.example.peerexchange.Models.Role;

import java.util.Collection;

public class UserDto {

    private String username;
    private String password;
    private Collection<Role> roles;



    // getters and setters


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
