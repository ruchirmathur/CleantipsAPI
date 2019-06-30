package com.cleantips.s3.bucket.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class MetricsConfiguration {
private String StorageClass;
private int TransitionInDays;
public String getStorageClass() {
	return StorageClass;
}
public void setStorageClass(String storageClass) {
	StorageClass = storageClass;
}
public int getTransitionInDays() {
	return TransitionInDays;
}
public void setTransitionInDays(int transitionInDays) {
	TransitionInDays = transitionInDays;
}

}
