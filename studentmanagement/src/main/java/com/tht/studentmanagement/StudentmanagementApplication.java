package com.tht.studentmanagement;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Student management API", version = "1.0", description = "Student Management"))
public class StudentmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentmanagementApplication.class, args);
	}

}
