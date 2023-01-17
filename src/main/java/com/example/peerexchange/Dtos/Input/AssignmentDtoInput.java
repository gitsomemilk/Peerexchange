package com.example.peerexchange.Dtos.Input;

import com.example.peerexchange.Models.Class;
import com.example.peerexchange.Models.Submission;
import com.sun.istack.NotNull;


import java.util.Date;
import java.util.List;

// deze klasse wordt gebruikt voor de Post en Put methodes.
public class AssignmentDtoInput {

    private Long id;

    @NotNull
    private String title;
    @NotNull
    private String description;
    private Date deadline;

    private List<Class> classes;





    // getters and setters

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
}
