package com.tht.studentmanagement.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
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
  private Timestamp dataOfBirth;
}