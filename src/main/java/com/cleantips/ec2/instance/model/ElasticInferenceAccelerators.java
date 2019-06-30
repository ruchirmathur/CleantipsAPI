package com.cleantips.ec2.instance.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class ElasticInferenceAccelerators {
	private String Type;

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}
}
