package com.tht.studentmanagement.controller;

import com.tht.studentmanagement.model.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Base64;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

  @PostMapping("/auth/login")
  public boolean login(@RequestBody User user) {
    return
      user.getUsername().equals("admin") && user.getPassword().equals("admin");
  }

  @GetMapping("/auth/user")
  public Principal user(HttpServletRequest request) {
    String authToken = request.getHeader("Authorization")
      .substring("Basic".length()).trim();
    return () ->  new String(Base64.getDecoder()
      .decode(authToken)).split(":")[0];
  }
}