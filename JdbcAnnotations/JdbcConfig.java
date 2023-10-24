package com.springjdbc.JdbcAnnotations;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages="com.springjdbc.JdbcAnnotations")
public class JdbcConfig {
	
	@Bean
	public DataSource getDatasource()
	{
		DriverManagerDataSource driver=new DriverManagerDataSource();
		driver.setUrl("jdbc:mysql://localhost:3306/management");
		driver.setDriverClassName("com.mysql.jdbc.Driver");
		driver.setPassword("admin");
		driver.setUsername("root");
		
		return driver;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbc()
	{
		JdbcTemplate jdbc=new JdbcTemplate();
		jdbc.setDataSource(getDatasource());
		return jdbc;
	}
}
