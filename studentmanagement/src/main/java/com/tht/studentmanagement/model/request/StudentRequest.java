package com.tht.studentmanagement.model.request;

import com.tht.studentmanagement.model.Student;
import lombok.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
  private String name;
  private String email;
  private String dateOfBirth;

  public Student toStudent() {
    Student student = new Student();
    student.setName(name);
    student.setEmail(email);
    student.setDateOfBirth(convertDateTime(dateOfBirth));
    return student;
  }
  public Student toStudent(Student student) {
    student.setName(name);
    student.setEmail(email);
    student.setDateOfBirth(convertDateTime(dateOfBirth));
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
}
