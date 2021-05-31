package com.cg.fleetmanagement.customermodule.model;

import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
@Table(name = "CUSTOMER_UNIT")
public class CustomerUnit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CUSTOMER_ID", length = 10)
	private int customerId;

	@Column(name = "CUSTOMER_FNAME", length = 50,nullable = false)
	private String customerFirstName;

	@Column(name = "CUSTOMER_LNAME", length = 50,nullable = false)
	private String customerLastName;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "orgid")
	private OrgUnit orgUnit;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "postalid")
	private Postal postal;

	
//	@JsonIgnore
//	@OneToMany(fetch = FetchType.LAZY)
//	private List<Proposal> proposal;
//	
//	@JsonIgnore
//	@OneToMany(fetch = FetchType.LAZY)
//	private List<Opportunity> opportunity;

	public CustomerUnit() {
	}

public CustomerUnit(int customerId, String customerFirstName, String customerLastName, OrgUnit orgUnit, Postal postal) {
	super();
	this.customerId = customerId;
	this.customerFirstName = customerFirstName;
	this.customerLastName = customerLastName;
	this.orgUnit = orgUnit;
	this.postal = postal;
}

public int getCustomerId() {
	return customerId;
}

public void setCustomerId(int customerId) {
	this.customerId = customerId;
}

public String getCustomerFirstName() {
	return customerFirstName;
}

public void setCustomerFirstName(String customerFirstName) {
	this.customerFirstName = customerFirstName;
}

public String getCustomerLastName() {
	return customerLastName;
}

public void setCustomerLastName(String customerLastName) {
	this.customerLastName = customerLastName;
}

public OrgUnit getOrgUnit() {
	return orgUnit;
}

public void setOrgUnit(OrgUnit orgUnit) {
	this.orgUnit = orgUnit;
}

public Postal getPostal() {
	return postal;
}

public void setPostal(Postal postal) {
	this.postal = postal;
}

@Override
public String toString() {
	return "CustomerUnit [customerId=" + customerId + ", customerFirstName=" + customerFirstName + ", customerLastName="
			+ customerLastName + ", orgUnit=" + orgUnit + ", postal=" + postal + "]";
}

	}
