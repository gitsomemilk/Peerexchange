package com.example.peerexchange.Models;


import javax.persistence.*;
import java.io.File;
import java.util.Date;
import java.util.List;

@Entity
public class Assignment {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;

    private Date deadline;

    private File addon;


    // connections tussen verschillende entiteiten
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "class_assignment",
            joinColumns = @JoinColumn(name = "assignment_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "class_id", referencedColumnName = "id"))
    private List<Class> classes;

    @OneToMany(mappedBy = "assignment", cascade = CascadeType.ALL)
    private List<Submission> submissions;


    // getters and setters


    public File getAddon() {
        return addon;
    }

    public void setAddon(File addon) {
        this.addon = addon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    public List<Submission> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(List<Submission> submissions) {
        this.submissions = submissions;
    }

    public void addSubmissions(Submission submission) {
        this.submissions.add(submission);
    }

    public void addAssignment(Assignment assignment) {
    }

    public void setClass(Class class_) {
    }
}
