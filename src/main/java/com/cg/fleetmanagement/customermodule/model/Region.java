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
@Table(name = "REGIONCODE")
public class Region {
	@Id
	//@GeneratedValue
	@Column(name = "REGIONID")
	private int Regionid;
	@Column(name = "REGIONNAME")
	private String Regionname;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "CountryId")
	private Country country;

	public Region() {
		// TODO Auto-generated constructor stub
	}

	public Region(int regionid, String regionname, Country country) {
		super();
		Regionid = regionid;
		Regionname = regionname;
		this.country = country;
	}

	public int getRegionid() {
		return Regionid;
	}

	public void setRegionid(int regionid) {
		Regionid = regionid;
	}

	public String getRegionname() {
		return Regionname;
	}

	public void setRegionname(String regionname) {
		Regionname = regionname;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}