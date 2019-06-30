package com.cleantips.cloudfront.distribution.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class DefaultCacheBehavior {
private ArrayList<String> AllowedMethods;
private ArrayList<String> CachedMethods;
private boolean Compress;
public ArrayList<String> getAllowedMethods() {
	return AllowedMethods;
}
public void setAllowedMethods(ArrayList<String> allowedMethods) {
	AllowedMethods = allowedMethods;
}
public ArrayList<String> getCachedMethods() {
	return CachedMethods;
}
public void setCachedMethods(ArrayList<String> cachedMethods) {
	CachedMethods = cachedMethods;
}
public boolean isCompress() {
	return Compress;
}
public void setCompress(boolean compress) {
	Compress = compress;
}
public double getDefaultTTL() {
	return DefaultTTL;
}
public void setDefaultTTL(double defaultTTL) {
	DefaultTTL = defaultTTL;
}
public String getFieldLevelEncryptionId() {
	return FieldLevelEncryptionId;
}
public void setFieldLevelEncryptionId(String fieldLevelEncryptionId) {
	FieldLevelEncryptionId = fieldLevelEncryptionId;
}
public ForwardedValues getForwardedValues() {
	return ForwardedValues;
}
public void setForwardedValues(ForwardedValues forwardedValues) {
	ForwardedValues = forwardedValues;
}
public ArrayList<LambdaFunctionAssociations> getLambdaFunctionAssociation() {
	return LambdaFunctionAssociation;
}
public void setLambdaFunctionAssociation(ArrayList<LambdaFunctionAssociations> lambdaFunctionAssociation) {
	LambdaFunctionAssociation = lambdaFunctionAssociation;
}
public double getMaxTTL() {
	return MaxTTL;
}
public void setMaxTTL(double maxTTL) {
	MaxTTL = maxTTL;
}
public double getMinTTL() {
	return MinTTL;
}
public void setMinTTL(double minTTL) {
	MinTTL = minTTL;
}
public boolean isSmoothStreaming() {
	return SmoothStreaming;
}
public void setSmoothStreaming(boolean smoothStreaming) {
	SmoothStreaming = smoothStreaming;
}
public String getTargetOriginId() {
	return TargetOriginId;
}
public void setTargetOriginId(String targetOriginId) {
	TargetOriginId = targetOriginId;
}
public ArrayList<String> getTrustedSigners() {
	return TrustedSigners;
}
public void setTrustedSigners(ArrayList<String> trustedSigners) {
	TrustedSigners = trustedSigners;
}
public String getViewerProtocolPolicy() {
	return ViewerProtocolPolicy;
}
public void setViewerProtocolPolicy(String viewerProtocolPolicy) {
	ViewerProtocolPolicy = viewerProtocolPolicy;
}
private double DefaultTTL;
private String FieldLevelEncryptionId;
private ForwardedValues ForwardedValues;
private ArrayList<LambdaFunctionAssociations> LambdaFunctionAssociation;
private double MaxTTL;
private double MinTTL;
private boolean SmoothStreaming;
private String TargetOriginId;
private ArrayList<String> TrustedSigners;
private String ViewerProtocolPolicy;
}
