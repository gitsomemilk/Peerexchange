package com.example.peerexchange.Dtos;

import java.util.Date;

// deze klasse wordt gebruikt voor de Get methodes.
public class ReviewDto {
    private Long id;
    private Long student_id; // foreign key to students.id
    private Long submission_id; //foreign key to submissions.id
    private Long score;
    private String feedback;
    private Date timestamp;

    // getters and settters


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

    public Long getSubmission_id() {
        return submission_id;
    }

    public void setSubmission_id(Long submission_id) {
        this.submission_id = submission_id;
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
