package com.cleantips.cloudfront.distribution.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class ViewerCertificate {
private String AcmCertificateArn;
private boolean CloudFrontDefaultCertificate;
private String IamCertificateId;
public String getAcmCertificateArn() {
	return AcmCertificateArn;
}
public void setAcmCertificateArn(String acmCertificateArn) {
	AcmCertificateArn = acmCertificateArn;
}
public boolean isCloudFrontDefaultCertificate() {
	return CloudFrontDefaultCertificate;
}
public void setCloudFrontDefaultCertificate(boolean cloudFrontDefaultCertificate) {
	CloudFrontDefaultCertificate = cloudFrontDefaultCertificate;
}
public String getIamCertificateId() {
	return IamCertificateId;
}
public void setIamCertificateId(String iamCertificateId) {
	IamCertificateId = iamCertificateId;
}
public String getMinimumProtocolVersion() {
	return MinimumProtocolVersion;
}
public void setMinimumProtocolVersion(String minimumProtocolVersion) {
	MinimumProtocolVersion = minimumProtocolVersion;
}
public String getSslSupportMethod() {
	return SslSupportMethod;
}
public void setSslSupportMethod(String sslSupportMethod) {
	SslSupportMethod = sslSupportMethod;
}
private String MinimumProtocolVersion;
private String SslSupportMethod;
}
