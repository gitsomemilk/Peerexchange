package com.example.peerexchange.Models;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Submission {
    // Harde Waardes
    @Id
    @GeneratedValue
    private Long id;
    private String file; // pull request van de student
    private Date timestamp;


    // connecties tussen de entiteiten
    @ManyToOne
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;

    @ManyToOne(cascade = CascadeType.ALL)
    private User student;


    // getters and setters


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


    public void add(Submission submission) {
    }

    public void addSubmission() {
    }


}
