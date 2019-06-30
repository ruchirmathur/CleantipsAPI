package com.cleantips.vpc.base.model;

import com.cleantips.vpc.subnet.model.Ref;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Outputs {
private Ref Subnet;
private Ref VPC;
private Ref SecurityGroup;
public Ref getSubnet() {
	return Subnet;
}
public void setSubnet(Ref subnet) {
	Subnet = subnet;
}
public Ref getSecurityGroup() {
	return SecurityGroup;
}
public void setSecurityGroup(Ref securityGroup) {
	SecurityGroup = securityGroup;
}
public Ref getVPC() {
	return VPC;
}
public void setVPC(Ref vPC) {
	VPC = vPC;
}
public Ref getInternetGateway() {
	return InternetGateway;
}
public void setInternetGateway(Ref internetGateway) {
	InternetGateway = internetGateway;
}
private Ref InternetGateway;

}
