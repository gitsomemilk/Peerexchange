package com.example.peerexchange.Dtos.Input;

import com.sun.istack.NotNull;

// deze klasse wordt gebruikt voor de Post en Put methodes.
public class ClassDtoInput {

    private Long id;
    @NotNull
    private String name;
    private Long teacher_id; // foreign key to teacher.id


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

    public Long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Long teacher_id) {
        this.teacher_id = teacher_id;
    }
}

