package com.springjdbc.Jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class StudentImpl {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean addStudent(Student s)
	{
		String q="insert into students values(?,?,?)";
		int count=this.jdbcTemplate.update(q,s.getStudentId(),s.getStudentAddress(),s.getStudentName());
		if(count>0)
			return true;
		return false;
	}
	public boolean updateStudent(int id,Student s)
	{
		String q="update students s set s.studentid=?,s.studentname=?,s.studentaddress=? where s.studentid=?";
		int count=this.jdbcTemplate.update(q,s.getStudentId(),s.getStudentName(),s.getStudentAddress(),id);
		if(count>0)
			return true;
		return false;
	}
	public boolean deleteStudent(int id)
	{
		String q="delete from students where studentid=?";
		int count=this.jdbcTemplate.update(q,id);
		if(count>0)
			return true;
		return false;
	}
	
	public Student getStudent(int id)
	{
		String q="select * from students where studentid=?";
		Student s= this.jdbcTemplate.queryForObject(q,new RowMapperImplementation(),id);
		return s;
	}
	public List<Student> getAllStudents() {
		String q="select * from students";
		List<Student> s= this.jdbcTemplate.query(q,new RowMapperImplementation());
		return s;
	}
	
}
