package com.tht.studentmanagement.controller;

import com.tht.studentmanagement.model.LoginRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Base64;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api/v1/auth")
public class UserController {

  @PostMapping("/login")
  public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest) {
    if ("admin".equals(loginRequest.getUsername()) && "password".equals(loginRequest.getPassword())) {
      return ResponseEntity.ok(loginRequest);
    } else {
      throw new RuntimeException("Invalid credentials");
    }
  }

  @GetMapping("/user")
  public Principal user(HttpServletRequest request) {
    String authToken = request.getHeader("Authorization")
      .substring("Basic".length()).trim();
    return () ->  new String(Base64.getDecoder()
      .decode(authToken)).split(":")[0];
  }
}