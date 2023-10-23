package com.springjdbc.Jdbc;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("Config.xml");
		
		StudentService service=(StudentService)context.getBean("studentService");
//		Student s=new Student(4,"Moin","411042");
//		service.addStudent(s);
		
		Student s=new Student(3,"Moin","411042");
		service.updateStudent(4, s);
		
		
		int id=0;
		service.deleteStudent(id);
		
		service.getStudent(3);
		
		service.getAllStudents();
		context.close();
	}
}
