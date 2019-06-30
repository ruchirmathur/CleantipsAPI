package com.cleantips.s3.bucket.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class S3KeyFilter {
private ArrayList<FilterRule> Rules;

public ArrayList<FilterRule> getRules() {
	return Rules;
}

public void setRules(ArrayList<FilterRule> rules) {
	Rules = rules;
}
}
