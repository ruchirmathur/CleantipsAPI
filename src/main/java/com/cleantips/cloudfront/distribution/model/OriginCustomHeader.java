package com.cleantips.cloudfront.distribution.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class OriginCustomHeader {
private String HeaderName;
private String HeaderValue;
public String getHeaderName() {
	return HeaderName;
}
public void setHeaderName(String headerName) {
	HeaderName = headerName;
}
public String getHeaderValue() {
	return HeaderValue;
}
public void setHeaderValue(String headerValue) {
	HeaderValue = headerValue;
}
}
