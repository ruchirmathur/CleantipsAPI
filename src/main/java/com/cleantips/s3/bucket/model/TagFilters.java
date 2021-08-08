package com.cleantips.s3.bucket.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class TagFilters {
private String Key;
public String getKey() {
	return Key;
}
public void setKey(String key) {
	Key = key;
}
public String getValue() {
	return Value;
}
public void setValue(String value) {
	Value = value;
}
private String Value;
}
