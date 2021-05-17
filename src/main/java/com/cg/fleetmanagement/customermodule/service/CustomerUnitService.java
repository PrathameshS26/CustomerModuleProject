package com.cg.fleetmanagement.customermodule.service;

import java.util.List;

import com.cg.fleetmanagement.customermodule.model.City;
import com.cg.fleetmanagement.customermodule.model.Country;
import com.cg.fleetmanagement.customermodule.model.CustomerUnit;
import com.cg.fleetmanagement.customermodule.model.OrgUnit;
import com.cg.fleetmanagement.customermodule.model.PartnerOrgUnit;
import com.cg.fleetmanagement.customermodule.model.Postal;
import com.cg.fleetmanagement.customermodule.model.Region;

public interface CustomerUnitService {

	public List<CustomerUnit> viewAllCustomers();

	public CustomerUnit viewCustomer(int customerId);

	public CustomerUnit addCustomer(CustomerUnit addcustomer);

	public CustomerUnit updateCustomer(int customerid,CustomerUnit updatecustomer);
	
	public CustomerUnit updatePartnerOrg(int partnerOrgUnitid,PartnerOrgUnit updatepartnerOrg);
	
	public CustomerUnit updateOrgUnit(int orgUnitid, OrgUnit updateOrg);
	
	public CustomerUnit updatePostaldetails(int postalid, Postal updatePostal);
	
	public CustomerUnit updateCitydetails(int cityid, City updateCity);
	
	public CustomerUnit updateRegiondetails(int regionid, Region updateRegion);
	
	public CustomerUnit updateCountrydetails(int countryid, Country updateCountry);

	public void deleteCustomer(int customerid);
	
	

	// public CustomerUnit validateCustomer(String userName, String password);

}
