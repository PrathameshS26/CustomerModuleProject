package com.cg.fleetmanagement.customermodule.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.cg.fleetmanagement.customermodule.exception.CustomerIdNotFoundException;
import com.cg.fleetmanagement.customermodule.exception.ObjectMissingException;
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
	
	Logger logger = LoggerFactory.getLogger(CustomerUnitController.class);


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
		//customer == null
		if (customer == null) {
			throw new ObjectMissingException("CustomerId Not found ");
		}

		return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
	}

	
	@PostMapping("/customer")
	public ResponseEntity<Object> addCustomers(@RequestBody CustomerUnit customers) {
		CustomerUnit newCustomers = customerservice.addCustomer(customers);
		if (newCustomers == null)
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newCustomers.getCustomerId()).toUri();
		return ResponseEntity.created(location).build();
	}

	

	@PutMapping("/customer/{cid}")
	public ResponseEntity<CustomerUnit> updateCustomer(@PathVariable("cid") int id, @RequestBody CustomerUnit customer) {
	    CustomerUnit cus = customerservice.updateCustomer(id,customer);
	    return new ResponseEntity<>(cus, HttpStatus.OK);
	  }
	
	@PatchMapping("/partnerOrgUnit/{cid}")
	public ResponseEntity<CustomerUnit> updatePartnerOrg(@PathVariable("cid") int id, @RequestBody PartnerOrgUnit partialUpdate) {
	    CustomerUnit cus = customerservice.updatePartnerOrg(id,partialUpdate);
	    return new ResponseEntity<>(cus, HttpStatus.OK);
	  }
	
	@PatchMapping("/orgUnit/{cid}")
	public ResponseEntity<CustomerUnit> updateOrg(@PathVariable("cid") int id, @RequestBody OrgUnit partialUpdate) {
	    CustomerUnit cus = customerservice.updateOrgUnit(id,partialUpdate);
	    return new ResponseEntity<>(cus, HttpStatus.OK);
	  }
	
	@PatchMapping("/postal/{cid}")
	public ResponseEntity<CustomerUnit> updatePostal(@PathVariable("cid") int id, @RequestBody Postal partialUpdate) {
	    CustomerUnit cus = customerservice.updatePostaldetails(id,partialUpdate);
	    return new ResponseEntity<>(cus, HttpStatus.OK);
	  }
	
	@PatchMapping("/city/{cid}")
	public ResponseEntity<CustomerUnit> updateCity(@PathVariable("cid") int id, @RequestBody City partialUpdate) {
	    CustomerUnit cus = customerservice.updateCitydetails(id,partialUpdate);
	    return new ResponseEntity<>(cus, HttpStatus.OK);
	  }
	
	@PatchMapping("/region/{cid}")
	public ResponseEntity<CustomerUnit> updateRegion(@PathVariable("cid") int id, @RequestBody Region partialUpdate) {
	    CustomerUnit cus = customerservice.updateRegiondetails(id,partialUpdate);
	    return new ResponseEntity<>(cus, HttpStatus.OK);
	  }
	
	@PatchMapping("/country/{cid}")
	public ResponseEntity<CustomerUnit> updateCountry(@PathVariable("cid") int id, @RequestBody Country partialUpdate) {
	    CustomerUnit cus = customerservice.updateCountrydetails(id,partialUpdate);
	    return new ResponseEntity<>(cus, HttpStatus.OK);
	  }


	@DeleteMapping("/customer/{cid}")
	public ResponseEntity<Object> deleteCustomers(@PathVariable("cid")int customerid)
	{
		CustomerUnit customerPresent=customerservice.viewCustomer(customerid);
		if(customerPresent==null)
		{
			throw new CustomerIdNotFoundException("CustomerId "+customerid+" not found");
		}
		customerservice.deleteCustomer(customerid);
		return  ResponseEntity.status(HttpStatus.OK).body("Customer "+customerid+" deleted");
	}
	


}
