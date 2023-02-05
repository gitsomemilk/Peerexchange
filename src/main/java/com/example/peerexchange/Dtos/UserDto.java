package com.example.peerexchange.Dtos;

import com.example.peerexchange.Models.Authority;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


import java.util.Set;

public class UserDto {

    public String username;
    public String password;
    public Boolean teacher;
    public String apikey;
    public String email;

    private String firstname;

    private String lastname;

    @JsonSerialize
    public Set<Authority> authorities;


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    public String getApikey() {
        return apikey;
    }

    public String getEmail() {
        return email;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getTeacher() {
        return teacher;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setTeacher(Boolean teacher) {
        this.teacher = teacher;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }
}