package com.cg.fleetmanagement.customermodule.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public List<CustomerUnit> getCustomers() {
		return customerservice.viewAllCustomers();

	}

	@GetMapping("/customer/{cid}")
	public Optional<CustomerUnit> getCustomerById(@PathVariable("cid") int customerid) {
		Optional<CustomerUnit> cusbyid = Optional.ofNullable(customerservice.viewCustomer(customerid));
		return cusbyid;
	}

	@PostMapping("/customer")
	public CustomerUnit addCustomer(@RequestBody CustomerUnit cunit) {
		return customerservice.addCustomer(cunit);

	}

	@PutMapping("/customer/{cid}")
	public CustomerUnit updateCustomerById(@PathVariable("cid") int customerid, @RequestBody CustomerUnit cunit) {
		return customerservice.updateCustomer(customerid, cunit);

	}

	@DeleteMapping("/customer/{id}")
	public void deleteCustomerById(@PathVariable("id") int customerid) {
		customerservice.deleteCustomer(customerid);

	}

//	@PatchMapping("/orgunit/{id}")
//	public CustomerUnit orgunitUpdate(@RequestBody OrgUnit partialUpdate, @PathVariable("id") int id) {
//		Optional<CustomerUnit> optional = customerrepository.findById(id);
//		CustomerUnit cusbyid = optional.get();
//		cusbyid.getPartnerOrgUnit().getOrgunit().setOrgId(partialUpdate.getOrgId());
//		cusbyid.getPartnerOrgUnit().getOrgunit().setOrgName(partialUpdate.getOrgName());
//		cusbyid.getPartnerOrgUnit().getOrgunit().setFaxNumber(partialUpdate.getFaxNumber());
//		cusbyid.getPartnerOrgUnit().getOrgunit().setPhoneNumber(partialUpdate.getPhoneNumber());
//
//		customerrepository.save(cusbyid);
//		return cusbyid;
//
//	}
//
//	@PatchMapping("/partnerorgunit/{id}")
//	public CustomerUnit orgunitUpdate(@RequestBody PartnerOrgUnit partialUpdate, @PathVariable("id") int id) {
//		Optional<CustomerUnit> optional = customerrepository.findById(id);
//		CustomerUnit cusbyid = optional.get();
//		cusbyid.getPartnerOrgUnit().setPartnerOrgId(partialUpdate.getPartnerOrgId());
//		cusbyid.getPartnerOrgUnit().setResellerEnabled(partialUpdate.isResellerEnabled());
//		cusbyid.getPartnerOrgUnit().setOnCreditHold(partialUpdate.isOnCreditHold());
//		cusbyid.getPartnerOrgUnit().setSponsorPartnerBusinessManager(partialUpdate.getSponsorPartnerBusinessManager());
//
//		customerrepository.save(cusbyid);
//		return cusbyid;
//
//	}
//
//	@PatchMapping("/postal/{id}")
//	public CustomerUnit postalUpdate(@RequestBody Postal partialUpdate, @PathVariable("id") int id) {
//		Optional<CustomerUnit> optional = customerrepository.findById(id);
//		CustomerUnit cusbyid = optional.get();
//		cusbyid.getPostal().setPostalCodeId(partialUpdate.getPostalCodeId());
//		cusbyid.getPostal().setPostalCodeValue(partialUpdate.getPostalCodeValue());
//
//		customerrepository.save(cusbyid);
//		return cusbyid;
//	}
//
//	@PatchMapping("/city/{id}")
//	public CustomerUnit cityUpdate(@RequestBody City partialUpdate, @PathVariable("id") int id) {
//		Optional<CustomerUnit> optional = customerrepository.findById(id);
//		CustomerUnit cusbyid = optional.get();
//		cusbyid.getPostal().getCity().setCitycommlang(partialUpdate.getCitycommlang());
//		cusbyid.getPostal().getCity().setCityid(partialUpdate.getCityid());
//		cusbyid.getPostal().getCity().setCityname(partialUpdate.getCityname());
//
//		customerrepository.save(cusbyid);
//		return cusbyid;
//	}
//
//	@PatchMapping("/region/{id}")
//	public CustomerUnit regionUpdate(@RequestBody Region partialUpdate, @PathVariable("id") int id) {
//		Optional<CustomerUnit> optional = customerrepository.findById(id);
//		CustomerUnit cusbyid = optional.get();
//		cusbyid.getPostal().getCity().getRegionId().setRegionid(partialUpdate.getRegionid());
//		cusbyid.getPostal().getCity().getRegionId().setRegionname(partialUpdate.getRegionname());
//		customerrepository.save(cusbyid);
//		return cusbyid;
//	}
//
//	@PatchMapping("/country/{id}")
//	public CustomerUnit CityUpdate(@RequestBody Country partialUpdate, @PathVariable("id") int id) {
//		Optional<CustomerUnit> optional = customerrepository.findById(id);
//		CustomerUnit cusbyid = optional.get();
//		cusbyid.getPostal().getCity().getRegionId().getCountry().setCountryname(partialUpdate.getCountryname());
//		cusbyid.getPostal().getCity().getRegionId().getCountry().setCountryid(partialUpdate.getCountryid());
//		customerrepository.save(cusbyid);
//		return cusbyid;
//	}

}
