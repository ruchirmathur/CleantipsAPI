package com.cleantips.vpc.eip.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class EIP {
private String Type = "AWS::EC2::EIP";
private Properties Properties;
@JsonProperty("DependsOn")
private String DependsOn;
@JsonProperty("DependsOn")
public String getDependsOn() {
	return DependsOn;
}
public void setDependsOn(String dependsOn) {
	DependsOn = dependsOn;
}
public String getType() {
	return Type;
}
public void setType(String type) {
	Type = type;
}
public Properties getProperties() {
	return Properties;
}
public void setProperties(Properties properties) {
	Properties = properties;
}
}
