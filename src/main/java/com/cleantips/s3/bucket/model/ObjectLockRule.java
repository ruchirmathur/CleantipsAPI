package com.cleantips.s3.bucket.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class ObjectLockRule {
private DefaultRetention DefaultRetention;

public DefaultRetention getDefaultRetention() {
	return DefaultRetention;
}

public void setDefaultRetention(DefaultRetention defaultRetention) {
	DefaultRetention = defaultRetention;
}
}
