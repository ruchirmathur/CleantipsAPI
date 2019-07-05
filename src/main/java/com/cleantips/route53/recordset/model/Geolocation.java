/*
 * 
 */
package com.cleantips.route53.recordset.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

// TODO: Auto-generated Javadoc
/**
 * The Class Geolocation.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Geolocation {

/** The Continent code. */
private String ContinentCode;

/** The Country code. */
private String CountryCode;

/** The Subdivision code. */
private String SubdivisionCode;

/**
 * Gets the continent code.
 *
 * @return the continent code
 */
public String getContinentCode() {
	return ContinentCode;
}

/**
 * Sets the continent code.
 *
 * @param continentCode the new continent code
 */
public void setContinentCode(String continentCode) {
	ContinentCode = continentCode;
}

/**
 * Gets the country code.
 *
 * @return the country code
 */
public String getCountryCode() {
	return CountryCode;
}

/**
 * Sets the country code.
 *
 * @param countryCode the new country code
 */
public void setCountryCode(String countryCode) {
	CountryCode = countryCode;
}

/**
 * Gets the subdivision code.
 *
 * @return the subdivision code
 */
public String getSubdivisionCode() {
	return SubdivisionCode;
}

/**
 * Sets the subdivision code.
 *
 * @param subdivisionCode the new subdivision code
 */
public void setSubdivisionCode(String subdivisionCode) {
	SubdivisionCode = subdivisionCode;
}
}
