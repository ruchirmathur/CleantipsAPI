package com.cleantips.ec2.instance.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class SecurityGroupIds {
private ArrayList<String>  SecurityGroupIds;

public ArrayList<String> getSecurityGroupIds() {
	return SecurityGroupIds;
}

public void setSecurityGroupIds(ArrayList<String> securityGroupIds) {
	SecurityGroupIds = securityGroupIds;
}
}
