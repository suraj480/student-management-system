package com.management.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        	model.addAttribute("students",studentService.getAllStudents());
        	return "students";
        } catch (Exception e) {
            // Handle the exception
            model.addAttribute("error", "An error occurred: " + e.getMessage());
            return "error";
        }
    }
}
