package com.cleantips.cloudfront.distribution.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class ForwardedValues {
private Cookies Cookies;
private ArrayList<String> Headers;
private boolean QueryString;
private ArrayList<String> QueryStringCacheKeys;
public Cookies getCookies() {
	return Cookies;
}
public void setCookies(Cookies cookies) {
	Cookies = cookies;
}
public ArrayList<String> getHeaders() {
	return Headers;
}
public void setHeaders(ArrayList<String> headers) {
	Headers = headers;
}
public boolean isQueryString() {
	return QueryString;
}
public void setQueryString(boolean queryString) {
	QueryString = queryString;
}
public ArrayList<String> getQueryStringCacheKeys() {
	return QueryStringCacheKeys;
}
public void setQueryStringCacheKeys(ArrayList<String> queryStringCacheKeys) {
	QueryStringCacheKeys = queryStringCacheKeys;
}
}
