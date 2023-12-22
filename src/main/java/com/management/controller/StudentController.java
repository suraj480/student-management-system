package com.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.management.service.StudentService;

@Controller
public class StudentController {
private StudentService studentService;

public StudentController(StudentService studentService) {
	super();
	this.studentService = studentService;
}
//Handler method to handle list students and return model and view
@GetMapping("/students")
public String listStudents(Model model) {
	model.addAttribute("students",studentService.getAllStudents());
	return "students";
}
}
