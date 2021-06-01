package com.cg.fleetmanagement.customermodule.serviceimplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fleetmanagement.customermodule.model.CustomerUnit;
import com.cg.fleetmanagement.customermodule.model.OrgUnit;

import com.cg.fleetmanagement.customermodule.model.Postal;
import com.cg.fleetmanagement.customermodule.model.PostalFeed;
import com.cg.fleetmanagement.customermodule.repository.CustomerRepository;
import com.cg.fleetmanagement.customermodule.service.CustomerUnitService;
import com.cg.fleetmanagement.customermodule.repository.PostalFeedRepository;

@Service
public class CustomerUnitImplementation implements CustomerUnitService {
	@Autowired
	private PostalFeedRepository postalrepository;
	@Autowired
	private CustomerRepository customerrepository;

	@Override
	public List<CustomerUnit> viewAllCustomers() {
		List<CustomerUnit> customerslist = customerrepository.findAll();
		return customerslist;
	}

	@Override
	public CustomerUnit viewCustomer(int customerId) {
		Optional<CustomerUnit> message = customerrepository.findById(customerId);
		return (message.isPresent()) ? message.get() : null;
	}

	@Override
	public CustomerUnit addCustomer(CustomerUnit addcustomer) {

		Optional<PostalFeed> pf = postalrepository.findById(addcustomer.getPostal().getPostalCodeValue());
		PostalFeed postal = pf.get();
		addcustomer.getPostal().setCountryname(postal.getCountryname());
		addcustomer.getPostal().setStatename(postal.getStatename());
		addcustomer.getPostal().setCityname(postal.getCityName());

		CustomerUnit c = customerrepository.save(addcustomer);
		return c;
	}

	@Override
	public CustomerUnit updateCustomer(int customerid, CustomerUnit updatecustomer) {
		Optional<CustomerUnit> optional = customerrepository.findById(customerid);
		CustomerUnit cusbyid = optional.get();
		System.out.println(cusbyid);
		System.out.println(cusbyid.getOrgUnit());
		
		Optional<PostalFeed> pf = postalrepository.findById(updatecustomer.getPostal().getPostalCodeValue());
		PostalFeed postal = pf.get();

		cusbyid.setCustomerFirstName(updatecustomer.getCustomerFirstName());
		cusbyid.setCustomerLastName(updatecustomer.getCustomerLastName());
		cusbyid.getOrgUnit().setOrgName(updatecustomer.getOrgUnit().getOrgName());
		cusbyid.getOrgUnit().setPhoneNumber(updatecustomer.getOrgUnit().getPhoneNumber());
//		cusbyid.getPostal().setCityname(updatecustomer.getPostal().getCityname());
		
		updatecustomer.getPostal().setPostalCodeValue(postal.getPostalCode());
		updatecustomer.getPostal().setStatename(postal.getStatename());
		updatecustomer.getPostal().setCountryname(postal.getCountryname());
		updatecustomer.getPostal().setCityname(postal.getCityName());
		
		return customerrepository.save(cusbyid);

	}

	@Override
	public void deleteCustomer(int customerid) {
		customerrepository.deleteById(customerid);

	}

}
