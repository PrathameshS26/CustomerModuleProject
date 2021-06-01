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
	private String countryname;
	
	@Column(name = "StateName",length = 50)
	private String statename;
	
	@Column(name = "CityName",length = 50)
	private String cityName;

	public PostalFeed() {
		
		// TODO Auto-generated constructor stub
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountryname() {
		return countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}

	public String getStatename() {
		return statename;
	}

	public void setStatename(String statename) {
		this.statename = statename;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	

	
	
	
}