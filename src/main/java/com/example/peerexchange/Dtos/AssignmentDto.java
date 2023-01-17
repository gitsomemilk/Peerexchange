package com.example.peerexchange.Dtos;


// deze klasse wordt gebruikt voor de Get methodes.

import com.example.peerexchange.Models.Class;
import com.example.peerexchange.Models.Submission;

import java.util.Date;
import java.util.List;

public class AssignmentDto {
    private Long id;
    private String title;
    private String description;
    private Date deadline;
    private List<Submission> submissions;
    private List<Class> classes;




    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public List<Submission> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(List<Submission> submissions) {
        this.submissions = submissions;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }
}
