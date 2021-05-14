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

@RestController
@RequestMapping("/customers")
public class CustomerUnitController {

	@Autowired
	private CustomerRepository customerrepository;

	@GetMapping()
	public List<CustomerUnit> getCustomers() {
		List<CustomerUnit> customerslist = customerrepository.findAll();
		return customerslist;
	}

	@GetMapping("/customer/{cid}")
	public Optional<CustomerUnit> getCustomerById(@PathVariable("cid") int customerid) {
		Optional<CustomerUnit> cusbyid = customerrepository.findById(customerid);
		return cusbyid;
	}

	@PostMapping("/customer")
	public CustomerUnit addCustomer(@RequestBody CustomerUnit cunit) {
		CustomerUnit c = customerrepository.save(cunit);
		return c;
	}

	@PutMapping("/customer/{cid}")
	public CustomerUnit updateCustomerById(@PathVariable("cid") int customerid, @RequestBody CustomerUnit cunit) {
		Optional<CustomerUnit> optional = customerrepository.findById(customerid);
		CustomerUnit cusbyid = optional.get();
		cusbyid.setCustomerFirstName(cunit.getCustomerFirstName());
		cusbyid.setCustomerLastName(cunit.getCustomerLastName());
		cusbyid.setCustomerId(cunit.getCustomerId());
		cusbyid.getPartnerOrgUnit()
				.setPartnerOrgId(cunit.getPartnerOrgUnit().getPartnerOrgId());
		cusbyid.getPartnerOrgUnit()
				.setSponsorPartnerBusinessManager(cunit.getPartnerOrgUnit().getSponsorPartnerBusinessManager());
		cusbyid.getPartnerOrgUnit()
				.getOrgunit()
				.setOrgId(cunit.getPartnerOrgUnit().getOrgunit().getOrgId());
		cusbyid.getPartnerOrgUnit()
				.getOrgunit()
				.setOrgName(cunit.getPartnerOrgUnit().getOrgunit().getOrgName());
		cusbyid.getPartnerOrgUnit()
				.getOrgunit()
				.setFaxNumber(cunit.getPartnerOrgUnit().getOrgunit().getFaxNumber());
		cusbyid.getPartnerOrgUnit()
				.getOrgunit()
				.setPhoneNumber(cunit.getPartnerOrgUnit().getOrgunit().getPhoneNumber());
		cusbyid.getPostal().setPostalCodeId(cunit.getPostal().getPostalCodeId());
		cusbyid.getPostal()
				.setPostalCodeValue(cunit.getPostal().getPostalCodeValue());
		cusbyid.getPostal()
				.getCity()
				.setCityid(cunit.getPostal().getCity().getCityid());
		cusbyid.getPostal()
				.getCity()
				.setCitycommlang(cunit.getPostal().getCity().getCitycommlang());
		cusbyid.getPostal()
				.getCity()
				.setCityname(cunit.getPostal().getCity().getCityname());
		cusbyid.getPostal()
				.getCity()
				.getRegionId()
				.setRegionid(cunit.getPostal().getCity().getRegionId().getRegionid());
		cusbyid.getPostal()
				.getCity()
				.getRegionId()
				.setRegionname(cunit.getPostal().getCity().getRegionId().getRegionname());
		cusbyid.getPostal()
				.getCity()
				.getRegionId()
				.getCountry()
				.setCountryid(cunit.getPostal().getCity().getRegionId().getCountry().getCountryid());
		cusbyid.getPostal()
				.getCity()
				.getRegionId()
				.getCountry()
				.setCountryname(cunit.getPostal().getCity().getRegionId().getCountry().getCountryname());
		return customerrepository.save(cusbyid);

	}
	
