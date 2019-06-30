package com.cleantips.s3.bucket.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Destination {
private String BucketAccountId;
private String BucketArn;
private String Format;
public String getBucketAccountId() {
	return BucketAccountId;
}
public void setBucketAccountId(String bucketAccountId) {
	BucketAccountId = bucketAccountId;
}
public String getBucketArn() {
	return BucketArn;
}
public void setBucketArn(String bucketArn) {
	BucketArn = bucketArn;
}
public String getFormat() {
	return Format;
}
public void setFormat(String format) {
	Format = format;
}
public String getPrefix() {
	return Prefix;
}
public void setPrefix(String prefix) {
	Prefix = prefix;
}
private String Prefix;
}
