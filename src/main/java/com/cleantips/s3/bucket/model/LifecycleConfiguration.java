package com.cleantips.s3.bucket.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class LifecycleConfiguration {
	private ArrayList<Rule> Rules;

	public ArrayList<Rule> getRules() {
		return Rules;
	}

	public void setRules(ArrayList<Rule> rules) {
		Rules = rules;
	}

}
