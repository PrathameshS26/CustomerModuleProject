package com.cg.fleetmanagement.customermodule.serviceimplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fleetmanagement.customermodule.model.City;
import com.cg.fleetmanagement.customermodule.model.Country;
import com.cg.fleetmanagement.customermodule.model.CustomerUnit;
import com.cg.fleetmanagement.customermodule.model.OrgUnit;
import com.cg.fleetmanagement.customermodule.model.PartnerOrgUnit;
import com.cg.fleetmanagement.customermodule.model.Postal;
import com.cg.fleetmanagement.customermodule.model.Region;
import com.cg.fleetmanagement.customermodule.repository.CustomerRepository;
import com.cg.fleetmanagement.customermodule.service.CustomerUnitService;

@Service
	public class CustomerUnitImplementation implements CustomerUnitService {

		@Autowired
		private  CustomerRepository customerrepository;

		@Override
		public List<CustomerUnit> viewAllCustomers() {
			List<CustomerUnit> customerslist = customerrepository.findAll();
			return customerslist;
		}


		@Override
		public CustomerUnit viewCustomer(int customerId){
//			Optional<CustomerUnit> cusbyid = customerrepository.findById(customerId);
//			CustomerUnit cus = cusbyid.get();
//			return cus;
			Optional<CustomerUnit> message = customerrepository.findById(customerId);
			return (message.isPresent()) ? message.get() : null;
		}
		

		@Override
		public CustomerUnit addCustomer(CustomerUnit addcustomer) {
			CustomerUnit c = customerrepository.save(addcustomer);
			return c;
		
		}


		@Override
		public CustomerUnit updateCustomer(int customerid,CustomerUnit updatecustomer) {
			Optional<CustomerUnit> optional = customerrepository.findById(customerid);
			CustomerUnit cusbyid = optional.get();
			System.out.println(cusbyid);
			System.out.println(cusbyid.getPartnerOrgUnit());
			System.out.println(cusbyid.getPartnerOrgUnit().getOrgunit());
			cusbyid.setCustomerFirstName(updatecustomer.getCustomerFirstName());
			cusbyid.setCustomerLastName(updatecustomer.getCustomerLastName());
//			cusbyid.setCustomerId(updatecustomer.getCustomerId());
			
//			cusbyid.getPartnerOrgUnit()
//					.setPartnerOrgId(updatecustomer.getPartnerOrgUnit().getPartnerOrgId());
			cusbyid.getPartnerOrgUnit()
					.setSponsorPartnerBusinessManager(updatecustomer.getPartnerOrgUnit().getSponsorPartnerBusinessManager());
//			cusbyid.getPartnerOrgUnit()
//					.getOrgunit()
//					.setOrgId(updatecustomer.getPartnerOrgUnit().getOrgunit().getOrgId());
			cusbyid.getPartnerOrgUnit()
					.getOrgunit()
					.setOrgName(updatecustomer.getPartnerOrgUnit().getOrgunit().getOrgName());
			cusbyid.getPartnerOrgUnit()
					.getOrgunit()
					.setFaxNumber(updatecustomer.getPartnerOrgUnit().getOrgunit().getFaxNumber());
			cusbyid.getPartnerOrgUnit()
					.getOrgunit()
					.setPhoneNumber(updatecustomer.getPartnerOrgUnit().getOrgunit().getPhoneNumber());
//			cusbyid.getPostal().setPostalCodeId(updatecustomer.getPostal().getPostalCodeId());
			cusbyid.getPostal()
					.setPostalCodeValue(updatecustomer.getPostal().getPostalCodeValue());
//			cusbyid.getPostal()
//					.getCity()
//					.setCityid(updatecustomer.getPostal().getCity().getCityid());
			cusbyid.getPostal()
					.getCity()
					.setCitycommlang(updatecustomer.getPostal().getCity().getCitycommlang());
			cusbyid.getPostal()
					.getCity()
					.setCityname(updatecustomer.getPostal().getCity().getCityname());
//			cusbyid.getPostal()
//					.getCity()
//					.getRegionId()
//					.setRegionid(updatecustomer.getPostal().getCity().getRegionId().getRegionid());
			cusbyid.getPostal()
					.getCity()
					.getRegionId()
					.setRegionname(updatecustomer.getPostal().getCity().getRegionId().getRegionname());
//			cusbyid.getPostal()
//					.getCity()
//					.getRegionId()
//					.getCountry()
//					.setCountryid(updatecustomer.getPostal().getCity().getRegionId().getCountry().getCountryid());
			cusbyid.getPostal()
					.getCity()
					.getRegionId()
					.getCountry()
					.setCountryname(updatecustomer.getPostal().getCity().getRegionId().getCountry().getCountryname());
			return customerrepository.save(cusbyid);

		}
		
		@Override
		public CustomerUnit updatePartnerOrg(int partnerOrgUnitid,PartnerOrgUnit partnerOrgUnit) {
			Optional<CustomerUnit> optional = customerrepository.findById(partnerOrgUnitid);
			CustomerUnit cusbyid = optional.get();
			System.out.println(cusbyid);
			cusbyid.getPartnerOrgUnit().setSponsorPartnerBusinessManager(partnerOrgUnit.getSponsorPartnerBusinessManager());
			cusbyid.getPartnerOrgUnit().setResellerEnabled(partnerOrgUnit.isResellerEnabled());
			cusbyid.getPartnerOrgUnit().setOnCreditHold(partnerOrgUnit.isOnCreditHold());
			return customerrepository.save(cusbyid);
			
		}
		
		@Override
		public CustomerUnit updateOrgUnit(int orgUnitid, OrgUnit updateOrg) {
			Optional<CustomerUnit> optional = customerrepository.findById(orgUnitid);
			CustomerUnit cusbyid = optional.get();
			cusbyid.getPartnerOrgUnit().getOrgunit().setOrgName(updateOrg.getOrgName());
			cusbyid.getPartnerOrgUnit().getOrgunit().setFaxNumber(updateOrg.getFaxNumber());
			cusbyid.getPartnerOrgUnit().getOrgunit().setPhoneNumber(updateOrg.getPhoneNumber());
			return customerrepository.save(cusbyid);
			
		}
		
		@Override
		 public CustomerUnit updatePostaldetails(int postalid, Postal updatePostal){
			Optional<CustomerUnit> optional = customerrepository.findById(postalid);
			CustomerUnit cusbyid = optional.get();
			cusbyid.getPostal().setPostalCodeValue(updatePostal.getPostalCodeValue());
			return customerrepository.save(cusbyid);
			
		}

		@Override
		 public CustomerUnit updateCitydetails(int cityid, City updateCity){
			Optional<CustomerUnit> optional = customerrepository.findById(cityid);
			CustomerUnit cusbyid = optional.get();
			cusbyid.getPostal().getCity().setCitycommlang(updateCity.getCitycommlang());
			cusbyid.getPostal().getCity().setCityname(updateCity.getCityname());
			return customerrepository.save(cusbyid);
			
		}
		
		@Override
		public CustomerUnit updateRegiondetails(int regionid, Region updateRegion){
			Optional<CustomerUnit> optional = customerrepository.findById(regionid);
			CustomerUnit cusbyid = optional.get();
			cusbyid.getPostal().getCity().getRegionId().setRegionname(updateRegion.getRegionname());	
			return customerrepository.save(cusbyid);
			
		}
		
		@Override
		public CustomerUnit updateCountrydetails(int countryid, Country updateCountry){
			Optional<CustomerUnit> optional = customerrepository.findById(countryid);
			CustomerUnit cusbyid = optional.get();
			cusbyid.getPostal().getCity().getRegionId().getCountry().setCountryname(updateCountry.getCountryname());	
			return customerrepository.save(cusbyid);
			
		}



		@Override
		public void deleteCustomer(int customerid) {
			customerrepository.deleteById(customerid);
			
		}
		
		
		

	}



