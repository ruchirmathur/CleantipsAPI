package com.cleantips.ec2.instance.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class ElasticGpuSpecifications {
private String type;

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}
}
