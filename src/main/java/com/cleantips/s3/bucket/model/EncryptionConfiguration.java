package com.cleantips.s3.bucket.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class EncryptionConfiguration {
private String Name;
private String Value;
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getValue() {
	return Value;
}
public void setValue(String value) {
	Value = value;
}
}
