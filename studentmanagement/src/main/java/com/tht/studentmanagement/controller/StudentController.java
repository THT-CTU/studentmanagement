package com.tht.studentmanagement.controller;

import com.tht.studentmanagement.model.request.StudentRequest;
import com.tht.studentmanagement.model.response.StudentResponse;
import com.tht.studentmanagement.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {
  @Autowired
  private StudentService studentService;

  @GetMapping
  public ResponseEntity<List<StudentResponse>> getAllStudents() {
    var response = studentService.getAllStudents();
    return ResponseEntity.ok(response);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getStudentById(@PathVariable UUID id) {
    StudentResponse student = studentService.getStudentById(id).orElseThrow();
    return ResponseEntity.ok(student);
  }

  @PostMapping
  public ResponseEntity<Object> createStudent(@RequestBody StudentRequest student) {
    var response = studentService.createStudent(student);
    return ResponseEntity.ok(response);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> updateStudent(@PathVariable UUID id, @RequestBody StudentRequest studentDetails) {
    StudentResponse updatedStudent = studentService.updateStudent(id, studentDetails);
    return ResponseEntity.ok(updatedStudent);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteStudent(@PathVariable UUID id) {
    studentService.deleteStudent(id);
    return ResponseEntity.noContent().build();
  }
}