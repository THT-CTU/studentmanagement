package com.tht.studentmanagement.model.response;

import com.tht.studentmanagement.model.Student;

import java.util.UUID;

public class StudentResponse {
  private UUID id;
  private String name;
  private String email;
  private String dateOfBirth;

  public StudentResponse(Student student) {
    setId(student.getId());
    setName(student.getName());
    setEmail(student.getEmail());
    setDateOfBirth(student.getDateOfBirth().toString());
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }
}
