package com.cleantips.ec2.instance.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Instance<T> {
private String Type="AWS::EC2::Instance";
private Properties Properties;
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
