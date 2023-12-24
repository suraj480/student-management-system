package com.management.service;

import java.util.List;

import com.management.entity.Student;

public interface StudentService {
List <Student> getAllStudents();
Student saveStudent(Student student);
}
