package com.tht.studentmanagement.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;

import java.io.Serializable;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Table(name = "student")
public class Student implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", nullable = false, updatable = false)
  @JdbcTypeCode(Types.VARCHAR)
  private UUID id;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @Column(name = "data_of_birth")
  private Timestamp dateOfBirth;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Timestamp getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Timestamp dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }
}