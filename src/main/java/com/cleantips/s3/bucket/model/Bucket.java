package com.cleantips.s3.bucket.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Bucket {
	private String Type = "AWS::S3::Bucket";
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public Properties getProperties() {
		return Properties;
	}
	public void setProperties(Properties properties) {
		Properties = properties;
	}
	private Properties Properties;
}
