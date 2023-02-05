package com.example.peerexchange.Dtos.Input;

import com.example.peerexchange.Models.Assignment;
import com.example.peerexchange.Models.User;
import com.sun.istack.NotNull;

import java.util.List;

// deze klasse wordt gebruikt voor de Post en Put methodes.
public class ClassDtoInput {

    private Long id;
    @NotNull
    private String name;

    private User teacher;

    private List<User> students;

    private List<Assignment> assignments;


    // getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public List<User> getStudents() {
        return students;
    }

    public void setStudents(List<User> students) {
        this.students = students;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }
}


