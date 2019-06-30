package com.cleantips.s3.bucket.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class ServerSideEncryptionByDefault {
private String KMSMasterKeyID;
private String SSEAlgorithm;
public String getKMSMasterKeyID() {
	return KMSMasterKeyID;
}
public void setKMSMasterKeyID(String kMSMasterKeyID) {
	KMSMasterKeyID = kMSMasterKeyID;
}
public String getSSEAlgorithm() {
	return SSEAlgorithm;
}
public void setSSEAlgorithm(String sSEAlgorithm) {
	SSEAlgorithm = sSEAlgorithm;
}
}
