package com.cleantips.cloudfront.distribution.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Cookies {
private String Forward;
public String getForward() {
	return Forward;
}
public void setForward(String forward) {
	Forward = forward;
}
public ArrayList<String> getWhitelistedNames() {
	return WhitelistedNames;
}
public void setWhitelistedNames(ArrayList<String> whitelistedNames) {
	WhitelistedNames = whitelistedNames;
}
private ArrayList<String> WhitelistedNames;
}
