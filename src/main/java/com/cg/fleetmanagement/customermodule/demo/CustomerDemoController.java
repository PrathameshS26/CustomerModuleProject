//package com.cg.fleetmanagement.customermodule.demo;
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

// Working with Validation


//package com.cg.fleetmanagement.customermodule.controller;
//
//import java.net.URI;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import com.cg.fleetmanagement.customermodule.model.City;
//import com.cg.fleetmanagement.customermodule.model.Country;
//import com.cg.fleetmanagement.customermodule.model.CustomerUnit;
//import com.cg.fleetmanagement.customermodule.model.OrgUnit;
//import com.cg.fleetmanagement.customermodule.model.PartnerOrgUnit;
//import com.cg.fleetmanagement.customermodule.model.Postal;
//import com.cg.fleetmanagement.customermodule.model.Region;
//import com.cg.fleetmanagement.customermodule.repository.CustomerRepository;
//import com.cg.fleetmanagement.customermodule.serviceimplementation.CustomerUnitImplementation;
//
//@RestController
//@RequestMapping("/customers")
//public class CustomerUnitController {
//
//	@Autowired
//	private CustomerUnitImplementation customerservice;
//
//	@GetMapping()
//	public ResponseEntity<List<CustomerUnit>> getCustomers() {
//		List<CustomerUnit> custs = customerservice.viewAllCustomers();
//		ResponseEntity<List<CustomerUnit>> response = new ResponseEntity<>(custs, HttpStatus.NOT_FOUND);
//		if (!custs.isEmpty()) {
//			response = new ResponseEntity<>(custs, HttpStatus.OK);
//		}
//		return response;	
//	}
//
//
//	@GetMapping("/customer/{cid}")
//	public ResponseEntity<Object> getCustomerById(@PathVariable("cid") int customerid) {
//		Optional<CustomerUnit> cusbyid = Optional.ofNullable(customerservice.viewCustomer(customerid));
//		//ResponseEntity<Optional<CustomerUnit>> response = new ResponseEntity<>(cusbyid, HttpStatus.NOT_FOUND);
//		ResponseEntity<Object> response1 = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Message " + customerid + " Not found");
//
//		// If message is not null it sets the message object in response else by default
//		// error
//		// will be there in response.
//		if (cusbyid != null) {
//			response1 = new ResponseEntity<>(cusbyid, HttpStatus.OK);
//		}
//
//		return response1;
//		
//	}
//
//	@PostMapping("/customer")
//	public ResponseEntity<CustomerUnit> addCustomer(@RequestBody CustomerUnit cunit) {
//		 Optional<CustomerUnit> cus = Optional.ofNullable(customerservice.addCustomer(cunit));
//		 ResponseEntity<CustomerUnit> response = new ResponseEntity<>(cus.get(), HttpStatus.NOT_FOUND);
//
//			if (!cus.isEmpty()) {
//				response = new ResponseEntity<>(cus.get(), HttpStatus.OK);
//			}
//			return response;	
//		}
//	public ResponseEntity<Object> addMessage(@RequestBody CustomerUnit cunit) {
//		// If message is inserted it returns inserted message object else null
//		CustomerUnit newCustomer = customerservice.addCustomer(cunit);
//		// response is set to error if message is null.
//		if (newCustomer == null)
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Inernal server error");
//		// response is set to inserted message id in response header section.
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(newCustomer.getCustomerId()).toUri();
//		return ResponseEntity.created(location).build();
//	}
//
//
//	@PutMapping("/customer/{cid}")
//	public ResponseEntity<Optional<CustomerUnit>> updateCustomerById(@PathVariable("cid") int customerid, @RequestBody CustomerUnit cunit) {
//		Optional<CustomerUnit> cus= Optional.ofNullable(customerservice.updateCustomer(customerid, cunit));
//		ResponseEntity<Optional<CustomerUnit>> response = new ResponseEntity<>(cus, HttpStatus.NOT_FOUND);
//
//		if (!cus.isEmpty()) {
//			response = new ResponseEntity<>(cus, HttpStatus.OK);
//		}
//		return response;
//
//	}
//
//	@DeleteMapping("/customer/{id}")
//	public void deleteCustomerById(@PathVariable("id") int customerid) {
//		customerservice.deleteCustomer(customerid);
//
//	}

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

