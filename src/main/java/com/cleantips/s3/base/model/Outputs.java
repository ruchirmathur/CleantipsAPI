package com.cleantips.s3.base.model;

import java.util.Map;

import com.cleantips.s3.bucket.model.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Outputs {
	private Map Bucket;

	public Map getBucket() {
		return Bucket;
	}

	public void setBucket(Map bucket) {
		Bucket = bucket;
	}


}
