package com.example.peerexchange.Dtos;


// deze klasse wordt gebruikt voor de Get methodes.

public class AssignmentDto {
    private Long id;
    private String title;
    private String description;
    private Long class_id; // foreign key to classes.id




    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public Long getClass_id() {return class_id;}

    public void setClass_id(Long class_id) {this.class_id = class_id;}
}
