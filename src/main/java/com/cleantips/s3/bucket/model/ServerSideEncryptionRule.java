package com.cleantips.s3.bucket.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class ServerSideEncryptionRule {
private ServerSideEncryptionByDefault ServerSideEncryptionByDefault;

public ServerSideEncryptionByDefault getServerSideEncryptionByDefault() {
	return ServerSideEncryptionByDefault;
}

public void setServerSideEncryptionByDefault(ServerSideEncryptionByDefault serverSideEncryptionByDefault) {
	ServerSideEncryptionByDefault = serverSideEncryptionByDefault;
}
}
