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

@Entity
@Table(name = "SDP_POSTALCODE")
public class Postal {

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PostalCodeID")
	private Long postalCodeId;

	@Column(name = "PostalCodeValue")
	private String postalCodeValue;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CityId")
	private City city;

	public Postal() {
	}

	public Postal(Long postalCodeId, String postalCodeValue, City city) {
		super();
		this.postalCodeId = postalCodeId;
		this.postalCodeValue = postalCodeValue;
		this.city=city;
	}

	public Long getPostalCodeId() {
		return postalCodeId;
	}

	public void setPostalCodeId(Long postalCodeId) {
		this.postalCodeId = postalCodeId;
	}

	public String getPostalCodeValue() {
		return postalCodeValue;
	}

	public void setPostalCodeValue(String postalCodeValue) {
		this.postalCodeValue = postalCodeValue;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Postal [postalCodeId=" + postalCodeId + ", postalCodeValue=" + postalCodeValue + ", city=" + city + "]";
	}

	
}
