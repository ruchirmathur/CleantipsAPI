package com.cleantips.vpc.subnet.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Properties {
private boolean AssignIpv6AddressOnCreation;
private String AvailabilityZone;
private Ref CidrBlock;

private String Ipv6CidrBlock;
private String MapPublicIpOnLaunch;
public Ref getCidrBlock() {
	return CidrBlock;
}
public void setCidrBlock(Ref cidrBlock) {
	CidrBlock = cidrBlock;
}
private Ref VpcId;

public boolean isAssignIpv6AddressOnCreation() {
	return AssignIpv6AddressOnCreation;
}
public void setAssignIpv6AddressOnCreation(boolean assignIpv6AddressOnCreation) {
	AssignIpv6AddressOnCreation = assignIpv6AddressOnCreation;
}
public String getAvailabilityZone() {
	return AvailabilityZone;
}
public void setAvailabilityZone(String availabilityZone) {
	AvailabilityZone = availabilityZone;
}
public String getIpv6CidrBlock() {
	return Ipv6CidrBlock;
}
public void setIpv6CidrBlock(String ipv6CidrBlock) {
	Ipv6CidrBlock = ipv6CidrBlock;
}
public String getMapPublicIpOnLaunch() {
	return MapPublicIpOnLaunch;
}
public void setMapPublicIpOnLaunch(String mapPublicIpOnLaunch) {
	MapPublicIpOnLaunch = mapPublicIpOnLaunch;
}
public Ref getVpcId() {
	return VpcId;
}
public void setVpcId(Ref vpcId) {
	VpcId = vpcId;
}
}
