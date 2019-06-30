package com.cleantips.s3.bucket.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class RedirectAllRequestsTo {
private String HostName;
private String Protocol;
public String getHostName() {
	return HostName;
}
public void setHostName(String hostName) {
	HostName = hostName;
}
public String getProtocol() {
	return Protocol;
}
public void setProtocol(String protocol) {
	Protocol = protocol;
}
}
