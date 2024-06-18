package com.tht.studentmanagement.model.response;

import com.tht.studentmanagement.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
