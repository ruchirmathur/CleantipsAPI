package com.cleantips.route53.recordset.model;

public class Geolocation {
private String ContinentCode;
private String CountryCode;
private String SubdivisionCode;
public String getContinentCode() {
	return ContinentCode;
}
public void setContinentCode(String continentCode) {
	ContinentCode = continentCode;
}
public String getCountryCode() {
	return CountryCode;
}
public void setCountryCode(String countryCode) {
	CountryCode = countryCode;
}
public String getSubdivisionCode() {
	return SubdivisionCode;
}
public void setSubdivisionCode(String subdivisionCode) {
	SubdivisionCode = subdivisionCode;
}
}
