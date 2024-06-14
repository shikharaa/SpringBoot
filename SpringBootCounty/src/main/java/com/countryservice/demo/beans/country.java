package com.countryservice.demo.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;




@Entity
@Table(name="country")
public class country {
	
	@Id
	@Column(name="id")
	int id;
	
	@Column(name="capital")
	String countryCaptial;
	
	@Column(name="country_name")
	String countryName;
	

	public country() {
		super();
		// TODO Auto-generated constructor stub
	}
	public country(int id, String countryName, String countryCaptial) {
		super();
		this.id = id;
		this.countryName = countryName;
		this.countryCaptial = countryCaptial;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryCaptial() {
		return countryCaptial;
	}
	public void setCountryCaptial(String countryCaptial) {
		this.countryCaptial = countryCaptial;
	} 
	
	
	

}
