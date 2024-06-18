package com.tht.studentmanagement.model;


import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String email;
  private String course;
}