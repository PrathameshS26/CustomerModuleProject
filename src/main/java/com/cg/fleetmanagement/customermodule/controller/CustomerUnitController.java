package com.cg.fleetmanagement.customermodule.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cg.fleetmanagement.customermodule.model.City;
import com.cg.fleetmanagement.customermodule.model.Country;
import com.cg.fleetmanagement.customermodule.model.CustomerUnit;
import com.cg.fleetmanagement.customermodule.model.OrgUnit;
import com.cg.fleetmanagement.customermodule.model.PartnerOrgUnit;
import com.cg.fleetmanagement.customermodule.model.Postal;
import com.cg.fleetmanagement.customermodule.model.Region;
import com.cg.fleetmanagement.customermodule.repository.CustomerRepository;
import com.cg.fleetmanagement.customermodule.serviceimplementation.CustomerUnitImplementation;

@RestController
@RequestMapping("/customers")
public class CustomerUnitController {

	@Autowired
	private CustomerUnitImplementation customerservice;

	@GetMapping()
	public ResponseEntity<List<CustomerUnit>> getCustomers() {

		List<CustomerUnit> customerList = customerservice.viewAllCustomers();

		ResponseEntity<List<CustomerUnit>> response = new ResponseEntity<>(customerList, HttpStatus.NOT_FOUND);

		if (!customerList.isEmpty()) {
			response = new ResponseEntity<>(customerList, HttpStatus.OK);
		}

		return response;
	}


	@GetMapping("/customer/{cid}")
	public ResponseEntity<Object> getCustomer(@PathVariable("cid") int customerId) {
		CustomerUnit customer = customerservice.viewCustomer(customerId);

		if (customer == null) {
			throw new EmployeeIdNotFoundException(customerId + " CustomerId Not found ");
		}

		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	
	@PostMapping("/customer")
	

	@PutMapping("/customer/{cid}")



	@DeleteMapping("/customer/{id}")
	public ResponseEntity<Object> deletecustomer(@PathVariable("cid") int customerId) {

		customerservice.deleteCustomer(customerId);
		CustomerUnit customerList = customerservice.viewCustomer(customerId);
		ResponseEntity<Object> response = ResponseEntity.status(HttpStatus.OK)
				.body("Deleted Successfully");
		
		if (customerList!=null) {
			response = new ResponseEntity<>( HttpStatus.BAD_REQUEST);
		}

		return response;
	}
	


}
