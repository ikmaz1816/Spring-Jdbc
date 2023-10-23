package com.springjdbc.Jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentService {
	
	@Autowired
	private StudentImpl impl;
	
	public void addStudent(Student s)
	{
		if(impl.addStudent(s))
			System.out.println("Student Added Successfully");
		else
			System.out.println("Some Internal Error");
	}
	
	public void updateStudent(int id,Student s)
	{
		if(impl.updateStudent(id, s))
			System.out.println("Student Data Updated");
		else
			System.out.println("Student Data Not Updated Due to Some internal error or wrong id");
	}
	public void deleteStudent(int id)
	{
		if(impl.deleteStudent(id))
			System.out.println("Data deleted");
		else
			System.out.println("Student Data Not deleted Due to Some internal error or wrong id");
	}
	public void getStudent(int id)
	{
		Student s=impl.getStudent(id);
		System.out.println(s);
	}

	public void getAllStudents() {
		List<Student> students=impl.getAllStudents();
		for(Student s:students)
		{
			System.out.println(s);
		}
	}
}
