package com.management.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.management.entity.Student;
import com.management.repository.StudentRepository;
import com.management.service.StudentService;

@Service
public class StudentImpl implements StudentService{
private StudentRepository stundentrepository;

	public StudentImpl(StudentRepository stundentrepository) {
	super();
	this.stundentrepository = stundentrepository;
}

	@Override
	public List<Student> getAllStudents() {
		List<Student> studentList = stundentrepository.findAll();
		  System.out.println("Number of students fetched from database: " + studentList.size()); 
		System.out.println("studentList"+studentList);
		return studentList;
	}

	@Override
	public Student saveStudent(Student student) {
		return stundentrepository.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		
		return stundentrepository.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		
		return stundentrepository.save(student);
	}

}
