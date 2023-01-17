package com.example.peerexchange.Dtos.Input;

import com.example.peerexchange.Models.Student;
import com.example.peerexchange.Models.Submission;
import com.sun.istack.NotNull;


import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

// deze klasse wordt gebruikt voor de Post en Put methodes.
public class ReviewDtoInput {
    private Long id;
    @NotNull
    private Long score;
    @Size(min = 5, max = 500, message = "feedback moet minimaal 5 letters hebben, en maximaal 500 letters")
    private String feedback;
    @FutureOrPresent
    private Date timestamp;
    private Student student;
    private Submission submission;



    // getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Submission getSubmission() {
        return submission;
    }

    public void setSubmission(Submission submission) {
        this.submission = submission;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
