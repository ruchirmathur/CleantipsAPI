package com.cleantips.cloudfront.distribution.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class CustomErrorResponses {
private double ErrorCachingMinTTL;
private int ErrorCode;
private int ResponseCode;
public double getErrorCachingMinTTL() {
	return ErrorCachingMinTTL;
}
public void setErrorCachingMinTTL(double errorCachingMinTTL) {
	ErrorCachingMinTTL = errorCachingMinTTL;
}
public int getErrorCode() {
	return ErrorCode;
}
public void setErrorCode(int errorCode) {
	ErrorCode = errorCode;
}
public int getResponseCode() {
	return ResponseCode;
}
public void setResponseCode(int responseCode) {
	ResponseCode = responseCode;
}
public String getResponsePagePath() {
	return ResponsePagePath;
}
public void setResponsePagePath(String responsePagePath) {
	ResponsePagePath = responsePagePath;
}
private String ResponsePagePath;
}
