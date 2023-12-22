package com.management.controller;

import org.springframework.stereotype.Controller;

import com.management.service.StudentService;

@Controller
public class StudentController {
private StudentService studentservice;

public StudentController(StudentService studentservice) {
	super();
	this.studentservice = studentservice;
}
//Handler method to handle list students and return model and view
}
