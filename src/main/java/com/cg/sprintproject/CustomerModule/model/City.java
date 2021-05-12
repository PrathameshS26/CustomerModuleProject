package com.cg.sprintproject.CustomerModule.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CITYCODE")
public class City {
	@Id
	@GeneratedValue
	@Column(name = "CITYID")
	private int cityid;
	@Column(name = "CITYNAME")
	private String cityname;
	@Column(name = "CITYCOMMLANG")
	private String citycommlang;
	@OneToOne(mappedBy = "REGIONCODE")
	private Region regionId;

	public City() {
		// TODO Auto-generated constructor stub
	}

	public City(int cityid, String cityname, String citycommlang, Region regionId) {
		super();
		this.cityid = cityid;
		this.cityname = cityname;
		this.citycommlang = citycommlang;
		this.regionId = regionId;
	}

	public int getCityid() {
		return cityid;
	}

	public void setCityid(int cityid) {
		this.cityid = cityid;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getCitycommlang() {
		return citycommlang;
	}

	public void setCitycommlang(String citycommlang) {
		this.citycommlang = citycommlang;
	}

	public Region getRegionId() {
		return regionId;
	}

	public void setRegionId(Region regionId) {
		this.regionId = regionId;
	}

}