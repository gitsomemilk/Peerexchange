package com.example.peerexchange.Dtos;

import com.example.peerexchange.Models.Class;

import java.util.List;

// deze klasse wordt gebruikt voor de Get methodes.
public class TeacherDto {

    private Long id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;

    private List<Class> class_id;




    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Class> getClass_id() {
        return class_id;
    }

    public void setClass_id(List<Class> class_id) {
        this.class_id = class_id;
    }
}

