package com.cleantips.s3.base.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Resources {

private com.cleantips.s3.bucket.model.Bucket Bucket;

public com.cleantips.s3.bucket.model.Bucket getBucket() {
	return Bucket;
}

public void setBucket(com.cleantips.s3.bucket.model.Bucket bucket) {
	Bucket = bucket;
}


}
