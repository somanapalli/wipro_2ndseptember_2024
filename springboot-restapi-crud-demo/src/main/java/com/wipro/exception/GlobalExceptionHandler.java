package com.wipro.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(EmployeeNotFoundException ex,WebRequest request)
	{
		ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex, WebRequest request)
	{
		Map<String,String> errors = new HashMap<>();
//		// void accept(T t);
//		ex.getBindingResult().getAllErrors().forEach((error) -> {
//			
//			String fieldName = ((FieldError)error).getField();
//			String errorMessage = error.getDefaultMessage();
//		});
		for(FieldError error: ex.getBindingResult().getFieldErrors())
		{
			errors.put(error.getField(), error.getDefaultMessage());
		}
		
		
		ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "validation error", errors.toString(), request.getDescription(false));
	 return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);	
	}

}
