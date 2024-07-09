package com.tht.studentmanagement.model.request;

import com.tht.studentmanagement.model.Student;
import lombok.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
  private String name;
  private String email;
  private String dateOfBirth;

  public Student toStudent() {
    Student student = new Student();
    student.setName(getName());
    student.setEmail(getEmail());
    student.setDateOfBirth(convertDateTime(getDateOfBirth()));
    return student;
  }
  public Student toStudent(Student student) {
    student.setName(getName());
    student.setEmail(getEmail());
    student.setDateOfBirth(convertDateTime(getDateOfBirth()));
    return student;
  }

  private Timestamp convertDateTime(String dateString) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    Date parsedDate = null;
    try {
      parsedDate = dateFormat.parse(dateString);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    Timestamp timestamp = new Timestamp(parsedDate.getTime());
    return timestamp;
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
