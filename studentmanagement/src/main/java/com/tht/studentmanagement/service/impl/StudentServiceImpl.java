package com.tht.studentmanagement.service.impl;

import com.tht.studentmanagement.exception.BadRequestException;
import com.tht.studentmanagement.exception.NotFoundException;
import com.tht.studentmanagement.exception.StudentManagementException;
import com.tht.studentmanagement.model.request.StudentRequest;
import com.tht.studentmanagement.model.response.StudentResponse;
import com.tht.studentmanagement.repository.StudentRepository;
import com.tht.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
  public StudentResponse getStudentById(UUID id) {
    if (Objects.isNull(id)) {
      throw new BadRequestException("Id is missing");
    }
    var student = studentRepository.findById(id)
      .orElseThrow(() -> new NotFoundException("Student not found!"));
    return new StudentResponse(student);
  }

  @Override
  public StudentResponse createStudent(StudentRequest student) {
    if (Objects.isNull(student)) {
      throw new BadRequestException("Student is missing!");
    }
    try {
      var response = studentRepository.save(student.toStudent());
      return new StudentResponse(response);
    } catch (Exception e) {
      throw new StudentManagementException(e.getMessage());
    }
  }

  @Override
  public StudentResponse updateStudent(UUID id, StudentRequest studentRequest) {
    if (Objects.isNull(id)) {
      throw new BadRequestException("Id is missing");
    }
    if (Objects.isNull(studentRequest)) {
      throw new BadRequestException("Student is missing!");
    }
    var student = studentRepository.findById(id)
      .orElseThrow(() -> new NotFoundException("Student not found!"));
    try {
      var response = studentRepository.save(studentRequest.toStudent(student));
      return new StudentResponse(response);
    } catch (Exception e) {
      throw new StudentManagementException(e.getMessage());
    }
  }

  @Override
  public void deleteStudent(UUID id) {
    studentRepository.deleteById(id);
  }
}
