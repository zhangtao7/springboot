package com.tommy.springboot.spel;

public class PlaceOfBirth {

	private String city;
	private String country;
	
	public PlaceOfBirth() {
		
	}
	
	public PlaceOfBirth(String city, String country) {
		super();
		this.city = city;
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
