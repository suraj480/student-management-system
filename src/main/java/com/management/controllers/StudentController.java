package com.management.controllers;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping("/")
    public String welcomePage(Model model) {
        try {
        	return "welcomePage";
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
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id,Model model) {
    	model.addAttribute("student",studentService.getStudentById(id));
    	return "editStudent";
    }
    
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,
    		@ModelAttribute("student") Student student,
    		Model model) {
    	//Get student from database by id
    	Student existingStudent =studentService.getStudentById(id);
    	existingStudent.setId(id);
    	existingStudent.setFirstName(student.getFirstName());
    	existingStudent.setLastName(student.getLastName());
    	existingStudent.setEmail(student.getEmail());
    	studentService.updateStudent(existingStudent);
    	return "redirect:/students";
    }
    
}
