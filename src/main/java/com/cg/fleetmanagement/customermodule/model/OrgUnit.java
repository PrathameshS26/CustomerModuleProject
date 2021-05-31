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

@Entity
@Table(name = "ORGUNIT")
public class OrgUnit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PartnerOrgID", length = 10)
	private int orgId;

	@Column(name = "OrgName", length = 50,nullable = false)
	private String orgName;
	
	@Column(name = "OrgNumber", length = 10,nullable = false)
	private long phoneNumber;
	

	public OrgUnit() {
		
	}

	public OrgUnit(int orgId, String orgName, long phoneNumber) {
		this.orgId = orgId;
		this.orgName = orgName;
		this.phoneNumber = phoneNumber;
	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	
}