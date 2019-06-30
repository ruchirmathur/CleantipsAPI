package com.cleantips.ec2.instance.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class CreditSpecification {

@JsonProperty("CPUCredits")
private String CPUCredits;
@JsonProperty("CPUCredits")
public String getCPUCredits() {
	return CPUCredits;
}
@JsonProperty("CPUCredits")
public void setCPUCredits(String cPUCredits) {
	CPUCredits = cPUCredits;
}
}
