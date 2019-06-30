package com.cleantips.model;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Properties {
private String TemplateURL;
private HashMap Parameters;
private String TimeoutInMinutes;
public String getTimeoutInMinutes() {
	return TimeoutInMinutes;
}
public void setTimeoutInMinutes(String timeoutInMinutes) {
	TimeoutInMinutes = timeoutInMinutes;
}
public String getTemplateURL() {
	return TemplateURL;
}
public void setTemplateURL(String templateURL) {
	TemplateURL = templateURL;
}
public HashMap getParameters() {
	return Parameters;
}
public void setParameters(HashMap parameters) {
	Parameters = parameters;
}

}
