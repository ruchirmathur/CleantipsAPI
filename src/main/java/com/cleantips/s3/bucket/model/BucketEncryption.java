package com.cleantips.s3.bucket.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class BucketEncryption {
private ArrayList<ServerSideEncryptionRule> ServerSideEncryptionConfiguration;

public ArrayList<ServerSideEncryptionRule> getServerSideEncryptionConfiguration() {
	return ServerSideEncryptionConfiguration;
}

public void setServerSideEncryptionConfiguration(
		ArrayList<ServerSideEncryptionRule> serverSideEncryptionConfiguration) {
	ServerSideEncryptionConfiguration = serverSideEncryptionConfiguration;
}

}
