package com.cg.fleetmanagement.customermodule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cg.fleetmanagement.customermodule.model.CustomerUnit;
import com.cg.fleetmanagement.customermodule.model.OrgUnit;
import com.cg.fleetmanagement.customermodule.model.PartnerOrgUnit;
import com.cg.fleetmanagement.customermodule.model.Postal;
import com.cg.fleetmanagement.customermodule.repository.CustomerRepository;
import com.cg.fleetmanagement.customermodule.repository.PartnerOrgUnitRepository;

@Component
public class CustomerUnitController implements CommandLineRunner {
	@Autowired
	private CustomerRepository customerrepository;

	@Override
	public void run(String... args) throws Exception {
		OrgUnit orgunit = new OrgUnit();
		orgunit.setFaxNumber(228897);
		orgunit.setOrgId(77);
		orgunit.setOrgName("Accenture");
		orgunit.setPhoneNumber(9898989898l);

		PartnerOrgUnit partnerOrgUnit = new PartnerOrgUnit();
		partnerOrgUnit.setPartnerOrgId(1);
		partnerOrgUnit.setResellerEnabled(true);
		partnerOrgUnit.setSponsorPartnerBusinessManager("Ishaque");
		partnerOrgUnit.setOnCreditHold(false);
		partnerOrgUnit.setOrgunit(orgunit);

		Postal postal = new Postal();
		postal.setPostalCodeId(89l);
		postal.setPostalCodeValue("440023");

		CustomerUnit customerunit = new CustomerUnit();
		customerunit.setCustomerId(1);
		customerunit.setCustomerFirstName("XYZ");
		customerunit.setCustomerLastName("Kirishima");
		customerunit.setPartnerOrgUnit(partnerOrgUnit);
		customerunit.setPostal(postal);
		customerrepository.save(customerunit);

	}

}
