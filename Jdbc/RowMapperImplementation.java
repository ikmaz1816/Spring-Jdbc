package com.springjdbc.Jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RowMapperImplementation implements RowMapper<Student>{
	@Override
	public Student mapRow(ResultSet set,int rs) throws SQLException
	{
		Student s=new Student(set.getInt(1),set.getString(3),set.getString(2));
		return s;
	}

	
}
