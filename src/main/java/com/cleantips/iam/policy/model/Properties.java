package com.cleantips.iam.policy.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Properties {
private ArrayList<String> GroupName;
private PolicyDocument PolicyDocument;
private String PolicyName;
public PolicyDocument getPolicyDocument() {
	return PolicyDocument;
}

public void setPolicyDocument(PolicyDocument policyDocument) {
	PolicyDocument = policyDocument;
}

private ArrayList<String> Roles;

public ArrayList<String> getGroupName() {
	return GroupName;
}

public void setGroupName(ArrayList<String> groupName) {
	GroupName = groupName;
}


public String getPolicyName() {
	return PolicyName;
}

public void setPolicyName(String policyName) {
	PolicyName = policyName;
}

public ArrayList<String> getRoles() {
	return Roles;
}

public void setRoles(ArrayList<String> roles) {
	Roles = roles;
}

public ArrayList<String> getUsers() {
	return Users;
}

public void setUsers(ArrayList<String> users) {
	Users = users;
}

private ArrayList<String> Users;
}
