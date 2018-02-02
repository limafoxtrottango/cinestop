package com.cinestop.exception;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = "com.cinestop.controller")
public class ControllerExceptions {
	
	@ExceptionHandler(SQLException.class)
	public void handleSQLException(SQLException e) {
		e.printStackTrace();
	}
	
	@ExceptionHandler(MalformedURLException.class)
	public void handleMalformedURLException(MalformedURLException e) {
		e.printStackTrace();
	}
	
	@ExceptionHandler(IOException.class)
	public void handleIOException(IOException e) {
		e.printStackTrace();
	}
	
	@ExceptionHandler(ProtocolException.class)
	public void handleProtocolException(ProtocolException e) {
		e.printStackTrace();
	}
	
}
