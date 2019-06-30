package com.cleantips.vpc.securitygroupegress.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Properties {
private String CidrIp;
private String CidrIpv6;
private String Description;
private String DestinationPrefixListId;
public String getCidrIp() {
	return CidrIp;
}
public void setCidrIp(String cidrIp) {
	CidrIp = cidrIp;
}
public String getCidrIpv6() {
	return CidrIpv6;
}
public void setCidrIpv6(String cidrIpv6) {
	CidrIpv6 = cidrIpv6;
}
public String getDescription() {
	return Description;
}
public String getDestinationPrefixListId() {
	return DestinationPrefixListId;
}
public void setDestinationPrefixListId(String destinationPrefixListId) {
	DestinationPrefixListId = destinationPrefixListId;
}
public void setDescription(String description) {
	Description = description;
}
public String getDestinationSecurityGroupId() {
	return DestinationSecurityGroupId;
}
public void setDestinationSecurityGroupId(String destinationSecurityGroupId) {
	DestinationSecurityGroupId = destinationSecurityGroupId;
}
public String getFromPort() {
	return FromPort;
}
public void setFromPort(String fromPort) {
	FromPort = fromPort;
}
public String getGroupId() {
	return GroupId;
}
public void setGroupId(String groupId) {
	GroupId = groupId;
}
public String getIpProtocol() {
	return IpProtocol;
}
public void setIpProtocol(String ipProtocol) {
	IpProtocol = ipProtocol;
}
public int getToPort() {
	return ToPort;
}
public void setToPort(int toPort) {
	ToPort = toPort;
}
private String DestinationSecurityGroupId;
private String FromPort;
private String GroupId;
private String IpProtocol;
private int ToPort;
}
