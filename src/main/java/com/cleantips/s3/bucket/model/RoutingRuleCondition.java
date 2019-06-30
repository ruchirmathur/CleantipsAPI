package com.cleantips.s3.bucket.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class RoutingRuleCondition {
private String HttpErrorCodeReturnedEquals;
private String KeyPrefixEquals;
public String getHttpErrorCodeReturnedEquals() {
	return HttpErrorCodeReturnedEquals;
}
public void setHttpErrorCodeReturnedEquals(String httpErrorCodeReturnedEquals) {
	HttpErrorCodeReturnedEquals = httpErrorCodeReturnedEquals;
}
public String getKeyPrefixEquals() {
	return KeyPrefixEquals;
}
public void setKeyPrefixEquals(String keyPrefixEquals) {
	KeyPrefixEquals = keyPrefixEquals;
}
}
