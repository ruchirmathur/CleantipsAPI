package com.cleantips.iam.policy.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Statement {
private String Effect;
private ArrayList Action;
private String Resource;
public String getEffect() {
	return Effect;
}
public void setEffect(String effect) {
	Effect = effect;
}
public ArrayList getAction() {
	return Action;
}
public void setAction(ArrayList action) {
	Action = action;
}
public String getResource() {
	return Resource;
}
public void setResource(String resource) {
	Resource = resource;
}
}
