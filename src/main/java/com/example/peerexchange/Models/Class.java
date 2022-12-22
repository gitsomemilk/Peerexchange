package com.example.peerexchange.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Class {
 @Id
 @GeneratedValue
 private Long id;

 private String name;
 private Long teacher_id; // foreign key to teacher.id





 // getters and setters

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public Long getTeacher_id() {
  return teacher_id;
 }

 public void setTeacher_id(Long teacher_id) {
  this.teacher_id = teacher_id;
 }
}
