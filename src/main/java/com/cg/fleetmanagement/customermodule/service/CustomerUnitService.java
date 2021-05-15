package com.cg.fleetmanagement.customermodule.service;

import java.util.List;

import com.cg.fleetmanagement.customermodule.model.CustomerUnit;

public interface CustomerUnitService {

	public List<CustomerUnit> viewAllCustomers();

	public CustomerUnit viewCustomer(int customerId);

	public CustomerUnit addCustomer(CustomerUnit addcustomer);

	public CustomerUnit updateCustomer(int customerid,CustomerUnit updatecustomer);

	public void deleteCustomer(int customerid);

	// public CustomerUnit validateCustomer(String userName, String password);

}
