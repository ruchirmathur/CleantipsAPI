package com.cleantips.s3.bucket.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class ReplicationConfiguration {
private String Role;
public String getRole() {
	return Role;
}
public void setRole(String role) {
	Role = role;
}
public ArrayList<ReplicationRule> getRules() {
	return Rules;
}
public void setRules(ArrayList<ReplicationRule> rules) {
	Rules = rules;
}
private ArrayList<ReplicationRule> Rules;
}
