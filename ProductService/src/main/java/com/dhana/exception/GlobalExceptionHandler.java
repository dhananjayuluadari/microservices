package com.dhana.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dhana.model.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ProductServiceException.class)
	public ResponseEntity<ErrorResponse> handleProductServiceException(ProductServiceException exception){
		ErrorResponse errorResponse = ErrorResponse.builder()
				                      .message(exception.getMessage())
				                      .errorCode(exception.getErrorCode())
				                      .build();
		
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
	}
}
