package com.cleantips.api.model;

import java.util.ArrayList;

public class ApplicationServicesResponse {
private ArrayList<Services> appServices;
private String architectureImage;
public ArrayList<Services> getAppServices() {
	return appServices;
}
public void setAppServices(ArrayList<Services> appServices) {
	this.appServices = appServices;
}
public String getArchitecture() {
	return architecture;
}
public void setArchitecture(String architecture) {
	this.architecture = architecture;
}
public String getArchitectureImage() {
	return architectureImage;
}
public void setArchitectureImage(String architectureImage) {
	this.architectureImage = architectureImage;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
private String architecture;
private String status;
}
