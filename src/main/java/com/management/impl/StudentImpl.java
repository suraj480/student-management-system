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
		return stundentrepository.findAll();
	}

}
