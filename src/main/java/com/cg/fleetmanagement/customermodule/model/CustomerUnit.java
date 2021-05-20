package com.cg.fleetmanagement.customermodule.model;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@JoinColumn(name = "partnerorgid")
	private PartnerOrgUnit partnerOrgUnit;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "postalid")
	private Postal postal;

	public CustomerUnit() {
	}

	public CustomerUnit(int customerId, String customerFirstName, String customerLastName,
			PartnerOrgUnit partnerOrgUnit, Postal postal) {
		super();
		this.customerId = customerId;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.partnerOrgUnit = partnerOrgUnit;
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

	public PartnerOrgUnit getPartnerOrgUnit() {
		return partnerOrgUnit;
	}

	public void setPartnerOrgUnit(PartnerOrgUnit partnerOrgUnit) {
		this.partnerOrgUnit = partnerOrgUnit;
	}

	public Postal getPostal() {
		return postal;
	}

	public void setPostal(Postal postal) {
		this.postal = postal;
	}

	@Override
	public String toString() {
		return "CustomerUnit [customerId=" + customerId + ", customerFirstName=" + customerFirstName
				+ ", customerLastName=" + customerLastName;
	}

}
