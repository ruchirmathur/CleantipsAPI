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
public int getDefaultTTL() {
	return DefaultTTL;
}
public void setDefaultTTL(int defaultTTL) {
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
public int getMaxTTL() {
	return MaxTTL;
}
public void setMaxTTL(int maxTTL) {
	MaxTTL = maxTTL;
}
public int getMinTTL() {
	return MinTTL;
}
public void setMinTTL(int minTTL) {
	MinTTL = minTTL;
}
public boolean isSmoothStreaming() {
	return SmoothStreaming;
}
public void setSmoothStreaming(boolean smoothStreaming) {
	SmoothStreaming = smoothStreaming;
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
public Ref getTargetOriginId() {
	return TargetOriginId;
}
public void setTargetOriginId(Ref targetOriginId) {
	TargetOriginId = targetOriginId;
}
public void setViewerProtocolPolicy(String viewerProtocolPolicy) {
	ViewerProtocolPolicy = viewerProtocolPolicy;
}
private int DefaultTTL;
private String FieldLevelEncryptionId;
private ForwardedValues ForwardedValues;
private ArrayList<LambdaFunctionAssociations> LambdaFunctionAssociation;
private int MaxTTL;
private int MinTTL;
private boolean SmoothStreaming;
private Ref TargetOriginId;
private ArrayList<String> TrustedSigners;
private String ViewerProtocolPolicy;
}
