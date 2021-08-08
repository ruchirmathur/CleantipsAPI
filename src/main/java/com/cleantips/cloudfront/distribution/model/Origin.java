package com.cleantips.cloudfront.distribution.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Origin {
public CustomOriginConfig getCustomOriginConfig() {
		return CustomOriginConfig;
	}
	public void setCustomOriginConfig(CustomOriginConfig customOriginConfig) {
		CustomOriginConfig = customOriginConfig;
	}
	public String getDomainName() {
		return DomainName;
	}
	public void setDomainName(String domainName) {
		DomainName = domainName;
	}

	public Ref getId() {
		return Id;
	}
	public void setId(Ref id) {
		Id = id;
	}
	public ArrayList<OriginCustomHeader> getOriginCustomHeaders() {
		return OriginCustomHeaders;
	}
	public void setOriginCustomHeaders(ArrayList<OriginCustomHeader> originCustomHeaders) {
		OriginCustomHeaders = originCustomHeaders;
	}
	public String getOriginPath() {
		return OriginPath;
	}
	public void setOriginPath(String originPath) {
		OriginPath = originPath;
	}
	public S3OriginConfig getS3OriginConfig() {
		return S3OriginConfig;
	}
	public void setS3OriginConfig(S3OriginConfig s3OriginConfig) {
		S3OriginConfig = s3OriginConfig;
	}
private CustomOriginConfig CustomOriginConfig;
private String DomainName;
private Ref Id;
private ArrayList<OriginCustomHeader> OriginCustomHeaders;
private String OriginPath;
private S3OriginConfig  S3OriginConfig;
}
