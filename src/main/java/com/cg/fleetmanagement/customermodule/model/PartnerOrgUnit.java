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
@Table(name = "SDP_PARTNERORGUNIT")
public class PartnerOrgUnit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PartnerOrgID", length = 10)
	private int partnerOrgId;

	@Column(name = "BU_Manager", length = 50,nullable = false)
	private String sponsorPartnerBusinessManager;

	@Column(name = "IsReselleEnabled")
	private boolean isResellerEnabled;

	@Column(name = " IsOnCreditHold")
	private boolean isOnCreditHold;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "OrgID")
	private OrgUnit orgunit;

	public PartnerOrgUnit() {
	}

	public PartnerOrgUnit(int partnerOrgId, String sponsorPartnerBusinessManager, boolean isResellerEnabled,
			boolean isOnCreditHold, OrgUnit orgunit) {
		super();
		this.partnerOrgId = partnerOrgId;
		this.sponsorPartnerBusinessManager = sponsorPartnerBusinessManager;
		this.isResellerEnabled = isResellerEnabled;
		this.isOnCreditHold = isOnCreditHold;
		this.orgunit = orgunit;
	}

	public int getPartnerOrgId() {
		return partnerOrgId;
	}

	public void setPartnerOrgId(int partnerOrgId) {
		this.partnerOrgId = partnerOrgId;
	}

	public String getSponsorPartnerBusinessManager() {
		return sponsorPartnerBusinessManager;
	}

	public void setSponsorPartnerBusinessManager(String sponsorPartnerBusinessManager) {
		this.sponsorPartnerBusinessManager = sponsorPartnerBusinessManager;
	}

	public boolean isResellerEnabled() {
		return isResellerEnabled;
	}

	public void setResellerEnabled(boolean isResellerEnabled) {
		this.isResellerEnabled = isResellerEnabled;
	}

	public boolean isOnCreditHold() {
		return isOnCreditHold;
	}

	public void setOnCreditHold(boolean isOnCreditHold) {
		this.isOnCreditHold = isOnCreditHold;
	}

	@Override
	public String toString() {
		return "PartnerOrgUnit [partnerOrgId=" + partnerOrgId + ", sponsorPartnerBusinessManager="
				+ sponsorPartnerBusinessManager + ", isResellerEnabled=" + isResellerEnabled + ", isOnCreditHold="
				+ isOnCreditHold + "]";
	}

	public OrgUnit getOrgunit() {
		return orgunit;
	}

	public void setOrgunit(OrgUnit orgunit) {
		this.orgunit = orgunit;
	}

}
