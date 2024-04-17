package com.example.thecommerce.user.handler;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
	Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);
	@ExceptionHandler(SQLException.class)
	public ResponseEntity<?> handleSQLException(SQLException ex) {
		logger.error("SQLException::", ex);
		return ResponseEntity.internalServerError().build();
	}
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException ex){
		logger.error("IllegalArgumentException::", ex);
		return ResponseEntity.internalServerError().build();
	}
}
