package com.cleantips.ec2.instance.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class SecurityGroups {
private ArrayList<String> SecurityGroups;

public ArrayList<String> getSecurityGroups() {
	return SecurityGroups;
}

public void setSecurityGroups(ArrayList<String> securityGroups) {
	SecurityGroups = securityGroups;
}
}
