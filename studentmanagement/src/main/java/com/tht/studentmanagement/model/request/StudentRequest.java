package com.tht.studentmanagement.model.request;

import com.tht.studentmanagement.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {
  private String username;
  private String userEmail;
  private Timestamp dataOfBirth;

  public Student toStudent() {
    Student student = new Student();
    student.setName(username);
    student.setEmail(userEmail);
    student.setDataOfBirth(dataOfBirth);
    return student;
  }
  public Student toStudent(Student student) {
    student.setName(username);
    student.setEmail(userEmail);
    student.setDataOfBirth(dataOfBirth);
    return student;
  }

}
