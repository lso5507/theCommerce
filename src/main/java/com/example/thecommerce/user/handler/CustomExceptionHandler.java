package com.example.thecommerce.user.handler;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.thecommerce.user.dto.ErrorResponse;

@RestControllerAdvice
public class CustomExceptionHandler {
	Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);
	@ExceptionHandler(SQLException.class)
	public ResponseEntity<?> handleSQLException(SQLException ex) {
		logger.error("SQLException::", ex);
		ErrorResponse errorResponse= new ErrorResponse(Collections.singletonList("SQLException"), HttpStatus.INTERNAL_SERVER_ERROR.value());
		return ResponseEntity.internalServerError().body(errorResponse);
	}
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException ex){
		logger.error("IllegalArgumentException::", ex);
		ErrorResponse errorResponse= new ErrorResponse(Collections.singletonList("IllegalArgumentException"), HttpStatus.INTERNAL_SERVER_ERROR.value());
		return ResponseEntity.internalServerError().body(errorResponse);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(IllegalArgumentException ex){
		logger.error("handleException::", ex);
		ErrorResponse errorResponse= new ErrorResponse(Collections.singletonList("handleException"), HttpStatus.INTERNAL_SERVER_ERROR.value());
		return ResponseEntity.internalServerError().body(errorResponse);
	}
}
