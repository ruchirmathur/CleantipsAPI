package com.cleantips.iam.group.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Properties {
private String GroupName;
private String Path;
public String getGroupName() {
	return GroupName;
}
public void setGroupName(String groupName) {
	GroupName = groupName;
}
public String getPath() {
	return Path;
}
public void setPath(String path) {
	Path = path;
}
public ArrayList<Policy> getPolicies() {
	return Policies;
}
public void setPolicies(ArrayList<Policy> policies) {
	Policies = policies;
}
private ArrayList<Policy> Policies;
}
