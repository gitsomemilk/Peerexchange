package com.example.peerexchange.Dtos.Input;

import com.sun.istack.NotNull;
import org.hibernate.annotations.BatchSize;

// deze klasse wordt gebruikt voor de Post en Put methodes.
public class AssignmentDtoInput {

    private Long id;

    @NotNull
    private String title;
    @NotNull
    private String description;
    private Long class_id; // foreign key to classes.id



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

    public Long getClass_id() {
        return class_id;
    }

    public void setClass_id(Long class_id) {
        this.class_id = class_id;
    }
}
