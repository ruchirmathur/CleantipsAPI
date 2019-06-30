package com.cleantips.s3.bucket.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class NoncurrentVersionTransition {
private String OriginAccessIdentity;

public String getOriginAccessIdentity() {
	return OriginAccessIdentity;
}

public void setOriginAccessIdentity(String originAccessIdentity) {
	OriginAccessIdentity = originAccessIdentity;
}
}
