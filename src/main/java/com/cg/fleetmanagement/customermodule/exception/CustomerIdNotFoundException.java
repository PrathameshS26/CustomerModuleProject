package com.cg.fleetmanagement.customermodule.exception;

public class CustomerIdNotFoundException extends RuntimeException {
	private String customer; 
	public CustomerIdNotFoundException() {}
	
	public CustomerIdNotFoundException(String customer)
	{
		super(customer);
		this.customer=customer;
	}


}
