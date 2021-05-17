package com.cg.fleetmanagement.customermodule.exception;

import java.util.Date;

public class ObjectMissingException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private Date timestamp;
	private String message;

	public ObjectMissingException() {
		// TODO Auto-generated constructor stub
	}

	public ObjectMissingException(String message) {
		super(message);
	}

	@Override
	public String toString() {
		return "ObjectNotFoundException [timestamp=" + timestamp + ", message=" + message + "]";
	}
}