package com.springboot.thymeleaf.studentmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.management")
@ComponentScan(basePackages = {"com.management.controllers","com.management.entity","com.management.repository","com.management.service","com.management.impl"})
@EnableJpaRepositories(basePackages = {"com.management.controllers","com.management.entity","com.management.repository","com.management.service","com.management.impl"})
public class StudentManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

}
