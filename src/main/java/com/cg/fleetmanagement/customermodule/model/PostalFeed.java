package com.cg.fleetmanagement.customermodule.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PostalFeed")
public class PostalFeed {

	@Id
	@Column(name = "PostalCode", length = 10)
	private int postalCode;
	
	
	@Column(name = "CountryName",length = 50,nullable = false)
	private String Countryname;
	
	@Column(name = "StateName",length = 50)
	private String Statename;

	public PostalFeed() {
		
		// TODO Auto-generated constructor stub
	}

	public PostalFeed(int postalCode, String countryname, String statename) {
		super();
		this.postalCode = postalCode;
		Countryname = countryname;
		Statename = statename;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountryname() {
		return Countryname;
	}

	public void setCountryname(String countryname) {
		Countryname = countryname;
	}

	public String getStatename() {
		return Statename;
	}

	public void setStatename(String statename) {
		Statename = statename;
	}

	@Override
	public String toString() {
		return "PostalFeed [postalCode=" + postalCode + ", Countryname=" + Countryname + ", Statename=" + Statename
				+ "]";
	}
	
	

	
	
	
}