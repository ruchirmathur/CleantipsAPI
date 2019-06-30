package com.cleantips.api.model;

import java.util.ArrayList;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;

@DynamoDBTable(tableName="AppServices_v1")
public class Appservices {
	@DynamoDBHashKey(attributeName="Architecture")
	private String architecture;
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
	public ArrayList<Services> getServices() {
		return services;
	}
	public void setServices(ArrayList<Services> services) {
		this.services = services;
	}
	@DynamoDBAttribute(attributeName="ArchitectureImage")
	private String architectureImage;
	@DynamoDBTypeConverted(converter = ServicesConvertor.class)
	@DynamoDBAttribute(attributeName="Services")
	private ArrayList<Services> services;
	

}
