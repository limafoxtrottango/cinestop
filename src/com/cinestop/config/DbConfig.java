package com.cinestop.config;

import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cinestop.dao.DBQuery;

@Configuration
public class DbConfig {
	
	@Bean
	public DBQuery getDbQueryBean() throws ClassNotFoundException, SQLException {
		return new DBQuery();
	}
	
	@ExceptionHandler(ClassNotFoundException.class)
	public void handleClassNotFoundException(ClassNotFoundException e) {
		e.printStackTrace();
	}
	
	@ExceptionHandler(SQLException.class)
	public void handleSQLException(SQLException e) {
		e.printStackTrace();
	}
}
