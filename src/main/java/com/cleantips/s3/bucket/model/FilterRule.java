package com.cleantips.s3.bucket.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class FilterRule {
	
private String Bucket;
private boolean IncludeCookies;
private String Prefix;
public String getBucket() {
	return Bucket;
}
public void setBucket(String bucket) {
	Bucket = bucket;
}
public boolean isIncludeCookies() {
	return IncludeCookies;
}
public void setIncludeCookies(boolean includeCookies) {
	IncludeCookies = includeCookies;
}
public String getPrefix() {
	return Prefix;
}
public void setPrefix(String prefix) {
	Prefix = prefix;
}
}
