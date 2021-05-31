package com.cg.fleetmanagement.customermodule.model;

import javax.annotation.Generated;
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
@Table(name = "SDP_POSTAL")
public class Postal {

	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PostalCodeID")
	private Long postalCodeId;

	@Column(name = "PostalCodeValue",length = 6,nullable = false)
	private int postalCodeValue;
	
	@JsonIgnore
	@Column(name = "CountryName",length = 50,nullable = false)
	private String countryname;
	
	@JsonIgnore
	@Column(name = "StateName",length = 50)
	private String statename;
	
	@JsonIgnore
	@Column(name = "CityName",length = 50,nullable = false)
	private String cityname;

	public Postal() {
	}

	public Postal(Long postalCodeId, int postalCodeValue, String countryname, String statename, String cityname) {
		this.postalCodeId = postalCodeId;
		this.postalCodeValue = postalCodeValue;
		this.countryname = countryname;
		this.statename = statename;
		this.cityname = cityname;
	}

	public Long getPostalCodeId() {
		return postalCodeId;
	}

	public void setPostalCodeId(Long postalCodeId) {
		this.postalCodeId = postalCodeId;
	}

	public int getPostalCodeValue() {
		return postalCodeValue;
	}

	public void setPostalCodeValue(int postalCodeValue) {
		this.postalCodeValue = postalCodeValue;
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

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	@Override
	public String toString() {
		return "Postal [postalCodeId=" + postalCodeId + ", postalCodeValue=" + postalCodeValue + ", Countryname="
				+ countryname + ", Statename=" + statename + ", cityname=" + cityname + "]";
	}
	
	

	
}