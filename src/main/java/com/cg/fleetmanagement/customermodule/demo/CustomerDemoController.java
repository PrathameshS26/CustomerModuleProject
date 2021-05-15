package com.cg.fleetmanagement.customermodule.demo;
//package com.cg.fleetmanagement.customermodule.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import com.cg.fleetmanagement.customermodule.model.City;
//import com.cg.fleetmanagement.customermodule.model.Country;
//import com.cg.fleetmanagement.customermodule.model.CustomerUnit;
//import com.cg.fleetmanagement.customermodule.model.OrgUnit;
//import com.cg.fleetmanagement.customermodule.model.PartnerOrgUnit;
//import com.cg.fleetmanagement.customermodule.model.Postal;
//import com.cg.fleetmanagement.customermodule.model.Region;
//import com.cg.fleetmanagement.customermodule.repository.CustomerRepository;
//import com.cg.fleetmanagement.customermodule.repository.PartnerOrgUnitRepository;
//
//@Component
//public class CustomerDemoController implements CommandLineRunner {
//	@Autowired
//	private CustomerRepository customerrepository;

//	@Override
	//public void run(String... args) throws Exception {
//		Country country = new Country();
//		country.setCountryid(10);
//		country.setCountryname("Spain");
//		
//		Region region = new Region();
//		region.setCountry(country);
//		region.setRegionid(68);
//		region.setRegionname("Europe");
//		
//		City city = new City();
//		city.setCitycommlang("Spanish");
//		city.setCityid(19);
//		city.setCityname("Barcelona");
//		city.setRegionId(region);
//		
//		
//		OrgUnit orgunit = new OrgUnit();
//		orgunit.setFaxNumber(789865);
//		orgunit.setOrgId(3);
//		orgunit.setOrgName("Rakuten");
//		orgunit.setPhoneNumber(2255778844l);
//
//		PartnerOrgUnit partnerOrgUnit = new PartnerOrgUnit();
//		partnerOrgUnit.setPartnerOrgId(28);
//		partnerOrgUnit.setResellerEnabled(true);
//		partnerOrgUnit.setSponsorPartnerBusinessManager("Puig");
//		partnerOrgUnit.setOnCreditHold(false);
//		partnerOrgUnit.setOrgunit(orgunit);
//
//		Postal postal = new Postal();
//		postal.setPostalCodeId(22l);
//		postal.setPostalCodeValue("226878");
//		postal.setCity(city);
//
//		CustomerUnit customerunit = new CustomerUnit();
//		customerunit.setCustomerId(33);
//		customerunit.setCustomerFirstName("Prathamesh");
//		customerunit.setCustomerLastName("Sawant");
//		customerunit.setPartnerOrgUnit(partnerOrgUnit);
//		customerunit.setPostal(postal);
//		customerrepository.save(customerunit);

//	}
//
//}
