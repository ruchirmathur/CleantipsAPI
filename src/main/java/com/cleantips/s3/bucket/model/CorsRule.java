package com.cleantips.s3.bucket.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class CorsRule {
	private ArrayList<String> AllowedHeaders;
	private ArrayList<String> AllowedMethods;
	private ArrayList<String> AllowedOrigins;
	private ArrayList<String> ExposedHeaders;
	private String Id;
	private int MaxAge;
	public ArrayList<String> getAllowedHeaders() {
		return AllowedHeaders;
	}
	public void setAllowedHeaders(ArrayList<String> allowedHeaders) {
		AllowedHeaders = allowedHeaders;
	}
	public ArrayList<String> getAllowedMethods() {
		return AllowedMethods;
	}
	public void setAllowedMethods(ArrayList<String> allowedMethods) {
		AllowedMethods = allowedMethods;
	}
	public ArrayList<String> getAllowedOrigins() {
		return AllowedOrigins;
	}
	public void setAllowedOrigins(ArrayList<String> allowedOrigins) {
		AllowedOrigins = allowedOrigins;
	}
	public ArrayList<String> getExposedHeaders() {
		return ExposedHeaders;
	}
	public void setExposedHeaders(ArrayList<String> exposedHeaders) {
		ExposedHeaders = exposedHeaders;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public int getMaxAge() {
		return MaxAge;
	}
	public void setMaxAge(int maxAge) {
		MaxAge = maxAge;
	}
	
}