	@DeleteMapping("/customer/{id}")
		public void deleteCustomerById(@PathVariable("id") int customerid) {
			customerrepository.deleteById(customerid);
			
		
	}
	@DeleteMapping("/customers/")
	public void deleteCustomers() {
		customerrepository.deleteAll();
		
	
}
	@PatchMapping("/orgunit/{id}")
	public CustomerUnit orgunitUpdate(
	  @RequestBody OrgUnit partialUpdate, @PathVariable("id") int id) {
		Optional<CustomerUnit> optional = customerrepository.findById(id);
		CustomerUnit cusbyid = optional.get();
		cusbyid.getPartnerOrgUnit().getOrgunit().setOrgId(partialUpdate.getOrgId());
		cusbyid.getPartnerOrgUnit().getOrgunit().setOrgName(partialUpdate.getOrgName());
		cusbyid.getPartnerOrgUnit().getOrgunit().setFaxNumber(partialUpdate.getFaxNumber());
		cusbyid.getPartnerOrgUnit().getOrgunit().setPhoneNumber(partialUpdate.getPhoneNumber());

		customerrepository.save(cusbyid);
	    return cusbyid;
	    
	}
	
	@PatchMapping("/partnerorgunit/{id}")
	public CustomerUnit orgunitUpdate(
	  @RequestBody PartnerOrgUnit partialUpdate, @PathVariable("id") int id) {
		Optional<CustomerUnit> optional = customerrepository.findById(id);
		CustomerUnit cusbyid = optional.get();
		cusbyid.getPartnerOrgUnit().setPartnerOrgId(partialUpdate.getPartnerOrgId());
		cusbyid.getPartnerOrgUnit().setResellerEnabled(partialUpdate.isResellerEnabled());
		cusbyid.getPartnerOrgUnit().setOnCreditHold(partialUpdate.isOnCreditHold());
		cusbyid.getPartnerOrgUnit().setSponsorPartnerBusinessManager(partialUpdate.getSponsorPartnerBusinessManager());

		customerrepository.save(cusbyid);
	    return cusbyid;
	    
	}
	
	@PatchMapping("/postal/{id}")
	public CustomerUnit postalUpdate(
	  @RequestBody Postal partialUpdate, @PathVariable("id") int id) {
		Optional<CustomerUnit> optional = customerrepository.findById(id);
		CustomerUnit cusbyid = optional.get();
		cusbyid.getPostal().setPostalCodeId(partialUpdate.getPostalCodeId());
		cusbyid.getPostal().setPostalCodeValue(partialUpdate.getPostalCodeValue());
		
		customerrepository.save(cusbyid);
	    return cusbyid;
	}
	
	@PatchMapping("/city/{id}")
	public CustomerUnit cityUpdate(
	  @RequestBody City partialUpdate, @PathVariable("id") int id) {
		Optional<CustomerUnit> optional = customerrepository.findById(id);
		CustomerUnit cusbyid = optional.get();
		cusbyid.getPostal().getCity().setCitycommlang(partialUpdate.getCitycommlang());
		cusbyid.getPostal().getCity().setCityid(partialUpdate.getCityid());
		cusbyid.getPostal().getCity().setCityname(partialUpdate.getCityname());
		
		customerrepository.save(cusbyid);
	    return cusbyid;
	}
	
	@PatchMapping("/region/{id}")
	public CustomerUnit regionUpdate(
	  @RequestBody Region partialUpdate, @PathVariable("id") int id) {
		Optional<CustomerUnit> optional = customerrepository.findById(id);
		CustomerUnit cusbyid = optional.get();
		cusbyid.getPostal().getCity().getRegionId().setRegionid(partialUpdate.getRegionid());
		cusbyid.getPostal().getCity().getRegionId().setRegionname(partialUpdate.getRegionname());
		customerrepository.save(cusbyid);
	    return cusbyid;
	}
	
	@PatchMapping("/country/{id}")
	public CustomerUnit CityUpdate(
	  @RequestBody Country partialUpdate, @PathVariable("id") int id) {
		Optional<CustomerUnit> optional = customerrepository.findById(id);
		CustomerUnit cusbyid = optional.get();
		cusbyid.getPostal().getCity().getRegionId().getCountry().setCountryname(partialUpdate.getCountryname());
		cusbyid.getPostal().getCity().getRegionId().getCountry().setCountryid(partialUpdate.getCountryid());
		customerrepository.save(cusbyid);
	    return cusbyid;
	}
	
	
}
