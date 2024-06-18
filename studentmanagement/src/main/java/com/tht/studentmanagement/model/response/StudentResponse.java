package com.tht.studentmanagement.model.response;

import com.tht.studentmanagement.model.Student;

import java.util.UUID;

public class StudentResponse {
  private UUID id;
  private String name;
  private String email;
  private String dataOfBirth;

  public StudentResponse(Student student) {
    setId(student.getId());
    setName(student.getName());
    setEmail(student.getEmail());
    setDataOfBirth(student.getDataOfBirth().toString());
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

  public String getDataOfBirth() {
    return dataOfBirth;
  }

  public void setDataOfBirth(String dataOfBirth) {
    this.dataOfBirth = dataOfBirth;
  }
}
