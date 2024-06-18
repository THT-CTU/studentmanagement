package com.tht.studentmanagement.service.impl;

import com.tht.studentmanagement.model.request.StudentRequest;
import com.tht.studentmanagement.model.response.StudentResponse;
import com.tht.studentmanagement.repository.StudentRepository;
import com.tht.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  private StudentRepository studentRepository;

  @Override
  public List<StudentResponse> getAllStudents() {
    var students = studentRepository.findAll();
    return students
      .stream()
      .map(item ->
        new StudentResponse(item)).toList();
  }

  @Override
  public Optional<StudentResponse> getStudentById(UUID id) {
    var student = studentRepository.findById(id);
    StudentResponse studentResponse = new StudentResponse(student.get());
    return Optional.of(studentResponse);
  }

  @Override
  public StudentResponse createStudent(StudentRequest student) {
    var response = studentRepository.save(student.toStudent());
    return new StudentResponse(response);
  }

  @Override
  public StudentResponse updateStudent(UUID id, StudentRequest studentRequest) {
    var student = studentRepository.findById(id);
    var response = studentRepository.save(studentRequest.toStudent(student.get()));
    return new StudentResponse(response);
  }

  @Override
  public void deleteStudent(UUID id) {
    studentRepository.deleteById(id);
  }
}
