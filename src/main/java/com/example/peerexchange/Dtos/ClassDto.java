package com.example.peerexchange.Dtos;
// deze klasse wordt gebruikt voor de Get methodes.
public class ClassDto {

    private Long id;
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


