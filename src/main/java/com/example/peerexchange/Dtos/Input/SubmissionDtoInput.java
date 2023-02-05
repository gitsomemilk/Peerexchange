package com.example.peerexchange.Dtos.Input;

import com.example.peerexchange.Models.Assignment;
import com.example.peerexchange.Models.User;

import java.util.Date;
import java.util.List;

// deze klasse wordt gebruikt voor de Post en Put methodes.
public class SubmissionDtoInput {
    private Long id;
    private String file;
    private Date timestamp;
    private Assignment assignment;
    private User student;


    // getters and setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
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
