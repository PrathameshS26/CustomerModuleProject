package com.cg.fleetmanagement.customermodule.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRYCODE")
public class Country {
	@Id
	@GeneratedValue
	@Column(name = "COUNTRYID",length = 20)
	private int Countryid;
	@Column(name = "COUNTRYNAME",length = 50,nullable = false)
	private String Countryname;

	public Country() {
		// TODO Auto-generated constructor stub
	}

	public Country(int countryid, String countryname) {
		super();
		Countryid = countryid;
		Countryname = countryname;
	}

	public int getCountryid() {
		return Countryid;
	}

	public void setCountryid(int countryid) {
		Countryid = countryid;
	}

	public String getCountryname() {
		return Countryname;
	}

	public void setCountryname(String countryname) {
		Countryname = countryname;
	}

}
