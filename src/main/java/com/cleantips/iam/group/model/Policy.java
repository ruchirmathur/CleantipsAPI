package com.cleantips.iam.group.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Policy {
public String getPolicyName() {
		return PolicyName;
	}
	public void setPolicyName(String policyName) {
		PolicyName = policyName;
	}
	public PolicyDocument getPolicyDocument() {
		return PolicyDocument;
	}
	public void setPolicyDocument(PolicyDocument policyDocument) {
		PolicyDocument = policyDocument;
	}
private String PolicyName;
private PolicyDocument PolicyDocument;
}
