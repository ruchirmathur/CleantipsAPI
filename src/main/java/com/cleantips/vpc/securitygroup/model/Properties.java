package com.cleantips.vpc.securitygroup.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Properties {
private String GroupName;
private String GroupDescription;
private ArrayList<com.cleantips.vpc.securitygroupegress.model.SecurityGroupEgress> SecurityGroupEgress;
private ArrayList<com.cleantips.vpc.securitygroupingress.model.SecurityGroupIngress> SecurityGroupIngress;
private String VpcId;
public String getGroupName() {
	return GroupName;
}
public void setGroupName(String groupName) {
	GroupName = groupName;
}
public String getGroupDescription() {
	return GroupDescription;
}
public void setGroupDescription(String groupDescription) {
	GroupDescription = groupDescription;
}
public ArrayList<com.cleantips.vpc.securitygroupegress.model.SecurityGroupEgress> getSecurityGroupEgress() {
	return SecurityGroupEgress;
}
public void setSecurityGroupEgress(
		ArrayList<com.cleantips.vpc.securitygroupegress.model.SecurityGroupEgress> securityGroupEgress) {
	SecurityGroupEgress = securityGroupEgress;
}
public ArrayList<com.cleantips.vpc.securitygroupingress.model.SecurityGroupIngress> getSecurityGroupIngress() {
	return SecurityGroupIngress;
}
public void setSecurityGroupIngress(
		ArrayList<com.cleantips.vpc.securitygroupingress.model.SecurityGroupIngress> securityGroupIngress) {
	SecurityGroupIngress = securityGroupIngress;
}
public String getVpcId() {
	return VpcId;
}
public void setVpcId(String vpcId) {
	VpcId = vpcId;
}
}