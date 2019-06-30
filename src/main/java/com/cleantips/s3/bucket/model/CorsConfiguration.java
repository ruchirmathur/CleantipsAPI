package com.cleantips.s3.bucket.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class CorsConfiguration {
	private ArrayList<CorsRule> CorsRules;

	public ArrayList<CorsRule> getCorsRules() {
		return CorsRules;
	}

	public void setCorsRules(ArrayList<CorsRule> corsRules) {
		CorsRules = corsRules;
	}
	
}