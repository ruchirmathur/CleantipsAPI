package com.cleantips.api.model;

import java.util.HashMap;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

public class Services2 implements Comparable< Services2 > {

private String type;

private Integer priority;

private String templateUrl;


public String getTemplateUrl() {
	return templateUrl;
}

public void setTemplateUrl(String templateUrl) {
	this.templateUrl = templateUrl;
}

public Integer getPriority() {
	return priority;
}

public void setPriority(Integer priority) {
	this.priority = priority;
}

public String getDependentOn() {
	return dependentOn;
}

public void setDependentOn(String dependentOn) {
	this.dependentOn = dependentOn;
}
private String dependentOn;

private HashMap properties;


public HashMap getProperties() {
	return properties;
}

public void setProperties(HashMap properties) {
	this.properties = properties;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}
public int compareTo(Services2 o) {
    return this.getPriority().compareTo(o.getPriority());
}
}
