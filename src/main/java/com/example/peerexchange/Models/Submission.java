package com.example.peerexchange.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Submission {
    @Id
    @GeneratedValue
    private Long id;
    private Long student_id; // foreign key to students.id
    private Long assignment_id; // foreign key to assignments.id
    private String file; // pull request of te student
    private Date timestamp;


    // getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public Long getAssignment_id() {
        return assignment_id;
    }

    public void setAssignment_id(Long assignment_id) {
        this.assignment_id = assignment_id;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
