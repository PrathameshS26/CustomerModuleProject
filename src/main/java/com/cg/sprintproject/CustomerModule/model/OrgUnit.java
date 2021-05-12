package com.cg.sprintproject.CustomerModule.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORGUNIT")
public class OrgUnit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "OrgID", length = 20)
	private int OrgId;
	
	@Column(name = "OrgName", length = 50)
	private String orgName;
	
	@Column(name = "OrgNumber", length = 20)
	private long phoneNumber;
	
	@Column(name = "OrgFax", length = 20)
	private long faxNumber;

	public OrgUnit() {}

	public OrgUnit(int orgId, String orgName, long phoneNumber, long faxNumber) {
		super();
		OrgId = orgId;
		this.orgName = orgName;
		this.phoneNumber = phoneNumber;
		this.faxNumber = faxNumber;
	}

	public int getOrgId() {
		return OrgId;
	}

	public void setOrgId(int orgId) {
		OrgId = orgId;
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

	public long getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(long faxNumber) {
		this.faxNumber = faxNumber;
	}

	@Override
	public String toString() {
		return "OrgUnit [OrgId=" + OrgId + ", orgName=" + orgName + ", phoneNumber=" + phoneNumber + ", faxNumber="
				+ faxNumber + "]";
	}
	
	

}
