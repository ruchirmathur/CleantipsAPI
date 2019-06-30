package com.cleantips.s3.bucket.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class PublicAccessBlockConfiguration {
private boolean BlockPublicAcls;
private boolean BlockPublicPolicy;
private boolean IgnorePublicAcls;
public boolean isBlockPublicAcls() {
	return BlockPublicAcls;
}
public void setBlockPublicAcls(boolean blockPublicAcls) {
	BlockPublicAcls = blockPublicAcls;
}
public boolean isBlockPublicPolicy() {
	return BlockPublicPolicy;
}
public void setBlockPublicPolicy(boolean blockPublicPolicy) {
	BlockPublicPolicy = blockPublicPolicy;
}
public boolean isIgnorePublicAcls() {
	return IgnorePublicAcls;
}
public void setIgnorePublicAcls(boolean ignorePublicAcls) {
	IgnorePublicAcls = ignorePublicAcls;
}
public boolean isRestrictPublicBuckets() {
	return RestrictPublicBuckets;
}
public void setRestrictPublicBuckets(boolean restrictPublicBuckets) {
	RestrictPublicBuckets = restrictPublicBuckets;
}
private boolean RestrictPublicBuckets;


}
