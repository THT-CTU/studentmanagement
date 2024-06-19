package com.tht.studentmanagement.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tht.studentmanagement.exception.StudentManagementException;
import com.tht.studentmanagement.model.response.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ResponseUtil {
  private ResponseUtil() {
  }

  public static ResponseEntity<String> buildCustomErrorResponse(int code, String message) {
    ResponseBody responseBody = new ResponseBody(message, Timestamp.valueOf(LocalDateTime.now()).getTime());
    return ResponseEntity.status(HttpStatus.valueOf(code)).body(convertObjectToJsonString(responseBody));
  }

  public static String convertObjectToJsonString(Object object) {
    ObjectMapper mapper = new ObjectMapper();
    try {
      return mapper.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      throw  new StudentManagementException(e.getMessage());
    }
  }
}
