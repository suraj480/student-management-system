package com.management.controllers;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.management.entity.Student;
import com.management.service.StudentService;

@Controller
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String listStudents(Model model) {
        try {
        	List <Student> stundetsList=studentService.getAllStudents();
        	model.addAttribute("students",stundetsList);
        	return "students";
        } catch (Exception e) {
            // Handle the exception
            model.addAttribute("error", "An error occurred: " + e.getMessage());
            return "error";
        }
    }
    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
    Student student =new Student();
    model.addAttribute("student",student);
    return "createStundent";
    }
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
    	studentService.saveStudent(student);
    	return "redirect:/students";
    	
    }
    
}
