package com.cleantips.s3.bucket.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class NotificationFilter {
private S3KeyFilter S3Key;

public S3KeyFilter getS3Key() {
	return S3Key;
}

public void setS3Key(S3KeyFilter s3Key) {
	S3Key = s3Key;
}
}
