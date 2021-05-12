package com.cg.sprintproject.CustomerModule.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SDP_POSTALCODE")
public class PostalCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PostalCodeID")
	private Long postalCodeId;
	
	@Column(name = "PostalCodeValue")
	private String postalCodeValue;

	public PostalCode() {
		super();
	}

	public PostalCode(Long postalCodeId, String postalCodeValue) {
		super();
		this.postalCodeId = postalCodeId;
		this.postalCodeValue = postalCodeValue;
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
	
	

}
