package com.cleantips.s3.bucket.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class RedirectRule {
private String HostName;
private String HttpRedirectCode;
private String Protocol;
public String getHostName() {
	return HostName;
}
public void setHostName(String hostName) {
	HostName = hostName;
}
public String getHttpRedirectCode() {
	return HttpRedirectCode;
}
public void setHttpRedirectCode(String httpRedirectCode) {
	HttpRedirectCode = httpRedirectCode;
}
public String getProtocol() {
	return Protocol;
}
public void setProtocol(String protocol) {
	Protocol = protocol;
}
public String getReplaceKeyPrefixWith() {
	return ReplaceKeyPrefixWith;
}
public void setReplaceKeyPrefixWith(String replaceKeyPrefixWith) {
	ReplaceKeyPrefixWith = replaceKeyPrefixWith;
}
public String getReplaceKeyWith() {
	return ReplaceKeyWith;
}
public void setReplaceKeyWith(String replaceKeyWith) {
	ReplaceKeyWith = replaceKeyWith;
}
private String ReplaceKeyPrefixWith;
private String ReplaceKeyWith;
}
