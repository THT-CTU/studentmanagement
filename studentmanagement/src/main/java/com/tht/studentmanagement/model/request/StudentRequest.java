package com.tht.studentmanagement.model.request;

import com.tht.studentmanagement.model.Student;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentRequest {
  private String username;
  private String userEmail;
  private String dataOfBirth;

  public StudentRequest(String username, String userEmail, String dataOfBirth) {
    this.username = username;
    this.userEmail = userEmail;
    this.dataOfBirth = dataOfBirth;
  }

  public Student toStudent() {
    Student student = new Student();
    student.setName(username);
    student.setEmail(userEmail);
    student.setDataOfBirth(convertDateTime(dataOfBirth));
    return student;
  }
  public Student toStudent(Student student) {
    student.setName(username);
    student.setEmail(userEmail);
    student.setDataOfBirth(convertDateTime(dataOfBirth));
    return student;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public String getDataOfBirth() {
    return dataOfBirth;
  }

  public void setDataOfBirth(String dataOfBirth) {
    this.dataOfBirth = dataOfBirth;
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
}
