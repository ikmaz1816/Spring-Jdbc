package com.springjdbc.JdbcAnnotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
public class Main {
	public static void main(String[] args) {
		AbstractApplicationContext context=new AnnotationConfigApplicationContext(JdbcConfig.class);
		
		StudentService service=(StudentService)context.getBean("studentService");
		Student s=new Student(5,"xyz","41042");
		service.addStudent(s);
		
		s=new Student(10,"ytr","41142");
		service.updateStudent(5, s);
		
		
		int id=10;
		service.deleteStudent(id);
		
		service.getStudent(1);
		
		service.getAllStudents();
		context.close();
	}
}
