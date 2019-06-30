package com.cleantips.api.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArchitectureSearchResponse2 {
private String architecture;
private ArrayList<Services2>  appServices;

public String getArchitecture() {
	return architecture;
}

public ArrayList<Services2> getAppServices() {
	return appServices;
}

public void setAppServices(ArrayList<Services2> appServices) {
	this.appServices = appServices;
}

public void setArchitecture(String architecture) {
	this.architecture = architecture;
}



}
