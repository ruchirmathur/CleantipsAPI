package com.cleantips.cloudfront.distribution.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class GeoRestriction {
private ArrayList<String> Locations;
public ArrayList<String> getLocations() {
	return Locations;
}
public void setLocations(ArrayList<String> locations) {
	Locations = locations;
}
public String getRestrictionType() {
	return RestrictionType;
}
public void setRestrictionType(String restrictionType) {
	RestrictionType = restrictionType;
}
private String RestrictionType;
}
