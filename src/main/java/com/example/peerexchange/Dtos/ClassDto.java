package com.example.peerexchange.Dtos;

import com.example.peerexchange.Models.Assignment;
import com.example.peerexchange.Models.Student;
import com.example.peerexchange.Models.Teacher;

import java.util.List;

// deze klasse wordt gebruikt voor de Get methodes.
public class ClassDto {

    private Long id;
    private String name;

    private Teacher teacher;

    private List<Student> students;

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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }
}



