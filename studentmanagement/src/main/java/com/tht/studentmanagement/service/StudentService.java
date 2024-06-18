package com.tht.studentmanagement.service;

import com.tht.studentmanagement.model.request.StudentRequest;
import com.tht.studentmanagement.model.response.StudentResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentService {
  List<StudentResponse> getAllStudents();

  Optional<StudentResponse> getStudentById(UUID id);

  StudentResponse createStudent(StudentRequest student);

  StudentResponse updateStudent(UUID id, StudentRequest student);

  void deleteStudent(UUID id);
}
