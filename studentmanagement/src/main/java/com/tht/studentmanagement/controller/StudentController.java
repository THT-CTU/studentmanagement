package com.tht.studentmanagement.controller;

import com.tht.studentmanagement.model.request.StudentRequest;
import com.tht.studentmanagement.model.response.StudentResponse;
import com.tht.studentmanagement.service.StudentService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<StudentResponse>> getAllStudents() {
    var response = studentService.getAllStudents();
    return ResponseEntity.ok(response);
  }

  @GetMapping(value = "/students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> getStudentById(@PathVariable UUID id) {
    StudentResponse student = studentService.getStudentById(id);
    return ResponseEntity.ok(student);
  }

  @PostMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> createStudent(@RequestBody StudentRequest student) {
    var response = studentService.createStudent(student);
    return ResponseEntity.ok(response);
  }

  @PutMapping(value = "/students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> updateStudent(@PathVariable UUID id, @RequestBody StudentRequest studentDetails) {
    StudentResponse updatedStudent = studentService.updateStudent(id, studentDetails);
    return ResponseEntity.ok(updatedStudent);
  }

  @DeleteMapping(value = "/students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> deleteStudent(@PathVariable UUID id) {
    studentService.deleteStudent(id);
    return ResponseEntity.noContent().build();
  }
}