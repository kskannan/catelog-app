package com.cate.app.catelogapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorAdvice {
	
	@ExceptionHandler(value = {RuntimeException.class})
	public ResponseEntity<String> runtimeError(RuntimeException e) {
		return error(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
	}

	
	private ResponseEntity<String> error(HttpStatus status, String error){
		System.out.println(error);
		return ResponseEntity.status(status).body(error);
	}
}
