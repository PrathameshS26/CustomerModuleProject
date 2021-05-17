package com.cg.fleetmanagement.customermodule.exceptioncontrolleradvice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.fleetmanagement.customermodule.exception.CustomerIdNotFoundException;
import com.cg.fleetmanagement.customermodule.exception.ObjectMissingException;

@ControllerAdvice
public class ApplicationControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value= {ObjectMissingException.class}) // more exceptions
		public ResponseEntity<Object> handleObjectMissing(ObjectMissingException me, WebRequest request) {
			String errorMessageDescription = me.getLocalizedMessage();
			if(errorMessageDescription==null) errorMessageDescription= me.toString();
		
		
		Map<String, Object> errorMessage = new LinkedHashMap<>();
		errorMessage.put("error", "Wrong Customer ID");
		errorMessage.put("timestamp", LocalDateTime.now());
		errorMessage.put("details", me.getMessage());

		return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value=CustomerIdNotFoundException.class)
	public ResponseEntity<?> handleAccessoriesIdNotFoundException(CustomerIdNotFoundException ex)
	{
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		Map<String,Object> error=new LinkedHashMap<>();
		error.put("error", " Wrong customer id");
		error.put("timestamp", LocalDateTime.now());
		error.put("details", ex.getMessage());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}

}