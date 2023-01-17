package com.example.peerexchange.Dtos;

import com.example.peerexchange.Models.Student;
import com.example.peerexchange.Models.Submission;

import java.util.Date;

// deze klasse wordt gebruikt voor de Get methodes.
public class ReviewDto {
    private Long id;
    private Long score;
    private String feedback;
    private Date timestamp;
    private Submission submission;
    private Student student;

    // getters and settters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Submission getSubmission() {
        return submission;
    }

    public void setSubmission(Submission submission) {
        this.submission = submission;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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
