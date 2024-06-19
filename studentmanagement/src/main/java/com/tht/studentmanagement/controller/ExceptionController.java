package com.tht.studentmanagement.controller;

import com.tht.studentmanagement.exception.BadRequestException;
import com.tht.studentmanagement.exception.NotFoundException;
import com.tht.studentmanagement.exception.StudentManagementException;
import com.tht.studentmanagement.utils.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<String> badRequestExceptionHandler(BadRequestException e) {
    return ResponseUtil.buildCustomErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
  }

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<String> notFoundExceptionHandler(NotFoundException e) {
    return ResponseUtil.buildCustomErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
  }

  @ExceptionHandler({StudentManagementException.class})
  public ResponseEntity<String> studentManagementExceptionHandler(Exception e) {
    return ResponseUtil.buildCustomErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
  }
}
