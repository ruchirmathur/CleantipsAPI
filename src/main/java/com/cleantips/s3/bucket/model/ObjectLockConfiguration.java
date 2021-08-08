package com.cleantips.s3.bucket.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class ObjectLockConfiguration {
private String ObjectLockEnabled;
private ObjectLockRule Rule;
public String getObjectLockEnabled() {
	return ObjectLockEnabled;
}
public void setObjectLockEnabled(String objectLockEnabled) {
	ObjectLockEnabled = objectLockEnabled;
}
}
