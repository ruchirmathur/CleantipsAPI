package com.cleantips.cloudfront.base.model;

import com.cleantips.ec2.instance.model.Parameter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Parameters<T> {
@JsonProperty("InstanceType")
private Parameter InstanceType;
@JsonProperty("VPC")
private Parameter VPC;
@JsonProperty("Subnet")
private Parameter Subnet;
@JsonProperty("InstanceType")
public Parameter getInstanceType() {
	return InstanceType;
}
public void setInstanceType(Parameter instanceType) {
	InstanceType = instanceType;
}
@JsonProperty("VPC")
public Parameter getVPC() {
	return VPC;
}
public void setVPC(Parameter vPC) {
	VPC = vPC;
}
@JsonProperty("Subnet")
public Parameter getSubnet() {
	return Subnet;
}
public void setSubnet(Parameter subnet) {
	Subnet = subnet;
}
@JsonProperty("SecurityGroup")
public Parameter getSecurityGroup() {
	return SecurityGroup;
}
public void setSecurityGroup(Parameter securityGroup) {
	SecurityGroup = securityGroup;
}
@JsonProperty("InternetGateway")
public Parameter getInternetGateway() {
	return InternetGateway;
}
public void setInternetGateway(Parameter internetGateway) {
	InternetGateway = internetGateway;
}
@JsonProperty("ImageType")
public Parameter getImageType() {
	return ImageType;
}
public void setImageType(Parameter imageType) {
	ImageType = imageType;
}
@JsonProperty("SecurityGroup")
private Parameter SecurityGroup;
@JsonProperty("InternetGateway")
private Parameter InternetGateway;
@JsonProperty("KeyName")
public Parameter getKeyName() {
	return KeyName;
}
public void setKeyName(Parameter keyName) {
	KeyName = keyName;
}
@JsonProperty("ImageType")
private Parameter ImageType;
@JsonProperty("KeyName")
private Parameter KeyName;

}
